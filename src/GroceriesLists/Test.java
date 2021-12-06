package GroceriesLists;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test{

    // this Map stors all the chosen Groceries. I had to nake it like this unfotunately becyuse it doesn't work anyway.
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
