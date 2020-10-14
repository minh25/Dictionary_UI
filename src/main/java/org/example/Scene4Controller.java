package org.example;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
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


public class Scene4Controller {
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

    public Scene4Controller() throws IOException {
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

    public void show_meaning_onMouseClicked(MouseEvent mouseEvent) throws IOException {
//        String key = search_text_field.getText();
//        Get get = new Get();
//        Word word = get.GetWord(key);
//
//        System.out.println(word._target);
//        System.out.println(word._content);
//
//        Label label = new Label();
//        label.setText(word._content);
//        label.setWrapText(true);
//        AnchorPane.setTopAnchor(label, 0.0);
//        AnchorPane.setLeftAnchor(label, 0.0);
//        AnchorPane.setRightAnchor(label, 0.0);
//        AnchorPane.setBottomAnchor(label, 0.0);
//
//        show_meaning_pane_child.getChildren().removeAll();
//        show_meaning_pane_child.getChildren().add(label);
        String key = search_text_field.getText();
        Get get = new Get();
        Word word = get.GetWord(key);

        System.out.println(word._target);
        System.out.println(word._content);

        TextArea textArea = new TextArea();
        textArea.setText(word._content);
        textArea.setWrapText(true);
        textArea.setEditable(false);
        AnchorPane.setTopAnchor(textArea, 0.0);
        AnchorPane.setLeftAnchor(textArea, 0.0);
        AnchorPane.setRightAnchor(textArea, 0.0);
        AnchorPane.setBottomAnchor(textArea, 0.0);

        show_meaning_pane_child.getChildren().removeAll();
        show_meaning_pane_child.getChildren().add(textArea);
    }
}
