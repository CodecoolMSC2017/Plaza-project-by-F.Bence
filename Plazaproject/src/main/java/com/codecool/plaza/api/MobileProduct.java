package com.codecool.plaza.api;

public class MobileProduct extends Product{
    private String modelName;
    private float size;
    private int ram;
    private int rom;

    public MobileProduct(long barcode,String manufacturer,String modelName, float size, int ram, int rom) {
        super(barcode,manufacturer);
        this.modelName = modelName;
        this.size = size;
        this.rom = rom;
    }

    public String getModelName() {
        return modelName;
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
    public String toString(){
        return "model name: " + getModelName() + "size: "+ getSize() + "RAM: "+ getRam()+ "ROM: "+getRom();
    }
}