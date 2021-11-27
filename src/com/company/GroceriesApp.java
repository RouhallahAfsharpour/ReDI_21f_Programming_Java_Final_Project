package com.company;

public class GroceriesApp {

    public static void main(String[] args) {
        GroceriesManagement app = new GroceriesManagement();

        // Welcome User
        app.greeting();

        //RA: Get the user's choice of action and perform action
        do {
            int choice = app.getUsersChoice();
            app.performAction(choice);

            //RA: confirm to do more when the action is finished
            if (!app.confirm("Do you want to perform another action?")) {
                app.quit();
            }

        } while (true);
    }
}

