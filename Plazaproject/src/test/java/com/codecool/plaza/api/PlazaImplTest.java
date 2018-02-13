package com.codecool.plaza.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlazaImplTest {
    private PlazaImpl myPlaza;
    private ShopImpl newShop;

    @BeforeEach
    void setUp() {
        myPlaza = new PlazaImpl("Christ", "church");
        myPlaza.open();
        try {
            try {

                myPlaza.addShop(new ShopImpl("Jézus szíve", "János atya"));
            } catch (PlazaIsClosedException ex) {
                System.out.println("Devil in the church!");
            }
        } catch (ShopAlreadyExistsException ex) {
            System.out.println("God bless us");
        }
        newShop = new ShopImpl("vatikán", "pope");
    }

    @Test
    void getShops() {
        try {
            assertEquals("Jézus szíve", myPlaza.getShops().get(0).getName());
        } catch (PlazaIsClosedException ex) {
            System.out.println("How?");
        }
        //Throwing closed error
        myPlaza.close();
        assertThrows(PlazaIsClosedException.class, () -> myPlaza.getShops());
    }

    @Test
    void addShop() {
        try {
            try {

                assertEquals(1, myPlaza.getShops().size());
                myPlaza.addShop(newShop);
                assertEquals(2, myPlaza.getShops().size());
            } catch (PlazaIsClosedException ex) {
                System.out.println("Devil in the church!");
            }
        } catch (ShopAlreadyExistsException ex) {
            System.out.println("God bless us");
        }

        //Throwing closed error
        myPlaza.close();
        assertThrows(PlazaIsClosedException.class, () -> myPlaza.addShop(newShop));
        //Throwing ShopAlreadyExistException
        myPlaza.open();
        assertThrows(ShopAlreadyExistsException.class, () -> myPlaza.addShop(newShop));
    }

    @Test
    void removeShop() {
        try {
            try {

                assertEquals(1, myPlaza.getShops().size());
                myPlaza.removeShop(myPlaza.findShopByName("Jézus szíve"));
                assertEquals(0, myPlaza.getShops().size());
            } catch (PlazaIsClosedException ex) {
                System.out.println("Devil in the church!");
            }
        } catch (NoSuchShopException ex) {
            System.out.println("God bless us");
        }
        //Throwing closed error
        myPlaza.close();
        assertThrows(PlazaIsClosedException.class, () -> myPlaza.removeShop(newShop));
        //Throwing NosuchShopException
        myPlaza.open();
        assertThrows(NoSuchShopException.class, () -> myPlaza.removeShop(newShop));
    }

    @Test
    void findShopByName() {
        try {
            try {

                assertEquals("János atya", myPlaza.findShopByName("Jézus szíve").getOwner());
            } catch (PlazaIsClosedException ex) {
                System.out.println("Devil in the church!");
            }
        } catch (NoSuchShopException ex) {
            System.out.println("God bless us");
        }

    }

    @Test
    void isOpen() {
        assertTrue(myPlaza.isOpen());
        myPlaza.close();
        assertFalse(myPlaza.isOpen());
    }

    @Test
    void open() {
        myPlaza.close();
        assertFalse(myPlaza.isOpen());
        myPlaza.open();
        assertTrue(myPlaza.isOpen());
    }

    @Test
    void close() {
        assertTrue(myPlaza.isOpen());
        myPlaza.close();
        assertFalse(myPlaza.isOpen());
    }

    @Test
    void getOwner() {
        assertEquals("Christ", myPlaza.getOwner());
    }

    @Test
    void getName() {
        assertEquals("church", myPlaza.getName());
    }
}