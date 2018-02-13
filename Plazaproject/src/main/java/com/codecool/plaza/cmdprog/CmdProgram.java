package com.codecool.plaza.cmdprog;

import com.codecool.plaza.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CmdProgram {
    private final List<Product> cart;
    private final Scanner reader = new Scanner(System.in);
    private float moneySpent = 0;

    public CmdProgram() {
        cart = new ArrayList<>();
    }

    public void run() {
        String owner;
        boolean sub;
        System.out.println("Enter your name:");
        owner = reader.nextLine();
        PlazaImpl myPlaza;
        label1:
        while (true) {
            System.out.println("There are no plaza created yet! Press\n 1) to create a new plaza.\n 2) to exit.");
            String choose = reader.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Enter the name of your plaza:");
                    String plazaName = reader.nextLine();
                    myPlaza = new PlazaImpl(owner, plazaName);
                    break label1;
                case "2":
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    System.out.println("Wrong input entered");
                    break;
            }

        }
        while (true) {
            int menu;
            String shopName;
            while (true) {
                System.out.println(myPlaza + "\nThe owner name is: " + myPlaza.getOwner() + "\nPress \n1) to list all shops. \n2) to add a new shop. \n3) to remove an existing shop. \n4) enter a shop by name. \n5) to open the plaza. \n6) to close the plaza. \n7) to check if the plaza is open or not.\n8) to list the cart.\n9) to show total money spent.\n10) to exit");
                String subInp = reader.nextLine();
                try {
                    menu = Integer.parseInt(subInp);
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("Wrong input entered! Enter a number!");
                }
            }
            try {
                switch (menu) {
                    case 1:
                        for (Shop shop : myPlaza.getShops()) {
                            System.out.println(shop);
                        }
                        break;
                    case 2:
                        System.out.println("Please enter the name of your shop!");
                        shopName = reader.nextLine();
                        try {
                            myPlaza.addShop(new ShopImpl(shopName, owner));
                        } catch (ShopAlreadyExistsException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Please enter the name of the shop!");
                        shopName = reader.nextLine();
                        try {
                            myPlaza.removeShop(myPlaza.findShopByName(shopName));
                        } catch (NoSuchShopException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Please enter the name of the shop!");
                        shopName = reader.nextLine();
                        ShopImpl myShop;
                        try {
                            myShop = (ShopImpl) myPlaza.findShopByName(shopName);
                        } catch (NoSuchShopException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                        int submenu = 0;
                        sub = true;
                        while (sub) {
                            System.out.println("Hi! This is the " + myShop.getName() + " , welcome! Press");
                            System.out.println("1) to list available products.\n" +
                                    "2) to find products by name.\n" +
                                    "3) to display the shop's owner.\n" +
                                    "4) to open the shop.\n" +
                                    "5) to close the shop.\n" +
                                    "6) to add new product to the shop.\n" +
                                    "7) to add existing products to the shop.\n" +
                                    "8) to set the price of the product by barcode.\n" +
                                    "9) to buy a product by barcode.\n" +
                                    "10) go back to plaza.\n");

                            String subInp = reader.nextLine();
                            try {
                                submenu = Integer.parseInt(subInp);
                            } catch (NumberFormatException ex) {
                                System.out.println("Wrong input entered! Enter a number!");
                            }
                            try {
                                label:
                                switch (submenu) {
                                    case 1:
                                        for (Map.Entry<Long, ShopImpl.ShopEntry> entry : myShop.getProducts().entrySet()) {
                                            System.out.println(entry.getValue());
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Please enter the name of the product");
                                        String productName = reader.nextLine();
                                        try {
                                            System.out.println(myShop.findByName(productName));
                                        } catch (NoSuchProductException ex) {
                                            System.out.println(ex.getMessage());
                                            break;
                                        }
                                        break;
                                    case 3:
                                        System.out.println(myShop.getOwner());
                                        break;
                                    case 4:
                                        myShop.open();
                                        System.out.println(myShop.getName() + " is opened.");
                                        break;
                                    case 5:
                                        myShop.close();
                                        System.out.println(myShop.getName() + " is closed");
                                        break;
                                    case 6:
                                        System.out.println("Please enter the name of the product");
                                        String name = reader.nextLine();

                                        System.out.println("Please enter the manufacturer of the product");
                                        String manufacturer = reader.nextLine();

                                        System.out.println("Please enter the barcode of the product");
                                        String barcodeString = reader.nextLine();
                                        long barcode;
                                        try {
                                            barcode = Long.parseLong(barcodeString);
                                        } catch (NumberFormatException ex) {
                                            System.out.println("Wrong input entered! Enter a number!");
                                            break;
                                        }

                                        System.out.println("Please enter the quantity of the product");
                                        String quantityString = reader.nextLine();
                                        int quantity;
                                        try {
                                            quantity = Integer.parseInt(quantityString);
                                        } catch (NumberFormatException ex) {
                                            System.out.println("Wrong input entered! Enter a number!");
                                            break;
                                        }

                                        System.out.println("Please enter the price of the product");
                                        String priceString = reader.nextLine();
                                        float price;
                                        try {
                                            price = Float.parseFloat(priceString);
                                        } catch (NumberFormatException ex) {
                                            System.out.println("Wrong input entered! Enter a number!");
                                            break;
                                        }

                                        System.out.println("Please enter the type of the product! (Book,Film,Mobile)");
                                        String type = reader.nextLine();
                                        try {
                                            switch (type) {
                                                case "Book":
                                                    System.out.println("Please enter the author of the book!");
                                                    String author = reader.nextLine();

                                                    System.out.println("Please enter the number of pages of the book");
                                                    String pagesString = reader.nextLine();
                                                    int pages;
                                                    try {
                                                        pages = Integer.parseInt(pagesString);
                                                    } catch (NumberFormatException ex) {
                                                        System.out.println("Wrong input entered! Enter a number!");
                                                        break;
                                                    }
                                                    myShop.addNewProduct(new BookProduct(barcode, manufacturer, name, author, pages), quantity, price);
                                                    break;
                                                case "Film":
                                                    System.out.println("Please enter the genre of the film!");
                                                    String genre = reader.nextLine();

                                                    System.out.println("Please enter the playtime of the film!");
                                                    String playTimeString = reader.nextLine();
                                                    int playTime;
                                                    try {
                                                        playTime = Integer.parseInt(playTimeString);
                                                    } catch (NumberFormatException ex) {
                                                        System.out.println("Wrong input entered! Enter a number!");
                                                        break;
                                                    }
                                                    myShop.addNewProduct(new FilmProduct(barcode, manufacturer, name, playTime, genre), quantity, price);

                                                    break;
                                                case "Mobile":
                                                    System.out.println("Please enter the size of the mobile!");
                                                    String sizeString = reader.nextLine();
                                                    float size;
                                                    try {
                                                        size = Float.parseFloat(sizeString);
                                                    } catch (NumberFormatException ex) {
                                                        System.out.println("Wrong input entered! Enter a number!");
                                                        break;
                                                    }
                                                    System.out.println("Please enter the number of RAM of the mobile!");
                                                    String ramString = reader.nextLine();
                                                    int ram;
                                                    try {
                                                        ram = Integer.parseInt(ramString);
                                                    } catch (NumberFormatException ex) {
                                                        System.out.println("Wrong input entered! Enter a number!");
                                                        break;
                                                    }
                                                    System.out.println("Please enter the number of ROM of the mobile!");
                                                    String romString = reader.nextLine();
                                                    int rom;
                                                    try {
                                                        rom = Integer.parseInt(romString);
                                                    } catch (NumberFormatException ex) {
                                                        System.out.println("Wrong input entered! Enter a number!");
                                                        break;
                                                    }
                                                    myShop.addNewProduct(new MobileProduct(barcode, manufacturer, name, size, ram, rom), quantity, price);
                                                    break;
                                                default:
                                                    System.out.println("Wrong input entered! Enter a product from the given list!");
                                                    break label;
                                            }


                                        } catch (ProductAlreadyExistsException ex) {
                                            System.out.println(ex.getMessage());
                                        }
                                        break;
                                    case 7:
                                        System.out.println("Please enter the barcode of the product");
                                        String barcodeStr = reader.nextLine();
                                        long code;
                                        try {
                                            code = Long.parseLong(barcodeStr);
                                        } catch (NumberFormatException ex) {
                                            System.out.println("Wrong input entered! Enter a number!");
                                            break;
                                        }

                                        System.out.println("Please enter the quantity of the product");
                                        String addString = reader.nextLine();
                                        int add;
                                        try {
                                            add = Integer.parseInt(addString);
                                        } catch (NumberFormatException ex) {
                                            System.out.println("Wrong input entered! Enter a number!");
                                            break;
                                        }

                                        try {
                                            myShop.addProduct(code, add);
                                        } catch (NoSuchProductException ex) {
                                            System.out.println(ex.getMessage());
                                        }
                                        break;
                                    case 8:
                                        System.out.println("Please enter the barcode of the product");
                                        String setStr = reader.nextLine();
                                        long set;
                                        try {
                                            set = Long.parseLong(setStr);
                                        } catch (NumberFormatException ex) {
                                            System.out.println("Wrong input entered! Enter a number!");
                                            break;
                                        }
                                        System.out.println("Please enter the price of the product");
                                        String newPriceStr = reader.nextLine();
                                        float newPrice;
                                        try {
                                            newPrice = Float.parseFloat(newPriceStr);
                                        } catch (NumberFormatException ex) {
                                            System.out.println("Wrong input entered! Enter a number!");
                                            break;
                                        }
                                        myShop.setPrice(set, newPrice);
                                        break;
                                    case 9:
                                        System.out.println("Please enter the barcode of the product");
                                        String buyStr = reader.nextLine();
                                        long buy;
                                        try {
                                            buy = Long.parseLong(buyStr);
                                        } catch (NumberFormatException ex) {
                                            System.out.println("Wrong input entered! Enter a number!");
                                            break;
                                        }
                                        try {
                                            try {
                                                cart.add(myShop.buyProduct(buy));
                                                moneySpent += myShop.getPrice(buy);
                                            } catch (OutOfStockException ex) {
                                                System.out.println(ex.getMessage());
                                                break;
                                            }

                                        } catch (NoSuchProductException ex) {
                                            System.out.println(ex.getMessage());
                                            break;
                                        }
                                        break;
                                    case 10:
                                        sub = false;
                                        break;
                                    default:
                                        System.out.println("Wrong input entered!");
                                        break;
                                }
                            } catch (ShopIsClosedException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                        break;
                    case 5:
                        myPlaza.open();
                        System.out.println(myPlaza.getName() + " is opened.");
                        break;
                    case 6:
                        myPlaza.close();
                        System.out.println(myPlaza.getName() + " is closed.");
                        break;
                    case 7:
                        if (myPlaza.isOpen()) {
                            System.out.println(myPlaza.getName() + " is open.");
                        } else {
                            System.out.println(myPlaza.getName() + " is closed.");
                        }
                        break;
                    case 8:
                        for (Product product : cart) {
                            System.out.println(product);
                        }
                        break;
                    case 9:
                        System.out.println("Total money spent: " + moneySpent);
                        break;
                    case 10:
                        System.out.println("Bye!");
                        System.exit(0);
                    default:
                        System.out.println("Wrong input entered!");
                        break;


                }
            } catch (PlazaIsClosedException pl) {
                System.out.println(pl.getMessage());
            }


        }
    }
}
