package com.maxkorte.bmiCalc;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class BMI {

    private final DoubleProperty weight = new SimpleDoubleProperty();
    private final DoubleProperty height = new SimpleDoubleProperty();
    private double bmi;

    public BMI() {
    }

    public double getWeight() {
        return weight.get();
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public double getHeight() {
        return height.get();
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void calculate(){
        setBmi(getWeight() / Math.pow((getHeight() / 100), 2));
    }

    public BMIClass categorize(){
        if(getBmi() > 0 && getBmi() < 18.5) return BMIClass.UNTERGEWICHT;
        if(getBmi() >= 18.5 && getBmi() < 25) return BMIClass.NORMALGEWICHT;
        if(getBmi() >= 25 && getBmi() < 30) return BMIClass.UEBERGEWICHT;
        if(getBmi() >= 30 && getBmi() < 35) return BMIClass.ADIPOSITAS1;
        if(getBmi() >= 35 && getBmi() < 40) return BMIClass.ADIPOSITAS2;
        if(getBmi() >= 40) return BMIClass.ADIPOSITAS3;
        throw new IllegalArgumentException("Das Gewicht oder die Größe dürfen nicht kleiner als 1 sein!");
    }
}
