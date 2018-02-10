package com.codecool.plaza.api;

import java.util.List;
import java.util.Map;

public class ShopImpl implements Shop{

    private String name;
    private String owner;
    private Map<Long, ShopEntry> products;

    public ShopImpl(String name, String owner){
        this.name = name;
        this.owner = owner;
    }
    public String getName() {
        return null;
    }

    public String getOwner() {
        return null;
    }

    public boolean isOpen() {
        return false;
    }

    public void open() {

    }

    public void close() {

    }

    public List<Product> findByName(String name) throws ShopIsClosedException {
        return null;
    }

    public boolean hasProduct(long barcode) throws ShopIsClosedException {
        return false;
    }

    public void addNewProduct(Product product, int quantity, float price) throws ProductAlreadyExistsException, ShopIsClosedException {

    }

    public void addProduct(long barcode, int quantity) throws NoSuchProductException, ShopIsClosedException {

    }

    public Product buyProduct(long barcode) throws NoSuchProductException, ShopIsClosedException {
        return null;
    }
    class ShopEntry {
        private Product product;
        private int quantity;
        private float price;


        ShopEntry(Product product, int quantity, float price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return  quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void increaseQuantity(int amount) {
            quantity++;
        }

        public void decreaseQuantity(int amount) {
            quantity--;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String toString() {
            return getProduct()+ "quantity: "+ getQuantity() + "price: " + getPrice();
        }
    }
}
