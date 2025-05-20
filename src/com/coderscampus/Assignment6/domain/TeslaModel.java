package com.coderscampus.Assignment6.domain;

public enum TeslaModel {
    model3("Model 3"),
    modelS( "Model S"),
    modelX( "Model X");

    private final String displayName;

    TeslaModel(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
