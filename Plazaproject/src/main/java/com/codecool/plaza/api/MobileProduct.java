package com.codecool.plaza.api;

public class MobileProduct extends Product {
    private float size;
    private int ram;
    private int rom;

    public MobileProduct(long barcode, String manufacturer, String name, float size, int ram, int rom) {
        super(barcode, manufacturer, name);
        this.size = size;
        this.rom = rom;
    }


    public float getSize() {
        return size;
    }

    public int getRam() {
        return ram;
    }

    public int getRom() {
        return rom;
    }

    public String toString() {
        return "barcode: " + getBarcode() + " model name: " + getName() + " size: " + getSize() + " RAM: " + getRam() + " ROM: " + getRom();
    }
}