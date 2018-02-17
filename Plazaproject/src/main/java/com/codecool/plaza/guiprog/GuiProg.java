package com.codecool.plaza.guiprog;

import com.codecool.plaza.api.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class GuiProg {
    private float moneySpent = 0;
    private final List<Product> cart;

    public GuiProg() {
        cart = new ArrayList<>();
    }

    private final String title = "Plaza Project by F.Bence";
    private final Frames myFrame = new Frames();
    private ShopImpl myShop;
    private String name;
    private JFrame start;
    private JFrame menu;
    private JFrame shopMenu;
    private JFrame shopName;
    private JFrame remove;
    private JFrame enterShop;
    private JFrame find;
    private JFrame adding;
    private JFrame priceSet;
    private JFrame buyProduct;
    private JFrame addingNew;
    private JFrame bookProd;
    private JFrame filmProd;
    private JFrame mobileProd;
    private JButton next;
    private JButton nextNewShop;
    private JButton removeShop;
    private JButton nextToShop;
    private JButton findProduct;
    private JButton addProduct;
    private JButton changePrice;
    private JButton buying;
    private JButton addNewProduct;
    private JButton addBook;
    private JButton addFilm;
    private JButton addMobile;
    private JTextField nameOfUser;
    private JTextField nameOfPlaza;
    private JTextField nameOfShop;
    private JTextField nameField;
    private JTextField manufacturerField;
    private JTextField quantityField;
    private JTextField barcodeField;
    private JTextField priceField;
    private JTextField typeField;
    private JTextField authorField;
    private JTextField pagesField;
    private JTextField genreField;
    private JTextField playTimeField;
    private JTextField sizeField;
    private JTextField ramField;
    private JTextField romField;
    private PlazaImpl myPlaza;
    // Menu button and message
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton ten;
    private JLabel message;
    //Shop menu button and message
    private JButton shopOne;
    private JButton shopTwo;
    private JButton shopThree;
    private JButton shopFour;
    private JButton shopFive;
    private JButton shopSix;
    private JButton shopSeven;
    private JButton shopEight;
    private JButton shopNine;
    private JButton shopTen;
    private JLabel shopMessage;


    void Start() {
        start = new JFrame();
        start.setSize(500, 500);
        start.setTitle(title);
        start.setLocationRelativeTo(null);
        JLabel Welcome = new JLabel("Welcome to my Plaza program!");
        JLabel name = new JLabel("Please enter your name!");
        JLabel plazaName = new JLabel("Please enter your Plaza name!");
        nameOfUser = new JTextField();
        nameOfPlaza = new JTextField();
        next = new JButton("Next!");

        next.addActionListener(new Next_Click());
        nameOfUser.setColumns(7);
        nameOfPlaza.setColumns(7);

        Welcome.setBounds(150, 25, 200, 30);
        name.setBounds(150, 125, 200, 30);
        nameOfUser.setBounds(150, 175, 200, 20);
        plazaName.setBounds(150, 250, 200, 30);
        nameOfPlaza.setBounds(150, 300, 200, 20);
        next.setBounds(175, 400, 150, 30);
        start.setLayout(null);

        start.add(Welcome);
        start.add(name);
        start.add(nameOfUser);
        start.add(plazaName);
        start.add(nameOfPlaza);
        start.add(next);
        start.setVisible(true);
    }

    private String handleBuying() {
        String str;
        try {
            try {
                try {
                    try {
                        cart.add(myShop.buyProduct(Long.parseLong(barcodeField.getText())));
                        moneySpent += myShop.getPrice(Long.parseLong(barcodeField.getText()));
                        str = "The product added to your cart!";
                    } catch (ShopIsClosedException ex) {
                        str = ex.getMessage();
                    }
                } catch (NumberFormatException ex) {
                    str = "Wrong input entered!";
                }
            } catch (OutOfStockException ex) {
                str = ex.getMessage();
            }
        } catch (NoSuchProductException ex) {
            str = ex.getMessage();
        }
        return str;
    }

    private String handlePricing() {
        String str;
        try {
            try {
                myShop.setPrice(Long.parseLong(barcodeField.getText()), Float.parseFloat(priceField.getText()));
                str = "The new price of the product is: " + priceField.getText();
            } catch (ShopIsClosedException ex) {
                str = ex.getMessage();
            }
        } catch (NumberFormatException ex) {
            str = "Wrong input entered!";
        }

        return str;
    }

    private void handleAddNew() {
        if (typeField.getText().equals("Book")) {
            addingNew.setVisible(false);
            myFrame.BookProd();
        } else if (typeField.getText().equals("Film")) {
            addingNew.setVisible(false);
            myFrame.FilmProd();
        } else if (typeField.getText().equals("Mobile")) {
            addingNew.setVisible(false);
            myFrame.MobileProd();
        } else {
            shopMessage.setText("Wrong input entered!");
        }
    }

    private String handleBookAdd() {
        String str;
        try {
            try {
                try {
                    myShop.addNewProduct(new BookProduct(Long.parseLong(barcodeField.getText()), manufacturerField.getText(), nameField.getText(), authorField.getText(), Integer.parseInt(pagesField.getText())), Integer.parseInt(quantityField.getText()), Float.parseFloat(priceField.getText()));
                    str = nameField.getText() + " added the shop!";
                } catch (ShopIsClosedException ex) {
                    str = ex.getMessage();
                }
            } catch (ProductAlreadyExistsException ex) {
                str = ex.getMessage();
            }
        } catch (NumberFormatException ex) {
            str = "Wrong input entered!";
        }

        return str;
    }

    private String handleFilmAdd() {
        String str;
        try {
            try {
                try {
                    myShop.addNewProduct(new FilmProduct(Long.parseLong(barcodeField.getText()), manufacturerField.getText(), nameField.getText(), Integer.parseInt(playTimeField.getText()), genreField.getText()), Integer.parseInt(quantityField.getText()), Float.parseFloat(priceField.getText()));
                    str = nameField.getText() + " added the shop!";
                } catch (ShopIsClosedException ex) {
                    str = ex.getMessage();
                }
            } catch (ProductAlreadyExistsException ex) {
                str = ex.getMessage();
            }
        } catch (NumberFormatException ex) {
            str = "Wrong input entered!";
        }

        return str;
    }

    private String handleMobileAdd() {
        String str;
        try {
            try {
                try {
                    myShop.addNewProduct(new MobileProduct(Long.parseLong(barcodeField.getText()), manufacturerField.getText(), nameField.getText(), Float.parseFloat(sizeField.getText()), Integer.parseInt(ramField.getText()), Integer.parseInt(romField.getText())), Integer.parseInt(quantityField.getText()), Float.parseFloat(priceField.getText()));
                    str = nameField.getText() + " added the shop!";
                } catch (ShopIsClosedException ex) {
                    str = ex.getMessage();
                }
            } catch (ProductAlreadyExistsException ex) {
                str = ex.getMessage();
            }
        } catch (NumberFormatException ex) {
            str = "Wrong input entered!";
        }

        return str;
    }

    private String handleAdding() {
        String str;
        try {
            try {
                try {
                    myShop.addProduct(Long.parseLong(barcodeField.getText()), Integer.parseInt(quantityField.getText()));
                    str = quantityField.getText() + " product added to the shop.";
                } catch (ShopIsClosedException ex) {
                    str = ex.getMessage();
                }
            } catch (NoSuchProductException ex) {
                str = ex.getMessage();
            }
        } catch (NumberFormatException ex) {
            str = "Wrong input entered!";
        }

        return str;
    }

    private String handleProductListing() {
        StringBuilder str = new StringBuilder();
        if (myShop.getProducts().size() == 0) {
            str = new StringBuilder("No product created yet.");
        }
        for (Map.Entry<Long, ShopImpl.ShopEntry> entry : myShop.getProducts().entrySet()) {
            str.append("name: ").append(entry.getValue().getProduct().getName()).append(" barcode: ").append(entry.getValue().getProduct().getBarcode()).append(" , ");
        }
        return str.toString();
    }

    private String handleFind() {
        String str;
        try {
            try {
                str = myShop.findByName(nameOfShop.getText()).toString();
            } catch (ShopIsClosedException ex) {
                str = ex.getMessage();
            }
        } catch (NoSuchProductException ex) {
            str = ex.getMessage();
        }

        return str;
    }

    private String handleCartListing() {
        StringBuilder str = new StringBuilder();
        for (Product product : cart) {
            str.append(product.toString()).append("  ");
        }
        if (cart.size() == 0) {
            str = new StringBuilder("The cart is empty");
        }
        return str.toString();
    }

    private String handleListing() {
        StringBuilder str = new StringBuilder();
        try {
            if (myPlaza.getShops().size() == 0) {
                str = new StringBuilder("No shop created yet.");
            }
            for (Shop shop : myPlaza.getShops()) {
                str.append(shop.getName()).append("  ");
            }
        } catch (PlazaIsClosedException ex) {
            str = new StringBuilder(ex.getMessage());
        }
        return str.toString();
    }

    private String handleCreatingShop() {
        String str;
        try {
            myPlaza.addShop(new ShopImpl(nameOfShop.getText(), name));
            str = nameOfShop.getText() + " added to the " + myPlaza.getName();
        } catch (PlazaIsClosedException ex) {
            str = ex.getMessage();

        } catch (ShopAlreadyExistsException ex) {
            str = ex.getMessage();
        }
        return str;
    }

    private String handleRemoveShop() {
        String str;
        try {
            try {
                myPlaza.removeShop(myPlaza.findShopByName(nameOfShop.getText()));
                str = nameOfShop.getText() + " removed from the " + myPlaza.getName();
            } catch (PlazaIsClosedException ex) {
                str = ex.getMessage();
            }
        } catch (NoSuchShopException ex) {
            str = ex.getMessage();
        }
        return str;
    }

    class Next_Click implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {
                name = nameOfUser.getText();
                String plazaName = nameOfPlaza.getText();
                myPlaza = new PlazaImpl(name, plazaName);
                start.setVisible(false);
                myFrame.menu();
            } else if (e.getSource() == one) {
                message.setText(handleListing());
            } else if (e.getSource() == two) {
                menu.setVisible(false);
                myFrame.shopName();
            } else if (e.getSource() == three) {
                menu.setVisible(false);
                myFrame.removeShop();
            } else if (e.getSource() == nextNewShop) {
                message.setText(handleCreatingShop());
                shopName.setVisible(false);
                menu.setVisible(true);
            } else if (e.getSource() == removeShop) {
                message.setText(handleRemoveShop());
                remove.setVisible(false);
                menu.setVisible(true);
            } else if (e.getSource() == four) {
                menu.setVisible(false);
                myFrame.enterShop();
            } else if (e.getSource() == nextToShop) {
                try {
                    try {
                        myShop = (ShopImpl) myPlaza.findShopByName(nameOfShop.getText());
                        enterShop.setVisible(false);
                        myFrame.shopMenu();
                    } catch (PlazaIsClosedException ex) {
                        enterShop.setVisible(false);
                        message.setText(ex.getMessage());
                        menu.setVisible(true);

                    }
                } catch (NoSuchShopException ex) {
                    enterShop.setVisible(false);
                    message.setText(ex.getMessage());
                    menu.setVisible(true);
                }

            } else if (e.getSource() == five) {
                myPlaza.open();
                message.setText("Plaza is opened!");
            } else if (e.getSource() == six) {
                myPlaza.close();
                message.setText("Plaza is closed!");
            } else if (e.getSource() == seven) {
                if (myPlaza.isOpen()) {
                    message.setText("Plaza is open!");
                } else {
                    message.setText("Plaza is closed!");
                }
            } else if (e.getSource() == eight) {
                message.setText(handleCartListing());
            } else if (e.getSource() == nine) {
                message.setText("You spent : " + moneySpent + " € yet.");
            } else if (e.getSource() == ten) {
                System.exit(0);
            } else if (e.getSource() == shopOne) {
                shopMessage.setText(handleProductListing());
            } else if (e.getSource() == shopTwo) {
                shopMenu.setVisible(false);
                myFrame.findProduct();
            } else if (e.getSource() == findProduct) {
                shopMessage.setText(handleFind());
                find.setVisible(false);
                shopMenu.setVisible(true);
            } else if (e.getSource() == shopThree) {
                shopMessage.setText("The owner name is : " + myShop.getOwner());
            } else if (e.getSource() == shopFour) {
                myShop.open();
                shopMessage.setText("The shop is opened!");
            } else if (e.getSource() == shopFive) {
                myShop.close();
                shopMessage.setText("The shop is closed!");
            } else if (e.getSource() == shopSix) {
                shopMenu.setVisible(false);
                myFrame.addNew();
            } else if (e.getSource() == addNewProduct) {
                handleAddNew();
            } else if (e.getSource() == addBook) {
                shopMessage.setText(handleBookAdd());
                bookProd.setVisible(false);
                shopMenu.setVisible(true);
            } else if (e.getSource() == addFilm) {
                shopMessage.setText(handleFilmAdd());
                filmProd.setVisible(false);
                shopMenu.setVisible(true);
            } else if (e.getSource() == addMobile) {
                shopMessage.setText(handleMobileAdd());
                mobileProd.setVisible(false);
                shopMenu.setVisible(true);
            } else if (e.getSource() == shopSeven) {
                shopMenu.setVisible(false);
                myFrame.addProduct();
            } else if (e.getSource() == addProduct) {
                shopMessage.setText(handleAdding());
                adding.setVisible(false);
                shopMenu.setVisible(true);
            } else if (e.getSource() == shopEight) {
                shopMenu.setVisible(false);
                myFrame.setPrice();
            } else if (e.getSource() == changePrice) {
                shopMessage.setText(handlePricing());
                priceSet.setVisible(false);
                shopMenu.setVisible(true);
            } else if (e.getSource() == shopNine) {
                shopMenu.setVisible(false);
                myFrame.buyProduct();

            } else if (e.getSource() == buying) {
                shopMessage.setText(handleBuying());
                buyProduct.setVisible(false);
                shopMenu.setVisible(true);

            } else if (e.getSource() == shopTen) {
                shopMenu.setVisible(false);
                message.setText("Welcome back!");
                menu.setVisible(true);
            }


        }
    }

    class Frames {
        void menu() {

            menu = new JFrame();
            menu.setSize(600, 600);
            menu.setLocationRelativeTo(null);
            menu.setTitle(title);
            JLabel Welcome = new JLabel(myPlaza.toString() + " Press: ");
            one = new JButton("1");
            two = new JButton("2");
            three = new JButton("3");
            four = new JButton("4");
            five = new JButton("5");
            six = new JButton("6");
            seven = new JButton("7");
            eight = new JButton("8");
            nine = new JButton("9");
            ten = new JButton("10");
            one.addActionListener(new Next_Click());
            two.addActionListener(new Next_Click());
            three.addActionListener(new Next_Click());
            four.addActionListener(new Next_Click());
            five.addActionListener(new Next_Click());
            six.addActionListener(new Next_Click());
            seven.addActionListener(new Next_Click());
            eight.addActionListener(new Next_Click());
            nine.addActionListener(new Next_Click());
            ten.addActionListener(new Next_Click());


            JLabel first = new JLabel("to list all shops.");
            JLabel second = new JLabel("to add a new shop.");
            JLabel third = new JLabel("to remove an existing shop.");
            JLabel fourth = new JLabel("enter a shop by name.");
            JLabel fifth = new JLabel("to open the plaza.");
            JLabel sixth = new JLabel("to close the plaza.");
            JLabel seventh = new JLabel("to check if the plaza is open or not.");
            JLabel eighth = new JLabel("to list the cart.");
            JLabel nineth = new JLabel("to show total money spent.");
            JLabel tenth = new JLabel("to exit");
            message = new JLabel();

            Welcome.setBounds(200, 30, 300, 25);

            one.setBounds(25, 75, 60, 25);
            first.setBounds(100, 75, 200, 25);
            two.setBounds(25, 115, 60, 25);
            second.setBounds(100, 115, 200, 25);
            three.setBounds(25, 155, 60, 25);
            third.setBounds(100, 155, 200, 25);
            four.setBounds(25, 195, 60, 25);
            fourth.setBounds(100, 195, 200, 25);
            five.setBounds(25, 235, 60, 25);
            fifth.setBounds(100, 235, 200, 25);
            six.setBounds(25, 275, 60, 25);
            sixth.setBounds(100, 275, 200, 25);
            seven.setBounds(25, 315, 60, 25);
            seventh.setBounds(100, 315, 200, 25);
            eight.setBounds(25, 355, 60, 25);
            eighth.setBounds(100, 355, 200, 25);
            nine.setBounds(25, 395, 60, 25);
            nineth.setBounds(100, 395, 200, 25);
            ten.setBounds(25, 435, 60, 25);
            tenth.setBounds(100, 435, 200, 25);
            message.setBounds(25, 475, 300, 100);
            menu.setLayout(null);

            menu.add(Welcome);
            menu.add(one);
            menu.add(first);
            menu.add(two);
            menu.add(second);
            menu.add(three);
            menu.add(third);
            menu.add(four);
            menu.add(fourth);
            menu.add(five);
            menu.add(fifth);
            menu.add(six);
            menu.add(sixth);
            menu.add(seven);
            menu.add(seventh);
            menu.add(eight);
            menu.add(eighth);
            menu.add(nine);
            menu.add(nineth);
            menu.add(ten);
            menu.add(tenth);
            menu.add(message);
            menu.setVisible(true);


        }

        void shopMenu() {

            shopMenu = new JFrame();
            shopMenu.setSize(600, 600);
            shopMenu.setLocationRelativeTo(null);
            shopMenu.setTitle(title);
            JLabel Welcome = new JLabel("Welcome to the " + myShop.getName() + "  Press: ");
            shopOne = new JButton("1");
            shopTwo = new JButton("2");
            shopThree = new JButton("3");
            shopFour = new JButton("4");
            shopFive = new JButton("5");
            shopSix = new JButton("6");
            shopSeven = new JButton("7");
            shopEight = new JButton("8");
            shopNine = new JButton("9");
            shopTen = new JButton("10");
            shopOne.addActionListener(new Next_Click());
            shopTwo.addActionListener(new Next_Click());
            shopThree.addActionListener(new Next_Click());
            shopFour.addActionListener(new Next_Click());
            shopFive.addActionListener(new Next_Click());
            shopSix.addActionListener(new Next_Click());
            shopSeven.addActionListener(new Next_Click());
            shopEight.addActionListener(new Next_Click());
            shopNine.addActionListener(new Next_Click());
            shopTen.addActionListener(new Next_Click());


            JLabel first = new JLabel("to list available products.");
            JLabel second = new JLabel("to find products by name.");
            JLabel third = new JLabel("to display the shop's owner.");
            JLabel fourth = new JLabel("to open the shop.");
            JLabel fifth = new JLabel("to close the shop.");
            JLabel sixth = new JLabel("to add new product to the shop.");
            JLabel seventh = new JLabel("to add existing products.");
            JLabel eighth = new JLabel("to set the price of the product.");
            JLabel nineth = new JLabel("to buy a product by barcode.");
            JLabel tenth = new JLabel("go back to plaza.");
            shopMessage = new JLabel();

            Welcome.setBounds(200, 30, 300, 25);

            shopOne.setBounds(25, 75, 60, 25);
            first.setBounds(100, 75, 200, 25);
            shopTwo.setBounds(25, 115, 60, 25);
            second.setBounds(100, 115, 200, 25);
            shopThree.setBounds(25, 155, 60, 25);
            third.setBounds(100, 155, 200, 25);
            shopFour.setBounds(25, 195, 60, 25);
            fourth.setBounds(100, 195, 200, 25);
            shopFive.setBounds(25, 235, 60, 25);
            fifth.setBounds(100, 235, 200, 25);
            shopSix.setBounds(25, 275, 60, 25);
            sixth.setBounds(100, 275, 200, 25);
            shopSeven.setBounds(25, 315, 60, 25);
            seventh.setBounds(100, 315, 200, 25);
            shopEight.setBounds(25, 355, 60, 25);
            eighth.setBounds(100, 355, 200, 25);
            shopNine.setBounds(25, 395, 60, 25);
            nineth.setBounds(100, 395, 200, 25);
            shopTen.setBounds(25, 435, 60, 25);
            tenth.setBounds(100, 435, 200, 25);
            shopMessage.setBounds(25, 475, 475, 100);
            shopMenu.setLayout(null);

            shopMenu.add(Welcome);
            shopMenu.add(shopOne);
            shopMenu.add(first);
            shopMenu.add(shopTwo);
            shopMenu.add(second);
            shopMenu.add(shopThree);
            shopMenu.add(third);
            shopMenu.add(shopFour);
            shopMenu.add(fourth);
            shopMenu.add(shopFive);
            shopMenu.add(fifth);
            shopMenu.add(shopSix);
            shopMenu.add(sixth);
            shopMenu.add(shopSeven);
            shopMenu.add(seventh);
            shopMenu.add(shopEight);
            shopMenu.add(eighth);
            shopMenu.add(shopNine);
            shopMenu.add(nineth);
            shopMenu.add(shopTen);
            shopMenu.add(tenth);
            shopMenu.add(shopMessage);
            shopMenu.setVisible(true);


        }


        void shopName() {
            shopName = new JFrame();
            shopName.setTitle(title);
            shopName.setSize(600, 600);
            shopName.setLocationRelativeTo(null);
            JLabel name = new JLabel("Please enter your Shop name!");
            nameOfShop = new JTextField();
            nextNewShop = new JButton("Create shop!");
            nextNewShop.addActionListener(new Next_Click());
            nameOfShop.setColumns(7);
            name.setBounds(150, 200, 300, 30);
            nameOfShop.setBounds(150, 250, 300, 20);
            nextNewShop.setBounds(175, 400, 250, 30);
            shopName.setLayout(null);
            shopName.add(name);
            shopName.add(nameOfShop);
            shopName.add(nextNewShop);
            shopName.setVisible(true);

        }

        void enterShop() {
            enterShop = new JFrame();
            enterShop.setTitle(title);
            enterShop.setSize(600, 600);
            enterShop.setLocationRelativeTo(null);
            JLabel name = new JLabel("Please enter your Shop name!");
            nameOfShop = new JTextField();
            nextToShop = new JButton("Enter shop.");
            nextToShop.addActionListener(new Next_Click());
            nameOfShop.setColumns(7);
            name.setBounds(150, 200, 300, 30);
            nameOfShop.setBounds(150, 250, 300, 20);
            nextToShop.setBounds(175, 400, 250, 30);
            enterShop.setLayout(null);
            enterShop.add(name);
            enterShop.add(nameOfShop);
            enterShop.add(nextToShop);
            enterShop.setVisible(true);

        }

        void removeShop() {
            remove = new JFrame();
            remove.setTitle(title);
            remove.setSize(600, 600);
            remove.setLocationRelativeTo(null);
            JLabel name = new JLabel("Please enter your Shop name!");
            nameOfShop = new JTextField();
            removeShop = new JButton("Delete shop!");
            removeShop.addActionListener(new Next_Click());
            nameOfShop.setColumns(7);
            name.setBounds(150, 200, 300, 30);
            nameOfShop.setBounds(150, 250, 300, 20);
            removeShop.setBounds(175, 400, 250, 30);
            remove.setLayout(null);
            remove.add(name);
            remove.add(nameOfShop);
            remove.add(removeShop);
            remove.setVisible(true);
        }

        void findProduct() {
            find = new JFrame();
            find.setTitle(title);
            find.setSize(600, 600);
            find.setLocationRelativeTo(null);
            JLabel name = new JLabel("Please enter your Shop name!");
            nameOfShop = new JTextField();
            findProduct = new JButton("Find Product!");
            findProduct.addActionListener(new Next_Click());
            nameOfShop.setColumns(7);
            name.setBounds(150, 200, 300, 30);
            nameOfShop.setBounds(150, 250, 300, 20);
            findProduct.setBounds(175, 400, 250, 30);
            find.setLayout(null);
            find.add(name);
            find.add(nameOfShop);
            find.add(findProduct);
            find.setVisible(true);
        }

        void addProduct() {
            adding = new JFrame();
            adding.setSize(500, 500);
            adding.setTitle(title);
            adding.setLocationRelativeTo(null);
            JLabel barcode = new JLabel("Please enter the barcode of the product!");
            JLabel quantity = new JLabel("Please enter the quantity");
            barcodeField = new JTextField();
            quantityField = new JTextField();
            addProduct = new JButton("Add product!");

            addProduct.addActionListener(new Next_Click());
            barcodeField.setColumns(7);
            quantityField.setColumns(7);

            barcode.setBounds(150, 125, 200, 30);
            barcodeField.setBounds(150, 175, 200, 20);
            quantity.setBounds(150, 250, 200, 30);
            quantityField.setBounds(150, 300, 200, 20);
            addProduct.setBounds(175, 400, 150, 30);
            adding.setLayout(null);

            adding.add(barcode);
            adding.add(barcodeField);
            adding.add(quantity);
            adding.add(quantityField);
            adding.add(addProduct);
            adding.setVisible(true);

        }

        void setPrice() {
            priceSet = new JFrame();
            priceSet.setSize(500, 500);
            priceSet.setTitle(title);
            priceSet.setLocationRelativeTo(null);
            JLabel barcode = new JLabel("Please the barcode of the product!");
            JLabel price = new JLabel("Please enter the new price!");
            barcodeField = new JTextField();
            priceField = new JTextField();
            changePrice = new JButton("Change price!");

            changePrice.addActionListener(new Next_Click());
            barcodeField.setColumns(7);
            priceField.setColumns(7);

            barcode.setBounds(150, 125, 200, 30);
            barcodeField.setBounds(150, 175, 200, 20);
            price.setBounds(150, 250, 200, 30);
            priceField.setBounds(150, 300, 200, 20);
            changePrice.setBounds(175, 400, 150, 30);
            priceSet.setLayout(null);

            priceSet.add(barcode);
            priceSet.add(barcodeField);
            priceSet.add(price);
            priceSet.add(priceField);
            priceSet.add(changePrice);
            priceSet.setVisible(true);
        }

        void buyProduct() {
            buyProduct = new JFrame();
            buyProduct.setTitle(title);
            buyProduct.setSize(600, 600);
            buyProduct.setLocationRelativeTo(null);
            JLabel barcode = new JLabel("Please enter the barcode!");
            barcodeField = new JTextField();
            buying = new JButton("Buy Product!");
            buying.addActionListener(new Next_Click());
            barcodeField.setColumns(7);
            barcode.setBounds(150, 200, 300, 30);
            barcodeField.setBounds(150, 250, 300, 20);
            buying.setBounds(175, 400, 250, 30);
            buyProduct.setLayout(null);
            buyProduct.add(barcode);
            buyProduct.add(barcodeField);
            buyProduct.add(buying);
            buyProduct.setVisible(true);
        }

        void addNew() {
            addingNew = new JFrame();
            addingNew.setSize(600, 600);
            addingNew.setTitle(title);
            addingNew.setLocationRelativeTo(null);
            JLabel name = new JLabel("Please enter the name of the product!");
            JLabel manufacturer = new JLabel("Please enter the manufacturer!");
            JLabel barcode = new JLabel("Please enter the barcode!");
            JLabel quantity = new JLabel("Please enter the quantity!");
            JLabel price = new JLabel("Please enter the price!");
            JLabel type = new JLabel("Please enter the type (Film,Book,Mobile)!");
            nameField = new JTextField();
            manufacturerField = new JTextField();
            barcodeField = new JTextField();
            quantityField = new JTextField();
            priceField = new JTextField();
            typeField = new JTextField();
            addNewProduct = new JButton("Add product!");

            addNewProduct.addActionListener(new Next_Click());
            nameField.setColumns(7);
            manufacturerField.setColumns(7);
            barcodeField.setColumns(7);
            quantityField.setColumns(7);
            priceField.setColumns(7);
            typeField.setColumns(7);

            name.setBounds(150, 50, 300, 30);
            nameField.setBounds(150, 75, 300, 20);
            manufacturer.setBounds(150, 125, 300, 30);
            manufacturerField.setBounds(150, 150, 300, 20);
            barcode.setBounds(150, 200, 300, 30);
            barcodeField.setBounds(150, 225, 300, 20);
            quantity.setBounds(150, 275, 300, 30);
            quantityField.setBounds(150, 300, 300, 20);
            price.setBounds(150, 350, 300, 30);
            priceField.setBounds(150, 375, 300, 20);
            type.setBounds(150, 425, 300, 30);
            typeField.setBounds(150, 450, 300, 20);
            addNewProduct.setBounds(175, 500, 225, 30);
            addingNew.setLayout(null);

            addingNew.add(name);
            addingNew.add(nameField);
            addingNew.add(manufacturer);
            addingNew.add(manufacturerField);
            addingNew.add(barcode);
            addingNew.add(barcodeField);
            addingNew.add(quantity);
            addingNew.add(quantityField);
            addingNew.add(price);
            addingNew.add(priceField);
            addingNew.add(type);
            addingNew.add(typeField);
            addingNew.add(addNewProduct);
            addingNew.setVisible(true);

        }

        void MobileProd() {
            mobileProd = new JFrame();
            mobileProd.setSize(500, 500);
            mobileProd.setTitle(title);
            mobileProd.setLocationRelativeTo(null);
            JLabel size = new JLabel("Please enter the size!");
            JLabel ram = new JLabel("Please enter the RAM!");
            JLabel rom = new JLabel("Please enter the ROM!");
            sizeField = new JTextField();
            ramField = new JTextField();
            romField = new JTextField();
            addMobile = new JButton("Add mobile!");

            addMobile.addActionListener(new Next_Click());
            sizeField.setColumns(7);
            romField.setColumns(7);
            ramField.setColumns(7);

            size.setBounds(150, 50, 200, 30);
            sizeField.setBounds(150, 100, 200, 20);
            ram.setBounds(150, 175, 200, 30);
            ramField.setBounds(150, 225, 200, 20);
            rom.setBounds(150, 300, 200, 30);
            romField.setBounds(150, 350, 200, 20);
            addMobile.setBounds(175, 400, 150, 30);
            mobileProd.setLayout(null);

            mobileProd.add(size);
            mobileProd.add(sizeField);
            mobileProd.add(ram);
            mobileProd.add(ramField);
            mobileProd.add(rom);
            mobileProd.add(romField);
            mobileProd.add(addMobile);
            mobileProd.setVisible(true);
        }

        void BookProd() {
            bookProd = new JFrame();
            bookProd.setSize(500, 500);
            bookProd.setTitle(title);
            bookProd.setLocationRelativeTo(null);
            JLabel author = new JLabel("Please enter the author!");
            JLabel pages = new JLabel("Please enter the number of pages!");
            authorField = new JTextField();
            pagesField = new JTextField();
            addBook = new JButton("Add book!");

            addBook.addActionListener(new Next_Click());
            authorField.setColumns(7);
            pagesField.setColumns(7);

            author.setBounds(150, 125, 200, 30);
            authorField.setBounds(150, 175, 200, 20);
            pages.setBounds(150, 250, 200, 30);
            pagesField.setBounds(150, 300, 200, 20);
            addBook.setBounds(175, 400, 150, 30);
            bookProd.setLayout(null);

            bookProd.add(author);
            bookProd.add(authorField);
            bookProd.add(pages);
            bookProd.add(pagesField);
            bookProd.add(addBook);
            bookProd.setVisible(true);
        }

        void FilmProd() {
            filmProd = new JFrame();
            filmProd.setSize(500, 500);
            filmProd.setTitle(title);
            filmProd.setLocationRelativeTo(null);
            JLabel genre = new JLabel("Please enter the genre!");
            JLabel playTime = new JLabel("Please enter the play time!");
            genreField = new JTextField();
            playTimeField = new JTextField();
            addFilm = new JButton("Add film!");

            addFilm.addActionListener(new Next_Click());
            genreField.setColumns(7);
            playTimeField.setColumns(7);

            genre.setBounds(150, 125, 200, 30);
            genreField.setBounds(150, 175, 200, 20);
            playTime.setBounds(150, 250, 200, 30);
            playTimeField.setBounds(150, 300, 200, 20);
            addFilm.setBounds(175, 400, 150, 30);
            filmProd.setLayout(null);

            filmProd.add(genre);
            filmProd.add(genreField);
            filmProd.add(playTime);
            filmProd.add(playTimeField);
            filmProd.add(addFilm);
            filmProd.setVisible(true);
        }
    }
}

