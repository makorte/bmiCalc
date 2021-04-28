package com.maxkorte.bmiCalc;

public enum BMIClass {
    UNTERGEWICHT(0), NORMALGEWICHT(1), UEBERGEWICHT(2), ADIPOSITAS1(3),
    ADIPOSITAS2(4), ADIPOSITAS3(5);

    private final String deseaseRisk;

    BMIClass(int deseaseRisk){
        switch (deseaseRisk) {
            case 0 -> this.deseaseRisk = "niedrig";
            case 1 -> this.deseaseRisk = "durchschnittlich";
            case 2 -> this.deseaseRisk = "leicht erhöht";
            case 3 -> this.deseaseRisk = "erhöht";
            case 4 -> this.deseaseRisk = "hoch";
            case 5 -> this.deseaseRisk = "sehr hoch";
            default -> this.deseaseRisk = "";
        }
    }

    public String getDeseaseRisk() {
        return deseaseRisk;
    }
}
