package com.codecool.plaza.api;

public interface Shop {

    String getName();

    String getOwner();

    boolean isOpen();

    void open();

    void close();

    Product findByName(String name) throws ShopIsClosedException, NoSuchProductException;

    boolean hasProduct(long barcode) throws ShopIsClosedException;

    void addNewProduct(Product product, int quantity, float price) throws ProductAlreadyExistsException, ShopIsClosedException;

    void addProduct(long barcode, int quantity) throws NoSuchProductException, ShopIsClosedException;

    Product buyProduct(long barcode) throws NoSuchProductException, ShopIsClosedException, OutOfStockException;

    String toString();
}
