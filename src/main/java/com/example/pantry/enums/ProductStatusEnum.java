package com.example.pantry.enums;

public enum ProductStatusEnum {
    OKAY("Okay"),
    SPECIAL_OFFER("If special offer"),
    NEED_TO_BUY("Need to buy");

    private final String displayStatus;

    ProductStatusEnum(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

}

