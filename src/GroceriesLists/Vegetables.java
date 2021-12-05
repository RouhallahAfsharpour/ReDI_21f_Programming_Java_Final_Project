package GroceriesLists;


import java.time.LocalDate;
import java.util.*;

public class Vegetables extends Groceris {


    Map<Groceris,Float> vegetablesShoppingCart = new HashMap<>();

    // this List should store all the Groceries with the Information of Them
    private List<Groceris> vegiList = new ArrayList<>();

    // this should store the Groceries Names in a List so the user can choose from here
    private HashMap<Integer, Groceris> listOfVegetables = new HashMap<>();

    public Vegetables(String name, String vegi, float price, Date productionsDate, Date expirationsDate, float calories) {
        super(name, vegi, price, productionsDate, expirationsDate, calories);
    }

    public Vegetables(){

    }



    public List<Groceris> addToTheList(){

        Vegetables tomato = new Vegetables("Tomato", Category.vegitables , 1.99f, new Date(121,11,10),   new Date(121,11,25) , 189f);
        Vegetables cucumber =  new Vegetables("Cucumber", Category.vegitables  , 1.09f,   new Date(121, 3, 11),   new Date(121, 11, 29) , 159f);
        Vegetables potato = new Vegetables("Potato", Category.vegitables  , 2.09f,   new Date(121,5,11),   new Date(121,2,12) , 359f);
        Vegetables lettuce =  new Vegetables("Lettuce", Category.vegitables  , 1.29f,   new Date(121,11,21),   new Date(121,12,21) , 69f);
        Vegetables paprika = new Vegetables("Paprika", Category.vegitables  , 1.69f,   new Date(121,11,7),   new Date(121,12,30) , 239f);
        Vegetables sweetChilli =  new Vegetables("Sweet Chilli (Bio)", Category.vegitables  , 3.19f,   new Date(121,11,5),   new Date(121,12,7) , 129f);
        Vegetables lemon = new Vegetables("Lemon (Bio)", Category.vegitables  , 1.89f,   new Date(121,11,2),   new Date(121,12,15) , 201f);

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


    public static void launch(){

    }
    public  void run(){
        System.out.println("....... Vegetables Products .......\n");

        // make an instance of Vegetables

        // add all Products in List and Map
        addToTheList();

        // Printing the List
        printMap(listOfVegetables);

        // ask the user and add to shopping cart
        addToshoppingCart( listOfVegetables);


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
