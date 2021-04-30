package com.maxkorte.bmiCalc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.text.DecimalFormat;

public class UI extends Application {

    protected static TextField tfGewicht;
    protected static TextField tfGroesse;
    protected static Label lBMI;
    protected static Label lBMIClass;
    protected static Button bBerechnen;

    private final BMI bmi = new BMI();
    private final DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("bmiCalc");

        Label lGewicht = new Label("Gewicht (in kg):");
        tfGewicht = new TextField();
        tfGewicht.textProperty().bindBidirectional(bmi.weightProperty(), new NumberStringConverter());
        HBox hGewicht = new HBox(20, lGewicht, tfGewicht);
        hGewicht.setAlignment(Pos.CENTER);

        Label lGroesse = new Label("Größe (in cm):");
        tfGroesse = new TextField();
        tfGroesse.textProperty().bindBidirectional(bmi.heightProperty(), new NumberStringConverter());
        HBox hGroesse = new HBox(20, lGroesse, tfGroesse);
        hGroesse.setAlignment(Pos.CENTER);

        bBerechnen = new Button("Berechnen");
        bBerechnen.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            bmi.calculate();
            lBMI.setText("Dein BMI: " + df.format(bmi.getBmi()));
            lBMIClass.setText(bmi.categorize().toString());
        });
        bBerechnen.setMaxWidth(100);

        lBMI = new Label("Dein BMI wird berechnet...");
        lBMIClass = new Label();

        VBox root = new VBox(20, hGewicht, hGroesse, bBerechnen, lBMI, lBMIClass);
        root.setAlignment(Pos.CENTER);

        primaryStage.setScene(new Scene(root, 375, 275));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
