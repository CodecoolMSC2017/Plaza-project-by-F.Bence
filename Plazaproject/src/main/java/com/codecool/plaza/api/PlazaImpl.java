package com.codecool.plaza.api;

import java.util.ArrayList;
import java.util.List;

public class PlazaImpl implements Plaza {
    private final List<Shop> shops;
    private final String owner;
    private final String name;
    private boolean open;

    public PlazaImpl(String owner, String name) {
        shops = new ArrayList<>();
        this.name = name;
        this.owner = owner;
        open = false;
    }

    public List<Shop> getShops() throws PlazaIsClosedException {
        if (isOpen()) {
            return shops;
        }
        throw new PlazaIsClosedException("Plaza is closed");
    }

    public void addShop(Shop shop) throws ShopAlreadyExistsException, PlazaIsClosedException {
        if (isOpen()) {
            if (!hasShop(shop)) {
                shops.add(shop);
            } else {
                throw new ShopAlreadyExistsException("Shop name already exists");
            }
        } else {
            throw new PlazaIsClosedException("Plaza is closed");
        }
    }

    public void removeShop(Shop shop) throws NoSuchShopException, PlazaIsClosedException {
        if (isOpen()) {
            if (hasShop(shop)) {
                shops.remove(shop);
            } else {
                throw new NoSuchShopException("No such shop in the Plaza");
            }
        } else {
            throw new PlazaIsClosedException("Plaza is closed");
        }
    }

    public Shop findShopByName(String name) throws NoSuchShopException, PlazaIsClosedException {
        if (isOpen()) {
            for (Shop tmpshop : shops) {
                if (tmpshop.getName().equals(name)) {
                    return tmpshop;

                }
            }
            throw new NoSuchShopException("No such shop in the Plaza");
        }
        throw new PlazaIsClosedException("Plaza is closed");
    }

    private boolean hasShop(Shop shop) {
        for (Shop tmpshop : shops) {
            if (tmpshop.getName().equals(shop.getName())) {
                return true;
            }
        }
        return false;
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

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Welcome to the " + getName() + "!";
    }
}
