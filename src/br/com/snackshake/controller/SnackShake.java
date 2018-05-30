package br.com.snackshake.controller;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Carlos
 */
public class SnackShake extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HomeCTR hc = new HomeCTR();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
