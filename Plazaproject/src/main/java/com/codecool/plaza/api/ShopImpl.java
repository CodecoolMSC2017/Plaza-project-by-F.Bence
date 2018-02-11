package com.codecool.plaza.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShopImpl implements Shop {

    private String name;
    private String owner;
    private boolean open;
    private Map<Long, ShopEntry> products;

    public ShopImpl(String name, String owner) {
        this.name = name;
        this.owner = owner;
        open = false;
        products = new HashMap<Long, ShopEntry>();
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isOpen() {
        return open;
    }

    public void open() {
        open = true;
    }

    public void close() {
        open = false;
    }

    public Product findByName(String name) throws ShopIsClosedException {
        if (isOpen()) {
            for (Map.Entry<Long, ShopEntry> entry : products.entrySet()) {
                ShopEntry tempShopEntry = entry.getValue();
                if (tempShopEntry.getProduct().getName().equals(name)) {
                    return tempShopEntry.getProduct();
                }
            }
        }
        throw new ShopIsClosedException("Shop is closed");
    }

    public boolean hasProduct(long barcode) throws ShopIsClosedException {
        if (isOpen()) {
            for (Map.Entry<Long, ShopEntry> entry : products.entrySet()) {
                long code = entry.getKey();
                if (code == barcode) {
                    return true;
                }
            }
            return false;
        }
        throw new ShopIsClosedException("Shop is closed");
    }

    public void addNewProduct(Product product, int quantity, float price) throws ProductAlreadyExistsException, ShopIsClosedException {
        if (isOpen()) {
            Random rand = new Random();
            long barcode = (long) (rand.nextInt((999999999 - 100000000) + 1) + 100000000);
            if (!hasProduct(barcode)) {
                products.put(barcode, new ShopEntry(product, quantity, price));
            }
            throw new ProductAlreadyExistsException("Product already exist");
        }

    }

    public void addProduct(long barcode, int quantity) throws NoSuchProductException, ShopIsClosedException {
        if (isOpen()) {
            if (hasProduct(barcode)) {
                for (Map.Entry<Long, ShopEntry> entry : products.entrySet()) {
                    if (barcode == entry.getKey()) {
                        entry.getValue().increaseQuantity(quantity);
                    }
                }

            }
            throw new NoSuchProductException("No such product in the shop");
        }
    }

    public Product buyProduct(long barcode) throws NoSuchProductException, ShopIsClosedException {
        if (isOpen()) {
            if (hasProduct(barcode)) {
                for (Map.Entry<Long, ShopEntry> entry : products.entrySet()) {
                    if (barcode == entry.getKey()) {
                        entry.getValue().decreaseQuantity(1);
                        return entry.getValue().getProduct();

                    }
                }
            }
            throw new NoSuchProductException("No such product in the shop");
        }
        throw new ShopIsClosedException("Shop is closed");
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
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void increaseQuantity(int amount) {
            setQuantity(quantity + amount);
        }

        public void decreaseQuantity(int amount) {
            setQuantity(quantity - amount);
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String toString() {
            return getProduct() + "quantity: " + getQuantity() + "price: " + getPrice();
        }
    }
}
