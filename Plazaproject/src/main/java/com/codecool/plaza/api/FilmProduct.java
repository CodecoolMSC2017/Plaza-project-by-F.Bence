package com.codecool.plaza.api;

public class FilmProduct extends Product {
    private final int playTime;
    private final String genre;

    public FilmProduct(long barcode, String manufacturer, String name, int playTime, String genre) {
        super(barcode, manufacturer, name);
        this.name = name;
        this.playTime = playTime;
        this.genre = genre;
    }

    private String getGenre() {
        return genre;
    }

    private int getPlayTime() {
        return playTime;
    }

    public String toString() {
        return "barcode: " + getBarcode() + " name: " + getName() + " genre: " + getGenre() + " play time: " + getPlayTime();
    }
}
