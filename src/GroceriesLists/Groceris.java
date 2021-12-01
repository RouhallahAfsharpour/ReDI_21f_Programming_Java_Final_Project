package GroceriesLists;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public abstract class Groceris {

    // this is the Last List of chosen Groceries which the user chosed
   // List<Map<Groceris,Float>> shoppingCart = new ArrayList<>();

   //  Map<Groceris,Float> shoppingCart = new HashMap<>();




    // the First properties of the Groceries

    // that gives the current date of today
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();


    private String name;
    private String category;
    private float price;
    private Date productionsDate ;
    private Date expirationsDate ;
    private float calories;

    // scanner to use in all classes that extends this class
    Scanner sc = new Scanner(System.in);

    // empty Constructor
    public Groceris() {
    }

    // constructor for the properties
    public Groceris(String name, String category, float price, Date productionsDate, Date expirationsDate, float calories) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.productionsDate = productionsDate;
        this.expirationsDate = expirationsDate;
        this.calories = calories;
    }




    // adding the Products in a List
    public abstract  List<Groceris> addToTheList();

    // this method will be in every class to run the process individually
    public abstract void run();

    // this method prints the ArryList that given as a Parameter
    public void printList(List<Groceris> list){
        for(Groceris elm : list) {
            System.out.println(elm.toString());
        }
    }

    // this method prints the HashMap that given as a Parameter : this used to print the List of our Groceries that the User should choose from
    public void printMap(HashMap<Integer,Groceris> map){
        for (Integer key: map.keySet()){
            System.out.println(key+ ". " + map.get(key));
        }
    }

    // this method allows the User to choose between the Groceries and add them to the shopping cart
    public  void addToshoppingCart(HashMap<Integer,Groceris> map){

        // asking the user what he want to by
        System.out.println(" Please choose what you want to by : ");
        int num = this.sc.nextInt();

        // when he chose something he will get the Information of the Grocerie he chosed
        if(map.containsKey(num) ){
            System.out.println(map.get(num).infoToString()+ "\n");

            // here he should decid if he want to by it and add it to the shopping cart or not
            System.out.println("would you like to add this product to the shoping cart? (please choose a number 1 or 2 )\n" +
                    "1. yes please \n" +
                    "2. no thanks \n");
            int choice = this.sc.nextInt();
            // if he press number 1 the program will add to the shopping cart and ask again if he wanna chose something else
            if(choice == 1){
                Test.shoppingCart.put(map.get(num).getName(),map.get(num).getPrice());
                askUserAgain();
            }
            // he press 2 it will ask hem if he want to chose another product
            else{
                askUserAgain();
            }

        }
        // return shoppingCart;
    }

    // this Method asks the user one more time if he want to add another product
    public void askUserAgain(){
        System.out.println("would you like to add another  product from this Category? (please choose a number 1 or 2 )\n" +
                "1. yes please \n" +
                "2. no thanks, go to Main Menu \n" +
                "3. Finish, go to Payment");
        int choice = this.sc.nextInt();
        if(choice == 1){
            run();
        }
        else if(choice == 2){
            Test.launchCategorys();

        }
        else if(choice == 3){
            printShoppingCart();
        }
        else{
            System.out.println(" invalid Input! please choose one of the numbers 1,2,3! ");
            askUserAgain();
        }
    }


    public String getName() {
        return name;
    }
    public float getCalories() {
        return calories;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public Date getProductionsDate() {
        return productionsDate;
    }

    public Date getExpirationsDate() {
        return expirationsDate;
    }

    // printing the Last Bill this method contains the current date
    public static void printShoppingCart(){



        System.out.println("\n\n_________________________________________________ \n\n");
        System.out.println("      . . . . . . . ");
        System.out.println("      :   Bill    :      " + " current date : " + dtf.format(now));
        System.out.println("      . . . . . . . ");
        System.out.println(" \n ____________________ \n");
        System.out.println();
        float count = 0;
        for (Map.Entry<String,Float> entry : Test.shoppingCart.entrySet()) {
            System.out.println(" | "+entry.getKey()+" :    "+entry.getValue() + " $ ");
            count += entry.getValue();
        }
        System.out.println("\n  ------------------");
        System.out.println("  | Total : "+ count + " $  |");
          System.out.println("  ------------------");

    }



    // I changed the name of the toString method because it was complaining with another toString method
    public String infoToString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append("| name : | ").append(name+"\n");
        sb.append(" | category : |").append(category+"\n");
        sb.append(" | price : | ").append(price+ " $"+"\n");
        sb.append(" | productions Date : | ").append(productionsDate+"\n");
        sb.append(" | expirations Date : | ").append(expirationsDate+"\n");
        sb.append(" | calories : | ").append(calories).append(" cal");
        sb.append(" ");
        return sb.toString();
    }
}
