package com.example.pantry.enums;

public enum MeasurementUnitEnum {
    PIECES("pieces"),
    GRAMS("grams"),
    KILOGRAMS ("kilograms"),
    MILILITERS ("mililiters"),
    LITERS ("liters"),
    BAGS("bags"),
    PACKAGES("packages");

    private final String displayUnit;

    MeasurementUnitEnum(String displayUnit) {
        this.displayUnit = displayUnit;
    }
    public String getDisplayUnit() {
        return displayUnit;
    }
}
