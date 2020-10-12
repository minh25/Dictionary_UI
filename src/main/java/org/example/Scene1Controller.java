package org.example;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

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
                public Label show_meaning_label;
            public AnchorPane voice_pane;
        public Pane close_menu_pane;
        public AnchorPane menu;
            public AnchorPane account_pane;
            public AnchorPane list_pane;
                public AnchorPane dict_pane;
                public AnchorPane open_your_word_pane;
                public AnchorPane info_pane;
                public AnchorPane setting_pane;
                public AnchorPane buy_pane;

    public Scene1Controller() throws IOException {
    }


    public void show_meaning_onKeyTyped(MouseEvent mouseEvent) {
        show_meaning_label.setText(search_text_field.getText());
    }

    public void show_word_onKeyTyped(KeyEvent keyEvent) {
        show_meaning_label.setText(search_text_field.getText());
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
}
