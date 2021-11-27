package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class GroceriesManagement {

    //RA: for all inputs through terminal we define a scanner once
    private final Scanner reader = new Scanner(System.in);

    //RA: This is a method for just greeting, this would be the first thing to be shown after running the app
    public void greeting(){
        System.out.println("Hello, Welcome to the Groceries App");
    }

    //RA: this method shows the options which user can choose
    private final String[] userOptions = {
            "1. Login", "2. Register as new", "3. Quit"
    };

    //RA: this method will ask user to login or register or quit
    public int getUsersChoice() {
        //RA: ask the user to insert a number to choose a performance
        int choice;
        while (true) {
            System.out.println("Please choose 1, 2 or 3 for: \n"+ Arrays.toString(userOptions));
            choice = reader.nextInt();
            if (choice > 3 || choice < 1) {
                System.out.println("Please enter a valid number!");
            } else {
                break;//RA:if the user types the correct option 1, 2 or 3, then it will break and show the result. Otherwise, the while loop ask the user to give the correct option
            }
        }
        return choice;
    }

    //RA: this will initiate an action based on given option
    public void performAction(int option) {
        //RA: The user is asked to pick a choice using the numeric values associated
        switch (option) {
            case 1:
                //RA: Login as an already registered user
                //this.login();
                break;
            case 2:
                //RA: Register as new user
                Registration reg = new Registration();//RA: create a new instance of Registration with those inputs
                reg.register();
                reg.toString();
                break;
            case 3:
                //RA: Quit
                this.quit();
                break;
            default:
                System.out.println("Sorry! Please put a valid option.");
        }
    }

    //RA: this will end the application
    public void quit() {
        System.out.println("Thank you for your visit");
        System.exit(0);
    }

    public boolean confirm(String message) {
        //RA: this is a boolean method for the time we ask yes or no question from the user
        String choice ;
        do{
            System.out.printf("%s (y/n)\n",message);
            choice = this.reader.next();
            choice += this.reader.nextLine();
            if(choice.length() > 0){
                choice = choice.trim();
            }
            choice = choice.toLowerCase();

        }while(! choice.startsWith("y") && ! choice.startsWith("n"));
        //check if the user choice is yes : true otherwise false
        return choice.startsWith("y");
    }

}
