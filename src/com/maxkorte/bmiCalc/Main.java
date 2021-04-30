package com.maxkorte.bmiCalc;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("bmiCalc");

        Label lGewicht = new Label("Gewicht:");
        TextField tfGewicht = new TextField();
        HBox hGewicht = new HBox(20, lGewicht, tfGewicht);
        hGewicht.setAlignment(Pos.CENTER);

        Label lGroesse = new Label("Größe: ");
        TextField tfGroesse = new TextField();
        HBox hGroesse = new HBox(20, lGroesse, tfGroesse);
        hGroesse.setAlignment(Pos.CENTER);

        Button bBerechnen = new Button("Berechnen");
        bBerechnen.setMaxWidth(100);

        Label lBMI = new Label("Dein BMI wird berechnet...");
        Label lBMIClass = new Label();

        VBox root = new VBox(20, hGewicht, hGroesse, bBerechnen, lBMI, lBMIClass);
        root.setAlignment(Pos.CENTER);

        primaryStage.setScene(new Scene(root, 375, 275));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
