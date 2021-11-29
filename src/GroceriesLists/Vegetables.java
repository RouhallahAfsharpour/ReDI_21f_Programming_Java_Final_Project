package GroceriesLists;


import java.util.*;

public class Vegetables extends Groceris {


    String vegi = " Vegetables";

    // this List should store all the Groceries with the Information of Them
    private List<Groceris> vegiList = new ArrayList<>();

    // this should store the Groceries Names in a List so the user can choose from here
    private HashMap<Integer, Groceris> listOfVegetables = new HashMap<>();

    public Vegetables(String name, String vegi, float price, String productionsDate, String expirationsDate, float calories) {
        super(name, vegi, price, productionsDate, expirationsDate, calories);
    }

    public Vegetables(){

    }


    public List<Groceris> addToTheList(){

        Vegetables tomato = new Vegetables("Tomato", vegi , 1.99f, "  01.11.21", "  25.11.21" , 189f);
        Vegetables cucumber =  new Vegetables("Cucumber", vegi , 1.09f, "  03.11.21", "  29.11.21" , 159f);
        Vegetables potato = new Vegetables("Potato", vegi , 2.09f, "  05.11.21", "  02.12.21" , 359f);
        Vegetables lettuce =  new Vegetables("Lettuce", vegi , 1.29f, "  01.11.21", "  20.12.21" , 69f);
        Vegetables paprika = new Vegetables("Paprika", vegi , 1.69f, "  07.11.21", "  30.12.21" , 239f);
        Vegetables sweetChilli =  new Vegetables("Sweet Chilli (Bio)", vegi , 3.19f, "  05.11.21", "  07.12.21" , 129f);
        Vegetables lemon = new Vegetables("Lemon (Bio)", vegi , 1.89f, "  02.11.21", "  15.12.21" , 201f);

        this.vegiList.add(tomato);
        this.vegiList.add(cucumber);
        this.vegiList.add(potato);
        this.vegiList.add(lettuce);
        this.vegiList.add(paprika);
        this.vegiList.add(sweetChilli);
        this.vegiList.add(lemon);

        this.listOfVegetables.put(1,tomato);
        this.listOfVegetables.put(2,cucumber);
        this.listOfVegetables.put(3,potato);
        this.listOfVegetables.put(4,lettuce);
        this.listOfVegetables.put(5,paprika);
        this.listOfVegetables.put(6,sweetChilli);
        this.listOfVegetables.put(7,lemon);

        return vegiList;
    }


    public void run(){
        System.out.println("....... Vegitables .......\n");

        // make an instance of Vegetables
        Vegetables v = new Vegetables();

        // add all Products in List and Map
        addToTheList();

        // Printing the List
        printMap(listOfVegetables);

        // ask the user and add to shopping cart
        addToshoppingCart(super.shoppingCart, listOfVegetables, v);


        //  printList(super.shoppingCart);
        //  printLast();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append(super.getName() + "  ");
        //  sb.append(super.toString());

        return sb.toString();
    }


}
