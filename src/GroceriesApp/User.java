package GroceriesApp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class User {
    private String email;
    private String firstName;
    private List<TempOrder> ordersList=new ArrayList<>();

    //RA: for all inputs through terminal we define a scanner once
    private final Scanner reader = new Scanner(System.in);

    public User(String email, String firstName) {
        this.email = email;
        this.firstName = firstName;
    }

    public List<TempOrder> getOrdersList() {
        return ordersList;
    }

    public void orders(TempOrder order){
        ordersList.add(order);
    }


    public void askUser(){
        int userChoice =0;
        while (userChoice<3){
            System.out.println("What would you like to do, " + this.firstName + "?");
            System.out.println("[1. Add order, 2. See orders, 3. Log out]");
            int orderOfUser = reader.nextInt();
            if (orderOfUser==1){
                getOrder();
            }else if (orderOfUser==2){
                for (TempOrder order:ordersList) {
                    System.out.println(order.toString());
                }
            }else {
                userChoice =3;
            }
        }
    }

    public void getOrder(){
        int userChoice =0;
        while (userChoice<3){
            System.out.println("What would you like to order, " + this.firstName + "?");
            System.out.println("[1. Tomato, 2. Potato, 3.Nothing]");
            int orderOfUser = reader.nextInt();
            if (orderOfUser==1){
                orders(new TempOrder("Tomato", "vegetable" , 1.99f, new Date(2021,11,20),   new Date(2021,12,25) , 18f,1));
            }else if (orderOfUser==2){
                orders(new TempOrder("Potato", "vegetable" , 2.99f, new Date(2021,11,23),   new Date(2021,12,20) , 77f,2));
            }else {
                userChoice =3;
            }
        }
    }
}
