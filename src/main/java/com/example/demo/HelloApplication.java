package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    GreySelector startGrey;
    GreySelector endGrey;

    @Override
    public void start(Stage stage) throws IOException {

        HBox root = new HBox();
        startGrey = new GreySelector("Start Level");
        endGrey = new GreySelector("End Level");


        startGrey.setOnAction(event -> {System.out.println("Event alert!! " + event);});
        endGrey.setOnAction(event -> {
            System.out.println("Another event. " + event);
        });

        startGrey.greyLevelProperty().addListener(event -> {
            System.out.println(startGrey.getGreyLevelProperty());
        });
        root.getChildren().addAll(startGrey, endGrey);

        Scene scene = new Scene(root);
        stage.setTitle("Composite Widget Demo");
        stage.setScene(scene);
        stage.show();
    }
}
