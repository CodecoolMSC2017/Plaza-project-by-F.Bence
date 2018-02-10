package com.codecool.plaza.api;

public class BookProduct extends Product{
    private String name;
    private String author;
    private int numberOfPages;

    public BookProduct(long barcode,String manufacturer,String name, String author, int numberOfPages) {
        super(barcode,manufacturer);
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return "name: "+getName() + "author: "+ getAuthor() + "number of pages: "+ getNumberOfPages();
    }
}