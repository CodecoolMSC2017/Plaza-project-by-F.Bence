package com.codecool.plaza.api;

public abstract class Product {

    private final long barcode;
    private final String manufacturer;
    String name;

    Product(long barcode, String manufacturer, String name) {
        this.name = name;
        this.barcode = barcode;
        this.manufacturer = manufacturer;
    }

    public long getBarcode() {
        return barcode;
    }

    private String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "barcode: " + getManufacturer() + " name: " + getName() + " manufacturer: " + getManufacturer();
    }
}
