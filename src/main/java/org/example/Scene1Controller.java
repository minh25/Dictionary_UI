package org.example;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;


public class Scene1Controller {
    public AnchorPane root_anchor_pane;
    public AnchorPane dictionary_pane;
    public AnchorPane search_bar_pane;
    public Pane open_menu_pane;
    public AnchorPane search_pane;
    public TextField search_text_field;
    public Pane search_button_pane;
    public AnchorPane show_meaning_pane;
    public AnchorPane show_meaning_pane_child;
    public Pane close_menu_pane;
    public AnchorPane menu;
    public AnchorPane account_pane;
    public AnchorPane list_pane;
    public AnchorPane dict_pane;
    public AnchorPane open_your_word_pane;
    public AnchorPane open_gg_pane;
    public AnchorPane open_api_pane;
    public AnchorPane setting_pane;
    public AnchorPane buy_pane;

    public Scene1Controller() throws IOException {
    }

    public void set_meaning_webview(String text) {

        WebView webView = new WebView();
        webView.getEngine().loadContent(text, "text/html");

//        webView.getEngine().load("http://google.com");
//        Parent parent = webView;
//        App.scene.setRoot(parent);

        AnchorPane.setTopAnchor(webView, 0.0);
        AnchorPane.setLeftAnchor(webView, 60.0);
        AnchorPane.setRightAnchor(webView, 60.0);
        AnchorPane.setBottomAnchor(webView, 0.0);
        show_meaning_pane_child.getChildren().add(webView);
    }

    public void show_meaning_onMouseClicked(MouseEvent mouseEvent) {

        String word = search_text_field.getText();

        if (word.equals("")) {
            return;
        }

        Dictionary list_word = App.dictionary.Find(word);
        String text = list_word.get(0)._content;

        set_meaning_webview(text);
    }

    public void show_word_onKeyTyped(KeyEvent keyEvent) {
        String _word = search_text_field.getText();

        if (_word.equals("")) {
            return;
        }

        Dictionary list_word = App.dictionary.Find(_word);

        ListView<AnchorPane> listView = new ListView<AnchorPane>();
        AnchorPane.setTopAnchor(listView, 0.0);
        AnchorPane.setLeftAnchor(listView, 60.0);
        AnchorPane.setRightAnchor(listView, 60.0);
        AnchorPane.setBottomAnchor(listView, 40.0);

        ObservableList<AnchorPane> data = FXCollections.observableArrayList();

        for (int i = 0; i < Math.min(list_word.getSize(), 15); i++) {
            Word word = list_word.get(i);

            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefHeight(30);
            anchorPane.setPrefWidth(450);

            WebView webView = new WebView();
            webView.getEngine().loadContent(word._target, "text/html");
            AnchorPane.setBottomAnchor(webView, 0.0);
            AnchorPane.setLeftAnchor(webView, 0.0);
            AnchorPane.setRightAnchor(webView, 0.0);
            AnchorPane.setTopAnchor(webView, 0.0);

            anchorPane.getChildren().addAll(webView);

            webView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    WebView wv = new WebView();
                    wv.getEngine().loadContent(word._content, "text/html");
                    AnchorPane.setBottomAnchor(wv, 0.0);
                    AnchorPane.setLeftAnchor(wv, 60.0);
                    AnchorPane.setRightAnchor(wv, 60.0);
                    AnchorPane.setTopAnchor(wv, 0.0);

                    Pane pane = new Pane();
                    AnchorPane.setBottomAnchor(pane, 40.0);
                    AnchorPane.setRightAnchor(pane, 110.0);
                    pane.setPrefHeight(40);
                    pane.setPrefWidth(40);
//                    pane.setStyle("-fx-background-image: url(\"src/main/resources/org/example/img/voice_image.png\")";
                    pane.getStyleClass().add("voice_pane");

                    pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            try {
                                new GetAudio(word._target);
                                String path = "src/main/resources/org/example/data/" + word._target + ".mp3";
                                Media media = new Media(new File(path).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(media);
                                mediaPlayer.setAutoPlay(true);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    show_meaning_pane_child.getChildren().removeAll();
                    show_meaning_pane_child.getChildren().addAll(wv, pane);
                }
            });


            data.add(anchorPane);
        }
        System.out.println(data.size());
        listView.setItems(data);
        show_meaning_pane_child.getChildren().add(listView);
    }

    public void open_menu_pane(MouseEvent mouseEvent) {
        close_menu_pane.setVisible(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), menu);
        translateTransition.setByX(200);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }

    public void close_menu_pane(MouseEvent mouseEvent) {
        close_menu_pane.setVisible(false);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), menu);
        translateTransition.setByX(-200);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }

    public void open_dictionary_pane(MouseEvent mouseEvent) throws IOException {
        App.setRoot("scene1");
    }

    public void open_your_word_pane(MouseEvent mouseEvent) throws IOException {
        App.setRoot("scene2");
    }

    public void open_gg_pane(MouseEvent mouseEvent) throws IOException {
        App.setRoot("scene3");
    }

    public void open_api_pane(MouseEvent mouseEvent) throws IOException {
        App.setRoot("scene4");
    }
}
