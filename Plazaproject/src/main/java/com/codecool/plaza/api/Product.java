package com.codecool.plaza.api;

public abstract class Product {

    protected long barcode;
    protected String manufacturer;

    protected Product(long barcode, String manufacturer) {
        this.barcode = barcode;
        this.manufacturer = manufacturer;
    }

    public long getBarcode() {
        return barcode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String toString() {
        return "barcode: " + barcode + "\tmanufacturer: " + manufacturer;
    }
}