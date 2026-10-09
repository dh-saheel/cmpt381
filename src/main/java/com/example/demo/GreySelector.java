package com.example.demo;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import jdk.jfr.FlightRecorder;

import javax.swing.*;

public class GreySelector extends Region {


    DoubleProperty greyLevelProperty;
    EventHandler<ActionEvent> handler;

    public GreySelector(String titleText) {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        greyLevelProperty = new SimpleDoubleProperty();
        Label titleLabel = new Label(titleText);
        Circle greyCircle = new Circle(40);
        Slider greySlider = new Slider(0,1,0);
        Button setButton = new Button("Set");



        // set up internal events
        // slider property listener
        greySlider.valueProperty().addListener(observableValue -> {
            greyLevelProperty.set(greySlider.getValue());
            greyCircle.setFill(Color.gray(greyLevelProperty.get()));
        });
        setButton.setOnAction(this::handleSetClick);

        root.getChildren().addAll(titleLabel, greyCircle, greySlider, setButton);
        this.getChildren().add(root);
    }

    private void handleSetClick(ActionEvent event) {
        if (handler != null) {
            handler.handle(new ActionEvent());
        }
    }

    public void setOnAction(EventHandler<ActionEvent> ehandler) {handler = ehandler;}

    public DoubleProperty greyLevelProperty() {
        return greyLevelProperty;
    }

    public double getGreyLevelProperty() {
        return greyLevelProperty.get();
    }
}
