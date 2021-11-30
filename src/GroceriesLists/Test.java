package GroceriesLists;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test{

   static Map<String,Float> shoppingCart = new HashMap<>();

    public static void launchCategorys() {
          Category c = new Category();
          c.printCategorys();
          Category.runCategory();


    }
    public static void main(String[] args) {

        launchCategorys();

    }
}
