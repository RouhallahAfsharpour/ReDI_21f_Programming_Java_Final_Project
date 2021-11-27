package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GroceriesApp {

    //RA: for all inputs through terminal we define a scanner once
    private final Scanner reader = new Scanner(System.in);

    //RA: This is a method for just greeting, this would be the first thing to be shown after running the app
    public String greeting(){
        return "Hello, Welcome to the Groceries App";
    }

    //RA: this method shows the options which user can choose
    private final String[] userOptions = {
            "1. Login", "2. Register as new", "3.Quit"
    };

    //RA: this method will ask user to login or register or quit
    public int getUsersChoice() {
        //RA: ask the user to insert a number to choose a performance
        int choice;
        while (true) {
            System.out.println("Please choose 1, 2 or 3 for: \n"+ Arrays.toString(userOptions));
            Random reader = null;
            choice = reader.nextInt();
            if (choice > 3 || choice < 1) {
                System.out.println("Please enter a valid number!");
            } else {
                break;//RA:if the user types the correct option 1, 2 or 3, then it will break and show the result. Otherwise, the while loop ask the user to give the correct option
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        GroceriesApp app = new GroceriesApp();
        app.greeting();
        app.getUsersChoice();
    }

}

