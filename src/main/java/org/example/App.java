package org.example;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;
    public static Dictionary dictionary;
    public static Dictionary your_dictionary = new Dictionary();

    @Override
    public void start(Stage stage) throws IOException, ParseException {

        dictionary = math.LoadJson();
        System.out.println(dictionary.getSize());

        scene = new Scene(loadFXML("scene1"));

        scene.getStylesheets().add(String.valueOf(App.class.getResource("css/root.css")));
        scene.getStylesheets().add(String.valueOf(App.class.getResource("css/menu_pane.css")));
        scene.getStylesheets().add(String.valueOf(App.class.getResource("css/search_bar_pane.css")));
        scene.getStylesheets().add(String.valueOf(App.class.getResource("css/show_meaning_pane.css")));
        scene.getStylesheets().add(String.valueOf(App.class.getResource("css/your_word_pane.css")));
        scene.getStylesheets().add(String.valueOf(App.class.getResource("css/add_word_pane.css")));

        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}