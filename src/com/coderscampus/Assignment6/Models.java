package com.coderscampus.Assignment6;

public enum Models {
    model3("Model 3"),
    modelS( "Model S"),
    modelX( "Model X");

    private final String displayName;

    Models(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
