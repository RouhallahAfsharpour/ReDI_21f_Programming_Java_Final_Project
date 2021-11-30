package GroceriesLists;

import java.util.*;

public class Drinks extends Groceris{

    Map<Groceris,Float> drinksShoppingCart = new HashMap<>();

     List<Groceris> drinkList = new ArrayList<>();

     HashMap<Integer, Groceris> listOfDrinksProducts = new HashMap<>();

    public Drinks(String name, String category, float price, Date productionsDate, Date expirationsDate, float calories) {
        super(name, category, price, productionsDate, expirationsDate, calories);
    }

    public Drinks(){

    }

    public List<Groceris> addToTheList(){
        Drinks cola = new Drinks("Coca Cola ", Category.drinks, 1.09f ,   new Date(121,8,1),   new Date(121,2,3) , 486f);
        Drinks sprite =new Drinks("Sprite", Category.drinks, 1.79f ,   new Date(121,11,11),   new Date(123,2,23) , 355f);
        Drinks redbull =new Drinks("Red Bull", Category.drinks, 1.67f ,   new Date(121,9,1),   new Date(123,2,2) , 459f);
        Drinks orangeJuice =new Drinks("Orange Juice", Category.drinks, 1.99f ,   new Date(121,10,12),   new Date(122,6,1) , 388f);
        Drinks appleJuice =new Drinks("Apple Juice", Category.drinks, 1.99f ,   new Date(121,7,1),   new Date(121,5,11) , 349f);
        Drinks tonicWater =new Drinks("Tonic Water", Category.drinks, 0.49f ,   new Date(121,12,10),   new Date(123,3,13), 69f);
        Drinks bier =new Drinks("Bier", Category.drinks, 0.79f ,   new Date(121,11,10),   new Date(123,4,10) , 549f);

        this.drinkList.add(cola);
        this.drinkList.add(sprite);
        this.drinkList.add(redbull);
        this.drinkList.add(orangeJuice);
        this.drinkList.add(appleJuice);
        this.drinkList.add(tonicWater);
        this.drinkList.add(bier);

        this.listOfDrinksProducts.put(1,cola);
        this.listOfDrinksProducts.put(2,sprite);
        this.listOfDrinksProducts.put(3,redbull);
        this.listOfDrinksProducts.put(4,orangeJuice);
        this.listOfDrinksProducts.put(5,appleJuice);
        this.listOfDrinksProducts.put(6,tonicWater);
        this.listOfDrinksProducts.put(7,bier);

        return drinkList;
    }

    @Override
    public void run() {
        System.out.println("....... Fish Products .......\n");

        // make an instance of Vegetables
       // Drinks v = new Drinks();

        // add all Products in List and Map
        addToTheList();

        // Printing the List
        printMap(listOfDrinksProducts);

        // ask the user and add to shopping cart
        addToshoppingCart( listOfDrinksProducts);

    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append(super.getName() + "  ");
        //  sb.append(super.toString());

        return sb.toString();
    }
}
