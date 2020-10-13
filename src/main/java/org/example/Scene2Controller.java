package org.example;

import javafx.animation.FillTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;


public class Scene2Controller {
    public AnchorPane root_anchor_pane;
    public AnchorPane your_word_pane;
    public AnchorPane search_bar_pane;
    public Pane open_menu_pane;
    public AnchorPane show_list_word;
    public Label title_text;
    public AnchorPane show_list_your_word_pane;
    public AnchorPane open_add_word_pane;
    public Pane close_add_word_pane;
    public AnchorPane add_word_pane;
    public Rectangle warning_rect;
    public TextField _target;
    public TextField pronunciation;
    public TextField type;
    public TextField note;
    public TextField meaning;
    public Pane add_to_db_pane;
    public Pane close_menu_pane;
    public AnchorPane menu;
    public AnchorPane account_pane;
    public AnchorPane list_pane;
    public AnchorPane dict_pane;
    public AnchorPane open_your_word_pane;
    public AnchorPane open_gg_pane;
    public AnchorPane info_pane;
    public AnchorPane setting_pane;
    public AnchorPane buy_pane;

    public Scene2Controller() throws IOException {
    }

    public void open_menu_pane(MouseEvent mouseEvent) {
        close_menu_pane.setVisible(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(200), menu);
        translateTransition.setByX(200);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }

    public void close_menu_pane(MouseEvent mouseEvent) {
        close_menu_pane.setVisible(false);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(200), menu);
        translateTransition.setByX(-200);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }

    public void show_add_word_pane(MouseEvent mouseEvent) {
        close_add_word_pane.setVisible(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(200), add_word_pane);
        translateTransition.setByY(350);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }

    public void close_add_word_pane(MouseEvent mouseEvent) {
        close_add_word_pane.setVisible(false);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(200), add_word_pane);
        translateTransition.setByY(-350);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }


    public void add_to_db(MouseEvent mouseEvent) {
        String __target = _target.getText();
//        System.out.println(__target);
        String _pronunciation = pronunciation.getText();
        String _type = type.getText();
        String _note = note.getText();
        String _meaning = meaning.getText();

        if (Objects.equals(__target, "")) {
            FillTransition fillTransition = new FillTransition(Duration.millis(50), warning_rect, Color.rgb(16, 151, 255), Color.WHITE);
            fillTransition.setCycleCount(1);
            fillTransition.setAutoReverse(true);
            fillTransition.play();
        } else {
            Word word = new Word(__target);
            word.set_content(_type, _pronunciation, _note, _meaning);
            App.your_dictionary.add(word);

            _target.setText("");
            pronunciation.setText("");
            type.setText("");
            note.setText("");
            meaning.setText("");
        }

        App.your_dictionary.print();
    }

    public void show_your_word_label(MouseEvent mouseEvent) {
        ListView<AnchorPane> listView = new ListView<AnchorPane>();
        AnchorPane.setTopAnchor(listView, 0.0);
        AnchorPane.setLeftAnchor(listView, 60.0);
        AnchorPane.setRightAnchor(listView, 60.0);
        AnchorPane.setBottomAnchor(listView, 40.0);

        ObservableList<AnchorPane> data = FXCollections.observableArrayList();

        for (int i = 0; i < App.your_dictionary.getSize(); i++) {
            Word word = App.your_dictionary.get(i);

            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefHeight(30);
            anchorPane.setPrefWidth(450);

            WebView webView = new WebView();
            webView.getEngine().loadContent(word._target, "text/html");
            AnchorPane.setBottomAnchor(webView, 0.0);
            AnchorPane.setLeftAnchor(webView, 0.0);
            AnchorPane.setRightAnchor(webView, 30.0);
            AnchorPane.setTopAnchor(webView, 0.0);

            Pane pane = new Pane();
            AnchorPane.setBottomAnchor(pane, 0.0);
            AnchorPane.setLeftAnchor(pane, 420.0);
            AnchorPane.setRightAnchor(pane, 0.0);
            AnchorPane.setTopAnchor(pane, 0.0);
            pane.setStyle("-fx-background-color: #ff0000");

            anchorPane.getChildren().addAll(webView, pane);

            webView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    WebView wv = new WebView();
                    wv.getEngine().loadContent(word._content, "text/html");
                    AnchorPane.setBottomAnchor(wv, 0.0);
                    AnchorPane.setLeftAnchor(wv, 60.0);
                    AnchorPane.setRightAnchor(wv, 60.0);
                    AnchorPane.setTopAnchor(wv, 0.0);

                    show_list_your_word_pane.getChildren().removeAll();
                    show_list_your_word_pane.getChildren().add(wv);
                }
            });

            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    App.your_dictionary.delete(word);
                }
            });

            data.add(anchorPane);
        }
        System.out.println(data.size());
        listView.setItems(data);
        show_list_your_word_pane.getChildren().add(listView);
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
}
