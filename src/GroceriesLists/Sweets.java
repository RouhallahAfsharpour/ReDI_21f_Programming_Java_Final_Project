package GroceriesLists;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Sweets extends Groceris{
    String drinks = " Sewwts ";

    private List<Groceris> sweetList = new ArrayList<>();

    private HashMap<Integer, Groceris> listOfSweetsProducts = new HashMap<>();

    public Sweets(String name, String category, float price, Date productionsDate, Date expirationsDate, float calories) {
        super(name, category, price, productionsDate, expirationsDate, calories);
    }

    public Sweets(){

    }

    public List<Groceris> addToTheList(){
        Sweets donuts = new Sweets(" Donuts 6 x piece", drinks, 1.99f ,   new Date(121,9,10),   new Date(122,10,10) , 686f);
        Sweets chocolate =new Sweets("Chocolate", drinks, 1.59f ,   new Date(121,11,1),   new Date(123,2,31) , 555f);
        Sweets cheeseCake =new Sweets("Cheese Cake 1 x piece", drinks, 2.67f ,   new Date(121,9,1),  new Date(122,2,1) , 359f);
        Sweets snickers =new Sweets("Snickers 1 x package", drinks, 1.99f ,   new Date(121,10,12),   new Date(121,6,3) , 688f);
        Sweets twinkies =new Sweets("Twinkies 1 x package", drinks, 8.99f ,   new Date(121,7,1),   new Date(122,5,11) , 949f);
        Sweets iceCream =new Sweets("Ice Cream", drinks, 2.49f ,   new Date(121,12,10),   new Date(123,3,10) , 569f);
        Sweets lollipop =new Sweets("Lollipop 1 x package", drinks, 3.79f ,   new Date(121,11,10),   new Date(123,4,10) , 649f);

        this.sweetList.add(donuts);
        this.sweetList.add(chocolate);
        this.sweetList.add(cheeseCake);
        this.sweetList.add(snickers);
        this.sweetList.add(twinkies);
        this.sweetList.add(iceCream);
        this.sweetList.add(lollipop);

        this.listOfSweetsProducts.put(1,donuts);
        this.listOfSweetsProducts.put(2,chocolate);
        this.listOfSweetsProducts.put(3,cheeseCake);
        this.listOfSweetsProducts.put(4,snickers);
        this.listOfSweetsProducts.put(5,twinkies);
        this.listOfSweetsProducts.put(6,iceCream);
        this.listOfSweetsProducts.put(7,lollipop);

        return sweetList;
    }

    @Override
    public void run() {
        System.out.println("....... Fish Products .......\n");

        // make an instance of Vegetables
        Sweets v = new Sweets();

        // add all Products in List and Map
        addToTheList();

        // Printing the List
        printMap(listOfSweetsProducts);

        // ask the user and add to shopping cart
        addToshoppingCart(super.shoppingCart, listOfSweetsProducts, v);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append(super.getName() + "  ");
        //  sb.append(super.toString());

        return sb.toString();
    }
}
