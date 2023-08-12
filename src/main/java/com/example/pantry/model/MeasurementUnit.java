package com.example.pantry.model;

public enum MeasurementUnit {
    GRAMS("grams"),
    KILOGRAMS ("kilograms"),
    MILILITERS ("mililiters"),
    LITERS ("liters"),
    PIECES("pieces"),
    BAGS("bags"),
    PACKAGES("packages");

    private final String displayUnit;

    MeasurementUnit(String displayUnit) {
        this.displayUnit = displayUnit;
    }
    public String getDisplayUnit() {
        return displayUnit;
    }
}
