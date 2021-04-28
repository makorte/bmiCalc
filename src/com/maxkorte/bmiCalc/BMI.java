package com.maxkorte.bmiCalc;

public class BMI {
    public static double calculate(int weight, int height){
        if(weight < 1 || height < 1) throw new IllegalArgumentException("Das Gewicht oder die Größe dürfen nicht " +
                "kleiner als 1 sein!");

        return (weight / Math.pow(((double) height / 100), 2));
    }

    public static BMIClass categorize(double bmi){
        if(bmi > 0 && bmi < 18.5) return BMIClass.UNTERGEWICHT;
        if(bmi >= 18.5 && bmi < 25) return BMIClass.NORMALGEWICHT;
        if(bmi >= 25 && bmi < 30) return BMIClass.UEBERGEWICHT;
        if(bmi >= 30 && bmi < 35) return BMIClass.ADIPOSITAS1;
        if(bmi >= 35 && bmi < 40) return BMIClass.ADIPOSITAS2;
        if(bmi >= 40) return BMIClass.ADIPOSITAS3;
        throw new IllegalArgumentException("Das Gewicht oder die Größe dürfen nicht kleiner als 1 sein!");
    }
}
