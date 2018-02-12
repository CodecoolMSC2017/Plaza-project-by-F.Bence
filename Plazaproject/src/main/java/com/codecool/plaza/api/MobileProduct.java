package com.codecool.plaza.api;

public class MobileProduct extends Product {
    private final float size;
    private final int ram;
    private final int rom;

    public MobileProduct(long barcode, String manufacturer, String name, float size, int ram, int rom) {
        super(barcode, manufacturer, name);
        this.size = size;
        this.rom = rom;
        this.ram = ram;
    }


    private float getSize() {
        return size;
    }

    private int getRam() {
        return ram;
    }

    private int getRom() {
        return rom;
    }

    public String toString() {
        return "barcode: " + getBarcode() + " model name: " + getName() + " size: " + getSize() + " RAM: " + getRam() + " ROM: " + getRom();
    }
}