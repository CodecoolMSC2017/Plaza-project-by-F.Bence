package com.codecool.plaza.guiprog;

import com.codecool.plaza.api.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiProg {
    private float moneySpent = 0;
    private final List<Product> cart;

    public GuiProg() {
        cart = new ArrayList<>();
    }

    String title = "Plaza Project by F.Bence";
    Frames myFrame = new Frames();
    String name;
    JFrame start;
    JFrame menu;
    JFrame shopName;
    JFrame remove;
    JButton next;
    JButton nextNewShop;
    JButton removeShop;
    JTextField nameOfUser;
    JTextField nameOfPlaza;
    JTextField nameOfShop;
    PlazaImpl myPlaza;
    // Menu button and message
    JButton one;
    JButton two;
    JButton three;
    JButton four;
    JButton five;
    JButton six;
    JButton seven;
    JButton eight;
    JButton nine;
    JButton ten;
    JLabel message;



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
            } else if (e.getSource() == removeShop) {
                message.setText(handleRemoveShop());
                remove.setVisible(false);
                menu.setVisible(true);
            } else if (e.getSource() == nextNewShop) {
                message.setText(handleCreatingShop());
                shopName.setVisible(false);
                menu.setVisible(true);
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
            }


        }
    }

    String handleCartListing() {
        String str = "";
        for (Product product : cart) {
            str += product.toString() + "  ";
        }
        if (cart.size() == 0) {
            str = "The cart is empty";
        }
        return str;
    }

    String handleListing() {
        String str = "";
        try {
            if (myPlaza.getShops().size() == 0) {
                str = "No shop created yet.";
            }
            for (Shop shop : myPlaza.getShops()) {
                str += shop.getName() + "  ";
            }
        } catch (PlazaIsClosedException ex) {
            str = ex.getMessage();
        }
        return str;
    }

    String handleCreatingShop() {
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

    String handleRemoveShop() {
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


    public class Frames {
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
    }


}

