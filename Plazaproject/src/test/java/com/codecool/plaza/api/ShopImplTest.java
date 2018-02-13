package com.codecool.plaza.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopImplTest {
    private PlazaImpl myPlaza;
    private ShopImpl myShop;

    @BeforeEach
    void setUp() {
        myPlaza = new PlazaImpl("Christ", "church");
        myPlaza.open();
        try {
            try {
                try {
                    try {

                        myShop = new ShopImpl("Jézus szíve", "János atya");
                        myShop.open();
                        myShop.addNewProduct(new FilmProduct(111, "Tibi atya", "Mise bor", 42, "alcohol"), 1, 25);
                        myPlaza.addShop(myShop);

                    } catch (PlazaIsClosedException ex) {
                        System.out.println("Devil in the church!");
                    }
                } catch (ShopAlreadyExistsException ex) {
                    System.out.println("God bless us");
                }
            } catch (ProductAlreadyExistsException ex) {
                System.out.println("God bless U");
            }
        } catch (ShopIsClosedException ex) {
            System.out.println("God bless me");
        }

    }

    @Test
    void getName() {
        assertEquals("Jézus szíve", myShop.getName());
    }

    @Test
    void getOwner() {
        assertEquals("János atya", myShop.getOwner());
    }

    @Test
    void getProducts() {
        assertEquals(1, myShop.getProducts().size());
    }

    @Test
    void isOpen() {
        assertTrue(myShop.isOpen());
        myShop.close();
        assertFalse(myShop.isOpen());
    }

    @Test
    void open() {
        myShop.close();
        assertFalse(myShop.isOpen());
        myShop.open();
        assertTrue(myShop.isOpen());
    }

    @Test
    void close() {
        assertTrue(myShop.isOpen());
        myShop.close();
        assertFalse(myShop.isOpen());
    }

    @Test
    void findByName() {
        try {
            try {

                assertEquals(111, myShop.findByName("Mise bor").getBarcode());
            } catch (ShopIsClosedException ex) {
                System.out.println("God bless me");
            }
        } catch (NoSuchProductException ex) {
            System.out.println("Jesus!");
        }
        assertThrows(NoSuchProductException.class, () -> myShop.findByName("Pálinka"));
        myShop.close();
        assertThrows(ShopIsClosedException.class, () -> myShop.findByName("Mise bor"));
    }

    @Test
    void hasProduct() {
        try {

            assertTrue(myShop.hasProduct(111));
            assertFalse(myShop.hasProduct(222));
        } catch (ShopIsClosedException ex) {
            System.out.println("God bless me");
        }
        myShop.close();
        assertThrows(ShopIsClosedException.class, () -> myShop.hasProduct(111));
    }


    @Test
    void addNewProduct() {
        Product newProduct = new MobileProduct(222, "Father-Mother", "children", 120, 6, 8);

        try {

            assertFalse(myShop.hasProduct(222));
            myShop.addNewProduct(newProduct, 10, 200);
            assertTrue(myShop.hasProduct(222));
        } catch (ShopIsClosedException ex) {
            System.out.println("God bless me");
        } catch (ProductAlreadyExistsException ex) {
            System.out.println("Too much ministráns in sekrestye!");
        }
        assertThrows(ProductAlreadyExistsException.class, () -> myShop.addNewProduct(newProduct, 10, 200));
    }

    @Test
    void addProduct() {
        try {
            assertEquals(1, myShop.getProducts().get((long) 111).getQuantity());
            myShop.addProduct(111, 10);
            assertEquals(11, myShop.getProducts().get((long) 111).getQuantity());
        } catch (ShopIsClosedException ex) {
            System.out.println("God bless me");
        } catch (NoSuchProductException ex) {
            System.out.println("Jesus!");
            myShop.close();
            assertThrows(ShopIsClosedException.class, () -> myShop.addProduct(222, 20));

        }
    }

    @Test
    void buyProduct() {
        try {
            assertEquals("Mise bor", myShop.buyProduct(111).getName());
        } catch (ShopIsClosedException ex) {
            System.out.println("God bless me");
        } catch (NoSuchProductException ex) {
            System.out.println("Jesus!");
        } catch (OutOfStockException ex) {
            System.out.println("Maria!");
        }
        assertThrows(NoSuchProductException.class, () -> myShop.buyProduct(222));
        assertThrows(OutOfStockException.class, () -> myShop.buyProduct(111));
        myShop.close();
        assertThrows(ShopIsClosedException.class, () -> myShop.buyProduct(111));
    }

    @Test
    void setPrice() {
        try {
            assertEquals(25.0, myShop.getPrice(111));
            myShop.setPrice(111, 22);
            assertEquals(22.0, myShop.getPrice(111));
        } catch (ShopIsClosedException ex) {
            System.out.println("God bless me");
        }
    }

    @Test
    void getPrice() {
        try {
            assertEquals(25.0, myShop.getPrice(111));
        } catch (ShopIsClosedException ex) {
            System.out.println("God bless me");
        }
    }
}