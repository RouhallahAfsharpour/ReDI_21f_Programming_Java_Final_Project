package GroceriesApp;

import GroceriesLists.Main;
import GroceriesLists.Test;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class User {
    private String email;
    private String firstName;
    private List<TempOrder> ordersList=new ArrayList<>();
    private Map<LocalDateTime,List<TempOrder>> orders= new HashMap<>();
    private Map<String,Map<LocalDateTime,List<TempOrder>>> allOrders= new HashMap<>();

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();
    //LocalDateTime now = LocalDateTime.now();

    //RA: this is a relative path for the Orders file - we need to change it later
    final File fOrders = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    String fPathOrders = (fOrders.getPath()).replaceAll("\\\\", "/");
    private String pathOrders = (fPathOrders.substring(0, fPathOrders.length() - 37))+"/orders.txt";

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

    //RA: this part will ask the user to choose something to do
    public void askUser() throws IOException {
        int userChoice =0;
        while (userChoice<3){
            System.out.println("--------------------------------------------------");
            System.out.println("What would you like to do, " + this.firstName + "?");
            System.out.println("[1. Add order, 2. see previous orders, 3. Log out]");
            int orderOfUser = reader.nextInt();
            if (orderOfUser==1){
                getOrder();
            } else if (orderOfUser==2){
                readOrdersForUser(this.email);
            } else {
                userChoice =3;
            }
        }
    }

    public void getOrder(){
        //RA: In this part my codes will be connected to the Luay's codes
        Test.launchCategorys();
        if (!Test.shoppingCart.isEmpty()){
            storeOrders();
        }
    }
    //RA: this part will save the orders to the file
    public void storeOrders(){
        List<String> eachBill=new ArrayList<>();
        try {
            //RA: updating the content
            FileWriter fileWriter = new FileWriter(this.path,true);
            fileWriter.append("\n");
            float sum = 0;
            for (Map.Entry<String,Float> entry : Test.shoppingCart.entrySet()) {
                eachBill.add(entry.getKey());
                sum += entry.getValue();
            }
            fileWriter.append(this.email+";"+Arrays.toString(eachBill.toArray())+";"+sum+";"+dtf.format(now));

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //RA: this part will read the orders for user from the file of orders
    public void readOrdersForUser(String emailOfTheUser) throws IOException {
        double totalPaid=0;
        boolean check = false;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(this.pathOrders));
            String firstLine = fileReader.readLine();
            String line = "";
            while ((line = fileReader.readLine()) != null) {
                //This part should be corrected !
                String[] elements = line.split(";");
                String[] items=elements[1].replace("[","").replace("]","").split(",");
                if (elements[0].equals(emailOfTheUser)){
                    check = true;
                    System.out.println(elements[3]+" You ordered "+items.length+" items: "+elements[1]+" and paid "+Math.round(Double.parseDouble(elements[2])*100.0)/100.0+" $ ");
                    totalPaid+=Math.round(Double.parseDouble(elements[2])*100.0)/100.0;
                }
            }
            if (check==true){
                System.out.println("You paid in total "+totalPaid+" $ ");
            }else {
                System.out.println("You have never ordered with us");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
