package GroceriesLists;

public class Test <T>{
    public static void launchCategorys(){
        Category c = new Category();
        System.out.println(c.toString());
        c.runCategory();
    }

    public static void main(String[] args) {

        launchCategorys();

    }
}
