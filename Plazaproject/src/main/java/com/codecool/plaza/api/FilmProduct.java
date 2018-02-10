package com.codecool.plaza.api;

public class FilmProduct extends Product{
    private String name;
    private int playTime;
    private String genre;

    public FilmProduct(long barcode,String manufacturer,String name, int playTime, String genre) {
        super(barcode,manufacturer);
        this.name = name;
        this.playTime = playTime;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public int getPlayTime() {
        return playTime;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return "name: "+getName() + "genre: "+ getGenre() + "play time: "+ getPlayTime();
    }
}
