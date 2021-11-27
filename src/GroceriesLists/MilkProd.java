package GroceriesLists;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MilkProd extends Groceris{

    String milk = " Milk Productions";

    private List<Groceris> milkList = new ArrayList<>();

    private HashMap<Integer, Groceris> listOfMilkProducts = new HashMap<>();

    public MilkProd(String name, String category, float price, String productionsDate, String expirationsDate, float calories) {
        super(name, category, price, productionsDate, expirationsDate, calories);
    }
    public MilkProd(){

    }

    public List<Groceris> addToTheList(){
        MilkProd mozzarella = new MilkProd("Mozzarella Cheese ", milk , 0.69f , " production date : 01.08.21", " expirations date : 01.03.22" , 399f);
        MilkProd parmazan =new MilkProd("Parmazan Cheese ", milk , 1.69f , " production date : 01.09.21", " expirations date : 01.02.22" , 459f);
        MilkProd creamCheese =new MilkProd("Cream Cheese ", milk , 1.29f , " production date : 01.05.21", " expirations date : 01.04.22" , 559f);
        MilkProd curdCheese =new MilkProd("Curd Cheese ", milk , 0.99f , " production date : 01.10.21", " expirations date : 01.09.22" , 659f);
        MilkProd milkLawFatt =new MilkProd("Milk (1.5 fatt)", milk , 1.09f , " production date : 01.11.21", " expirations date : 11.12.21" , 149f);
        MilkProd milkHighFatt =new MilkProd("Milk (3.5 fatt)", milk , 0.99f , " production date : 01.11.21", " expirations date : 11.12.21" , 179f);
        MilkProd yoghurt =new MilkProd("yoghurt", milk , 1.79f , " production date : 010.11.21", " expirations date : 19.01.22" , 249f);

        this.milkList.add(mozzarella);
        this.milkList.add(parmazan);
        this.milkList.add(creamCheese);
        this.milkList.add(curdCheese);
        this.milkList.add(milkLawFatt);
        this.milkList.add(milkHighFatt);
        this.milkList.add(yoghurt);

        this.listOfMilkProducts.put(1,mozzarella);
        this.listOfMilkProducts.put(2,parmazan);
        this.listOfMilkProducts.put(3,creamCheese);
        this.listOfMilkProducts.put(4,curdCheese);
        this.listOfMilkProducts.put(5,milkLawFatt);
        this.listOfMilkProducts.put(6,milkHighFatt);
        this.listOfMilkProducts.put(7,yoghurt);

        return milkList;
    }

    @Override
    public void run() {
        System.out.println("....... Milk Products .......\n");

        // make an instance of Vegetables
        Vegetables v = new Vegetables();

        // add all Products in List and Map
        addToTheList();

        // Printing the List
        printMap(listOfMilkProducts);

        // ask the user and add to shopping cart
        addToshoppingCart(super.shoppingCart, listOfMilkProducts, v);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append(super.getName() + "  ");
        //  sb.append(super.toString());

        return sb.toString();
    }
}
