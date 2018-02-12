package com.codecool.plaza.api;

import java.util.*;

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

    public Map<Long, ShopEntry> getProducts() {
        return products;
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

    public Product findByName(String name) throws ShopIsClosedException, NoSuchProductException {
        Product product = null;
        if (isOpen()) {
            for (Map.Entry<Long, ShopEntry> entry : products.entrySet()) {
                ShopEntry tempShopEntry = entry.getValue();
                if (tempShopEntry.getProduct().getName().equals(name)) {
                    product = tempShopEntry.getProduct();
                }
            }
            if (product == null) {
                throw new NoSuchProductException("No such product in the shop!");
            } else {
                return product;
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
            if (!hasProduct(product.getBarcode())) {
                products.put(product.getBarcode(), new ShopEntry(product, quantity, price));
            } else {
                throw new ProductAlreadyExistsException("Product already exist");
            }
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

            } else {
                throw new NoSuchProductException("No such product in the shop");
            }
        }
    }

    public Product buyProduct(long barcode) throws NoSuchProductException, ShopIsClosedException, OutOfStockException {
        if (isOpen()) {
            if (hasProduct(barcode)) {
                for (Map.Entry<Long, ShopEntry> entry : products.entrySet()) {
                    if (barcode == entry.getKey()) {
                        if (entry.getValue().getQuantity() > 0) {
                            entry.getValue().decreaseQuantity(1);
                            return entry.getValue().getProduct();
                        } else {
                            throw new OutOfStockException("The product is out of stock!");
                        }
                    }
                }
            }
            throw new NoSuchProductException("No such product in the shop");
        }
        throw new ShopIsClosedException("Shop is closed");
    }

    public void setPrice(long barcode, float price) throws ShopIsClosedException {
        if (isOpen()) {
            if (hasProduct(barcode)) {
                for (Map.Entry<Long, ShopEntry> entry : products.entrySet()) {
                    if (barcode == entry.getKey()) {
                        entry.getValue().setPrice(price);
                    }
                }
            }
        }
        throw new ShopIsClosedException("Shop is closed");
    }

    public float getPrice(long barcode) throws ShopIsClosedException {
        if (isOpen()) {
            if (hasProduct(barcode)) {
                for (Map.Entry<Long, ShopEntry> entry : products.entrySet()) {
                    if (barcode == entry.getKey()) {
                        return entry.getValue().getPrice();
                    }
                }
            }
        }
        throw new ShopIsClosedException("Shop is closed");
    }


    public String toString() {
        return "name: " + getName() + " owner: " + getOwner() + " open: " + isOpen();
    }

    public class ShopEntry {
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

        public void setPrice(float price) {
            this.price = price;
        }

        public String toString() {
            return "products: " + getProduct() + " quantity: " + getQuantity() + " price: " + getPrice();
        }
    }
}
