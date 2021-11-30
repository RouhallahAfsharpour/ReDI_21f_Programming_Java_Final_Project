package GroceriesLists;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CannedFood extends Groceris{
    String cannedFood = " Canned Food ";

    private List<Groceris> drinkList = new ArrayList<>();

    private HashMap<Integer, Groceris> listOfDrinksProducts = new HashMap<>();

    public CannedFood(String name, String category, float price, Date productionsDate, Date expirationsDate, float calories) {
        super(name, category, price, productionsDate, expirationsDate, calories);
    }

    public CannedFood(){

    }

    public List<Groceris> addToTheList(){
        CannedFood tuna = new CannedFood(" Tuna ", cannedFood, 1.19f ,   new Date(121,8,10),   new Date(124,10,1) , 466f);
        CannedFood tomatoSauce =new CannedFood("Tomato Sauce", cannedFood, 0.59f ,   new Date(121,10,21),   new Date(124,2,31) , 155f);
        CannedFood sardines =new CannedFood("Sardines", cannedFood, 0.79f ,   new Date(121,9,1),   new Date(124,2,1) , 559f);
        CannedFood olives =new CannedFood("Olives", cannedFood, 1.29f ,   new Date(121,10,12),   new Date(121,6,1), 228f);
        CannedFood beans =new CannedFood("Beans", cannedFood, 1.59f ,   new Date(121,7,1),   new Date(123,5,3) , 339f);
        CannedFood corn =new CannedFood("Corn", cannedFood, 1.39f ,   new Date(121,12,1),   new Date(123,5,1) , 169f);
        CannedFood pea =new CannedFood("Pea", cannedFood, 0.59f ,   new Date(121,11,10),   new Date(124,4,1) , 249f);

        this.drinkList.add(tuna);
        this.drinkList.add(tomatoSauce);
        this.drinkList.add(sardines);
        this.drinkList.add(olives);
        this.drinkList.add(beans);
        this.drinkList.add(corn);
        this.drinkList.add(pea);

        this.listOfDrinksProducts.put(1,tuna);
        this.listOfDrinksProducts.put(2,tomatoSauce);
        this.listOfDrinksProducts.put(3,sardines);
        this.listOfDrinksProducts.put(4,olives);
        this.listOfDrinksProducts.put(5,beans);
        this.listOfDrinksProducts.put(6,corn);
        this.listOfDrinksProducts.put(7,pea);

        return drinkList;
    }

    @Override
    public void run() {
        System.out.println("....... Fish Products .......\n");

        // make an instance of Vegetables
        CannedFood v = new CannedFood();

        // add all Products in List and Map
        addToTheList();

        // Printing the List
        printMap(listOfDrinksProducts);

        // ask the user and add to shopping cart
        addToshoppingCart(super.shoppingCart, listOfDrinksProducts, v);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append(super.getName() + "  ");
        //  sb.append(super.toString());

        return sb.toString();
    }
}