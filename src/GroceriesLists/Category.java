package GroceriesLists;


import java.util.*;

public class Category {

    private  Scanner sc = new Scanner(System.in);

    // inizializing the name of each category
    private  String vegitables = " Vegetables ";
    private  String milkProduction = " Milk Productions";
    private  String meat = " Meat ";
    private  String fish = " Fishs";
    private  String sweets = " Sweets";
    private  String drinks = " Drinks";
    private  String cannedFood = " Canned Food";

    Map<Integer,String> category = new HashMap<>();


    // in the constructor the List will be inizialized
    public Category() {
        category = categoryToList();
    }


    // this method adds all categorys to the List
    private Map<Integer,String> categoryToList(){
        category.put(1,this.vegitables);
        category.put(2,this.milkProduction);
        category.put(3,this.meat);
        category.put(4,this.fish);
        category.put(5,this.sweets);
        category.put(6,this.drinks);
        category.put(7,this.cannedFood);

        return category;
    }

    public String getVegitables() {
        return vegitables;
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

    // this method allows the user to chose the category of product and then the chosed category will be printed and it will run its process
    public void runCategory(){
        System.out.println(" please chose the category that you want to by from : ( please enter a number )");
        int choice = this.sc.nextInt();

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
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category : \n ");
        sb.append(" ").append(category);
        sb.append(" \n .......... ");
        return sb.toString();
    }
}

