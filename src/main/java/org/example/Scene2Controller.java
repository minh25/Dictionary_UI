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


public class Scene2Controller {
    public AnchorPane root_anchor_pane;
        public AnchorPane your_word_pane;
            public AnchorPane search_bar_pane;
                public Pane open_menu_pane;
            public AnchorPane show_list_word;
                public Label title_text;
                public AnchorPane add_word_pane;
        public Pane close_menu_pane;
        public AnchorPane menu;
            public AnchorPane account_pane;
            public AnchorPane list_pane;
                public AnchorPane dict_pane;
                public AnchorPane open_your_word_pane;
                public AnchorPane info_pane;
                public AnchorPane setting_pane;
                public AnchorPane buy_pane;

    public Scene2Controller() throws IOException {
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
