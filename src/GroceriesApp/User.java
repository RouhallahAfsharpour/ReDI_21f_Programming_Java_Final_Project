package GroceriesApp;

import GroceriesLists.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class User {
    private String email;
    private String firstName;
    private List<TempOrder> ordersList=new ArrayList<>();
    private Map<LocalDateTime,List<TempOrder>> orders= new HashMap<>();
    private Map<String,Map<LocalDateTime,List<TempOrder>>> allOrders= new HashMap<>();

    LocalDateTime now = LocalDateTime.now();

    //RA: this is a relative path for the registeredUsers file - we need to change it later
    final File f = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    String fPath = (f.getPath()).replaceAll("\\\\", "/");
    private String path = (fPath.substring(0, fPath.length() - 37))+"/orders.txt";

    //RA: for all inputs through terminal we define a scanner once
    private final Scanner reader = new Scanner(System.in);

    public User(String email, String firstName) {
        this.email = email;
        this.firstName = firstName;
    }

    public List<TempOrder> getOrdersList() {
        return ordersList;
    }

    public void orders(TempOrder order){
        ordersList.add(order);
    }


    public void askUser(){
        int userChoice =0;
        while (userChoice<3){
            System.out.println("What would you like to do, " + this.firstName + "?");
            System.out.println("[1. Add order, 2. See order, 3. buy the order, 4. Log out]");
            int orderOfUser = reader.nextInt();
            if (orderOfUser==1){
                getOrder();
            }else if (orderOfUser==2){
                for (TempOrder order:ordersList) {
                    System.out.println(order.toString());
                }
                System.out.println("Do you want to keep your order? y/n");
                String confirmOrder = reader.nextLine();
                confirmOrder += reader.next();
                if (confirmOrder.toLowerCase(Locale.ROOT).equals("y")||confirmOrder.toLowerCase(Locale.ROOT).equals("yes")){
                    confirmOrder(ordersList);
                }else {
                    ordersList=new ArrayList<>();
                }
            }else if (orderOfUser==3){
                buyOrder();
                System.out.println("purchase was confirmed");
                ordersList=new ArrayList<>();
            }
            else {
                userChoice =4;
            }
        }
    }

    public void getOrder(){
        int userChoice =0;
        while (userChoice<3){
            System.out.println("What would you like to order, " + this.firstName + "?");
            System.out.println("[1. Tomato, 2. Potato, 3.Nothing]");
            int orderOfUser = reader.nextInt();
            if (orderOfUser==1){
                orders(new TempOrder("Tomato", "vegetable" , 1.99f, LocalDate.parse("2021-11-08"),   LocalDate.parse("2021-12-28") , 18f,1));
            }else if (orderOfUser==2){
                orders(new TempOrder("Potato", "vegetable" , 2.99f, LocalDate.parse("2021-12-01"),   LocalDate.parse("2021-12-21") , 77f,2));
            }else {
                userChoice =3;
            }
        }
    }

    public void confirmOrder(List<TempOrder> ordersList){
        orders.put(now,ordersList);
    }

    public void buyOrder(){
        storeOrders(orders);
    }

    public void storeOrders(Map<LocalDateTime,List<TempOrder>> orders){
        try {
            //RA: clearing the content
            //new FileWriter(this.path, false).close();
            //RA: updating the content
            FileWriter fileWriter = new FileWriter(this.path,true);
            //{{email,TimeOfOrder},{orders}}
            fileWriter.append("\n");
            for (Map.Entry<LocalDateTime, List<TempOrder>> entry : orders.entrySet()) {
                fileWriter.append("{"+"{"+this.email+","+entry.getKey().toString()+"},"+"{"+entry.getValue().toString().replace("[","").replace("]","")+"}"+"}");
                //fileWriter.append("\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

}
