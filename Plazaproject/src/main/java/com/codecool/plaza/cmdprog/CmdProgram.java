package com.codecool.plaza.cmdprog;

import com.codecool.plaza.api.*;
import java.util.List;
import java.util.Scanner;

public class CmdProgram {
    private List<Product> cart;
    Scanner reader = new Scanner(System.in);
    PlazaImpl myPlaza;

    public CmdProgram(String[] args) {

    }

    public void run() {
        System.out.println("Enter your name:");
        String owner = reader.nextLine();
        while (true){
        System.out.println("There are no plaza created yet! Press/n 1) to create a new plaza./n 2) to exit.");
        String choose = reader.nextLine();
        if (choose.equals("1")) {
            System.out.println("Enter the name of your plaza:");
            String plazaName = reader.nextLine();
            myPlaza = new PlazaImpl(owner,plazaName);
            break;
        }
        else if(choose.equals("2")) {
            System.out.println("Bye!");
            System.exit(0);
        }
        else {
            System.out.println("Wrong input entered");
        }

        }
        while (true){
            System.out.println("Welcome to the " + myPlaza.getName() + "!\n The owner name is: " + myPlaza.getOwner()+"\n Press \n1) to list all shops. \n2) to add a new shop. \n3) to remove an existing shop. \n4) enter a shop by name. \n5) to open the plaza. \n6) to close the plaza. \n7) to check if the plaza is open or not.");
        }


    }
}
