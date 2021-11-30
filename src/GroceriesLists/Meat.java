package GroceriesLists;

import java.util.*;

public class Meat extends Groceris{

    Map<Groceris,Float> meatShoppingCart = new HashMap<>();

    private List<Groceris> meatList = new ArrayList<>();

    private HashMap<Integer, Groceris> listOfMeatProducts = new HashMap<>();

    public Meat(String name, String category, float price, Date productionsDate, Date expirationsDate, float calories) {
        super(name, category, price, productionsDate, expirationsDate, calories);
    }
    public Meat(){

    }

    public List<Groceris> addToTheList(){
        Meat rumpsteak = new Meat("Rumpsteak 1kg", Category.meat , 105.90f ,   new Date(121,8,1),   new Date(122,3,1 ), 1299f);
        Meat skirtSteak =new Meat("Skirt Steak 1kg", Category.meat , 41.69f ,   new Date(121,9,11),   new Date(121,12,31) , 1059f);
        Meat chickenBreast =new Meat("Chicken Breast 1kg", Category.meat , 6.29f ,   new Date(121,7,1),   new Date(122,2,1) , 659f);
        Meat salami =new Meat("Salami 300g", Category.meat , 1.99f ,   new Date(121,10,1),   new Date(122,6,1) , 879f);
        Meat turkey =new Meat("Turkey 1kg", Category.meat , 9.99f ,   new Date(121,8,1),   new Date(121,2,11) , 1449f);
        Meat beefSausages =new Meat("Beef Sausages 1 pakage", Category.meat , 4.99f ,   new Date(121,11,10),   new Date(122,2,10) , 979f);
        Meat chickenSausages =new Meat("Chicken Sausages", Category.meat , 3.79f ,   new Date(121,11,10),   new Date(122,2,10) , 749f);

        this.meatList.add(rumpsteak);
        this.meatList.add(skirtSteak);
        this.meatList.add(chickenBreast);
        this.meatList.add(salami);
        this.meatList.add(turkey);
        this.meatList.add(beefSausages);
        this.meatList.add(chickenSausages);

        this.listOfMeatProducts.put(1,rumpsteak);
        this.listOfMeatProducts.put(2,skirtSteak);
        this.listOfMeatProducts.put(3,chickenBreast);
        this.listOfMeatProducts.put(4,salami);
        this.listOfMeatProducts.put(5,turkey);
        this.listOfMeatProducts.put(6,beefSausages);
        this.listOfMeatProducts.put(7,chickenSausages);

        return meatList;
    }

    @Override
    public void run() {
        System.out.println("....... Meat Products .......\n");

        // make an instance of Vegetables
        Meat v = new Meat();

        // add all Products in List and Map
        addToTheList();

        // Printing the List
        printMap(listOfMeatProducts);

        // ask the user and add to shopping cart
        addToshoppingCart( listOfMeatProducts);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append(super.getName() + "  ");
        //  sb.append(super.toString());

        return sb.toString();
    }
}
