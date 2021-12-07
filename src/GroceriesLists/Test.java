package GroceriesLists;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test{

    // this Map stores all the chosen Groceries. I had to make it like this unfortunately because it doesn't work anyway.
    public static Map<String,Float> shoppingCart = new HashMap<>();

    public static void launchCategorys() {
          Category c = new Category();
          c.printCategorys();
          Category.runCategory();


    }
    public static void main(String[] args) {

        launchCategorys();

    }
}
