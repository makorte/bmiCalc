package com.maxkorte.bmiCalc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField tfGroesse;
    @FXML
    TextField tfGewicht;
    @FXML
    Label lBMI;
    @FXML
    Label lBMIClass;
    @FXML
    Button bBerechnen;

    private BMI bmi;
    private final DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bmi = new BMI();
        tfGewicht.textProperty().bindBidirectional(bmi.weightProperty(), new NumberStringConverter());
        tfGroesse.textProperty().bindBidirectional(bmi.heightProperty(), new NumberStringConverter());
    }

    public void handleExit(){
        System.exit(0);
    }

    public void handleDelete(){
        tfGroesse.setText("");
        tfGewicht.setText("");
        lBMI.setText("Dein BMI wird berechnet...");
        lBMIClass.setText("Gib deine Werte in die Felder ein und klicke 'Berechnen'");
    }
    
    public void handleBBerechnen(){
        bmi.calculate();
        lBMI.setText("Dein BMI: " + df.format(bmi.getBmi()));
        lBMIClass.setText(bmi.categorize().toString());
    }
}
