package com.codecool.plaza.api;

public class BookProduct extends Product{
    private final String author;
    private final int numberOfPages;

    public BookProduct(long barcode,String manufacturer,String name, String author, int numberOfPages) {
        super(barcode,manufacturer,name);
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    private String getAuthor() {
        return author;
    }

    private int getNumberOfPages() {
        return numberOfPages;
    }
    public String toString(){
        return "barcode: " + getBarcode() +" name: "+getName() + " author: "+ getAuthor() + " number of pages: "+ getNumberOfPages();
    }
}