package GroceriesLists;

import java.util.*;

public class Fishs extends Groceris{

    Map<Groceris,Float> fishsShoppingCart = new HashMap<>();

    private List<Groceris> fishList = new ArrayList<>();

    private HashMap<Integer, Groceris> listOfFishProducts = new HashMap<>();

    public Fishs(String name, String category, float price, Date productionsDate, Date expirationsDate, float calories) {
        super(name, category, price, productionsDate, expirationsDate, calories);
    }

    public Fishs(){

    }

    public List<Groceris> addToTheList(){
        Fishs billyBass = new Fishs("Billy Bass 1kg", Category.fish, 36.79f ,   new Date(121,8,10),   new Date(122,2,1) , 1286f);
        Fishs hummer =new Fishs("Hummer 1kg", Category.fish, 85.99f ,   new Date(121,11,11),   new Date(122,5,1) , 1155f);
        Fishs thunFish =new Fishs("Thun Fish 1kg", Category.fish, 49.67f ,   new Date(121,9,1),   new Date(122,2,2) , 1259f);
        Fishs crab =new Fishs("Crab 500g", Category.fish, 50.99f ,   new Date(121,10,1),   new Date(122,2,10) , 888f);
        Fishs salmon =new Fishs("Salmon 1kg", Category.fish, 33.99f ,   new Date(121,7,1),   new Date(121,2,1) , 1649f);
        Fishs octopus =new Fishs("Octopus 500g", Category.fish, 44.99f ,   new Date(121,12,10),   new Date(122,3,10) , 979f);
        Fishs scampi =new Fishs("Scampis 1kg", Category.fish, 25.79f ,   new Date(121,11,1),   new Date(122,4,10) , 1349f);

        this.fishList.add(billyBass);
        this.fishList.add(hummer);
        this.fishList.add(thunFish);
        this.fishList.add(crab);
        this.fishList.add(salmon);
        this.fishList.add(octopus);
        this.fishList.add(scampi);

        this.listOfFishProducts.put(1,billyBass);
        this.listOfFishProducts.put(2,hummer);
        this.listOfFishProducts.put(3,thunFish);
        this.listOfFishProducts.put(4,crab);
        this.listOfFishProducts.put(5,salmon);
        this.listOfFishProducts.put(6,octopus);
        this.listOfFishProducts.put(7,scampi);

        return fishList;
    }

    @Override
    public void run() {
        System.out.println("....... Fish Products .......\n");

        // make an instance of Vegetables
        Fishs v = new Fishs();

        // add all Products in List and Map
        addToTheList();

        // Printing the List
        printMap(listOfFishProducts);

        // ask the user and add to shopping cart
        addToShoppingCart( listOfFishProducts);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append(super.getName() + "  ");
        //  sb.append(super.toString());

        return sb.toString();
    }
}
