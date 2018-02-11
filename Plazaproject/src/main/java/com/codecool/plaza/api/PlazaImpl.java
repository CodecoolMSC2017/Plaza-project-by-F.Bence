package com.codecool.plaza.api;

import java.util.List;

public class PlazaImpl implements Plaza {
    private List<Shop> shops;
    private String owner;
    private String name;
    private boolean open;

    public PlazaImpl(String owner,String name) {
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
            }
            throw new ShopAlreadyExistsException("Shop name already exists");

        }
        throw new PlazaIsClosedException("Plaza is closed");
    }

    public void removeShop(Shop shop) throws NoSuchShopException, PlazaIsClosedException {
        if (isOpen()) {
            if (hasShop(shop)) {
                shops.remove(shop);
            }
            throw new NoSuchShopException("No such shop in the Plaza");

        }
        throw new PlazaIsClosedException("Plaza is closed");
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

    public boolean hasShop(Shop shop) {
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
}
