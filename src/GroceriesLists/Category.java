package GroceriesLists;


import java.util.*;

public class Category {

    static Scanner sc = new Scanner(System.in);

    // initialising the name of each category
    public  static  String vegetables = " Vegetables ";
    public  static  String milkProduction = " Milk Productions";
    public  static  String meat = " Meat ";
    public  static  String fish = " Fishs";
    public  static  String sweets = " Sweets";
    public  static  String drinks = " Drinks";
    public  static String cannedFood = " Canned Food";

    Map<Integer,String> category = new HashMap<>();


    // in the constructor the List will be initialised
    public Category() {
        category = categoryToList();
    }

    public void printCategorys(){
        System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~  ");
        System.out.println("      GROCERIE'S CATEGORYS");
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
        for (Map.Entry<Integer,String> elm : category.entrySet()) {
            System.out.println("       "+elm.getKey() + " . "+ elm.getValue());
        }
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
    }

    // this method adds all categories to the List
    private Map<Integer,String> categoryToList(){
        category.put(1, vegetables);
        category.put(2,milkProduction);
        category.put(3,meat);
        category.put(4,fish);
        category.put(5,sweets);
        category.put(6,drinks);
        category.put(7,cannedFood);

        return category;
    }

    public String getVegitables() {
        return vegetables;
    }

    public String getMilkProduction() {
        return milkProduction;
    }

    public String getMeat() {
        return meat;
    }

    public String getFish() {
        return fish;
    }

    public String getSweets() {
        return sweets;
    }

    public String getDrinks() {
        return drinks;
    }

    public String getCannedFood() {
        return cannedFood;
    }

    // this method allows the user to choose the category of product and then the choosed category will be printed and it will run its process
    public static void runCategory(){
        System.out.println(" please chose the category that you want to by from : ( please enter a number )");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                Vegetables vegetables = new Vegetables();
                vegetables.run();
                break;
            case 2:
                MilkProd milk = new MilkProd();
                milk.run();
                break;
            case 3:
                Meat meat = new Meat();
                meat.run();
                break;
            case 4:
                Fishs fish = new Fishs();
                fish.run();
                break;
            case 5:
                Sweets sweet = new Sweets();
                sweet.run();
                break;
            case 6:
                Drinks drink = new Drinks();
                drink.run();
                break;
            case 7:
                CannedFood cannedFood = new CannedFood();
                cannedFood.run();
                break;
            default:
                runCategory();
                break;
        }
    }

    @Override
    public  String toString() {
        final StringBuffer sb = new StringBuffer("Category : \n ");
        sb.append(" ").append(category);
        sb.append(" \n .......... ");
        return sb.toString();
    }
}

