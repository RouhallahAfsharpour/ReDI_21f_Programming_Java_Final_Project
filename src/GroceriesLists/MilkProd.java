package GroceriesLists;


import java.util.*;

public class MilkProd extends Groceris{

    Map<Groceris,Float> milkShoppingCart = new HashMap<>();

    private List<Groceris> milkList = new ArrayList<>();

    private HashMap<Integer, Groceris> listOfMilkProducts = new HashMap<>();

    public MilkProd(String name, String category, float price, Date productionsDate, Date expirationsDate, float calories) {
        super(name, category, price, productionsDate, expirationsDate, calories);
    }
    public MilkProd(){

    }

    public List<Groceris> addToTheList(){
        MilkProd mozzarella = new MilkProd("Mozzarella Cheese ", Category.milkProduction , 0.69f ,   new Date(121,8,1),   new Date(122,3,1) , 399f);
        MilkProd parmazan =new MilkProd("Parmazan Cheese ", Category.milkProduction , 1.69f ,   new Date(121,9,1),   new Date(122,2,1) , 459f);
        MilkProd creamCheese =new MilkProd("Cream Cheese ", Category.milkProduction , 1.29f ,   new Date(121,5,1),   new Date(122,4,1) , 559f);
        MilkProd curdCheese =new MilkProd("Curd Cheese ", Category.milkProduction , 0.99f ,   new Date(121,10,1),   new Date(122,9,1) , 659f);
        MilkProd milkLawFatt =new MilkProd("Milk (1.5 fatt)", Category.milkProduction , 1.09f ,   new Date(121,11,1),   new Date(121,12,1) , 149f);
        MilkProd milkHighFatt =new MilkProd("Milk (3.5 fatt)", Category.milkProduction , 0.99f ,   new Date(121,11,1),   new Date(121,12,11) , 179f);
        MilkProd yoghurt =new MilkProd("yoghurt", Category.milkProduction , 1.79f ,   new Date(121,11,10),   new Date(122,2,19) , 249f);

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
        MilkProd v = new MilkProd();

        // add all Products in List and Map
        addToTheList();

        // Printing the List
        printMap(listOfMilkProducts);

        // ask the user and add to shopping cart
         addToshoppingCart(listOfMilkProducts);

    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append(super.getName() + "  ");
        //  sb.append(super.toString());

        return sb.toString();
    }
}
