package com.codecool.plaza.guiprog;

import com.codecool.plaza.api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiProg {
    JFrame start;
    JButton next;
    JTextField nameOfUser;
    JTextField nameOfPlaza;
    PlazaImpl myPlaza;

    void Start() {
        start = new JFrame();
        start.setSize(500, 500);
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
            String name = nameOfUser.getText();
            String plazaName = nameOfPlaza.getText();
            myPlaza = new PlazaImpl(name, plazaName);
            start.setVisible(false);
            menu();


        }
    }

    void menu() {

        JFrame menu = new JFrame();
        menu.setSize(600, 600);
        JLabel Welcome = new JLabel(myPlaza.toString() + " Press: ");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton ten = new JButton("10");

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
        menu.setVisible(true);


    }

}

