package com.example.paketproduct.model;

public class Barang {
    private final String name;
    private final String description;

    public Barang(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
