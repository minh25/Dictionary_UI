package org.example;

import javafx.animation.TranslateTransition;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.io.IOException;


public class Scene3Controller {
    public AnchorPane root_anchor_pane;
    public AnchorPane search_bar_pane;
    public Pane open_menu_pane;
    public AnchorPane google_translate_pane;
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

    public Scene3Controller() throws IOException {
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

    public void go_to_gg(MouseEvent mouseEvent) {
        WebView webView = new WebView();

        webView.getEngine().load("https://translate.google.com.vn/?hl=en&tab=rT&authuser=0#view=home&op=translate&sl=en&tl=vi");
        AnchorPane.setTopAnchor(webView, 0.0);
        AnchorPane.setLeftAnchor(webView, 0.0);
        AnchorPane.setRightAnchor(webView, 0.0);
        AnchorPane.setBottomAnchor(webView, 0.0);
        google_translate_pane.getChildren().add(webView);
    }
}
