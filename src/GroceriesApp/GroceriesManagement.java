package GroceriesApp;
import GroceriesLists.Main;

import java.io.*;
import java.util.*;

public class GroceriesManagement {

    //RA: this is a relative path for the Orders file - we need to change it later
    final File fOrders = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    String fPathOrders = (fOrders.getPath()).replaceAll("\\\\", "/");
    private String pathOrders = (fPathOrders.substring(0, fPathOrders.length() - 37))+"/orders.txt";

    //RA: for all inputs through terminal we define a scanner once
    private final Scanner reader = new Scanner(System.in);

    //RA: this is a relative path for the registeredUsers file - we need to change it later
    final File f = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    String fPath = (f.getPath()).replaceAll("\\\\", "/");
    private String path = (fPath.substring(0, fPath.length() - 37))+"/registeredUsers.csv";

    //RA: This is a method for just greeting, this would be the first thing to be shown after running the app
    public void greeting(){
        System.out.println("Hello, Welcome to the Groceries App");
    }

    //RA: this method shows the options which user can choose
    private final String[] userOptions = {
            "1. Login", "2. Register as new", "3. Restore the password", "4. Quit"
    };

    //RA: this method will ask user to login or register or quit
    public int getUsersChoice() {
        //RA: ask the user to insert a number to choose a performance
        int choice;
        while (true) {
            System.out.println("Please choose 1, 2, 3 or 4 for: \n"+ Arrays.toString(userOptions));
            choice = reader.nextInt();
            if (choice > 4 || choice < 1) {
                System.out.println("Please enter a valid number!");
            } else {
                break;//RA:if the user types the correct option 1, 2, 3 or 4, then it will break and show the result. Otherwise, the while loop ask the user to give the correct option
            }
        }
        return choice;
    }

    //RA: this will initiate an action based on given option
    public void performAction(int option) throws IOException {
        //RA: The user is asked to pick a choice using the numeric values associated
        switch (option) {
            case 1:
                //RA: Login as an already registered user
                Login log = new Login();
                int optionChosen = log.doLogin(read());
                /*if(optionChosen==0){
                    //RA:go to normal user area: Luay's classes for shopping, etc
                } else*/
                if(optionChosen==1){
                    //RA: go to admin area
                    adminArea();
                }
                break;
            case 2:
                //RA: Register as a new user
                Registration reg = new Registration();//RA: create a new instance of Registration with those inputs
                reg.register();
                if (checkEmail(reg.getEmail())){
                    System.out.println("This email address is already registered! ");
                    if(confirm("Do you want to restore your password?")){
                        System.out.println(restorePass(reg.getEmail()));
                    }else {
                        break;
                    }

                } else {
                    registerNewUser(reg);
                }
                break;
            case 3:
                //RA: restoring the password
                System.out.println("please enter your email address: ");
                String emailForRestoringPassword = this.reader.nextLine();
                emailForRestoringPassword += this.reader.next();
                System.out.println(this.restorePass(emailForRestoringPassword));
                break;
            case 4:
                //RA: Quit
                this.quit();
                break;
            default:
                System.out.println("Sorry! Please put a valid option.");
        }
    }

    //RA: this will end the application
    public void quit() {
        System.out.println("Thank you for your visit");
        System.exit(0);
    }

    public boolean confirm(String message) {
        //RA: this is a boolean method for the time we ask yes or no question from the user
        String choice ;
        do{
            System.out.printf("%s (y/n)\n",message);
            choice = this.reader.next();
            choice += this.reader.nextLine();
            if(choice.length() > 0){
                choice = choice.trim();
            }
            choice = choice.toLowerCase();

        }while(! choice.startsWith("y") && ! choice.startsWith("n"));
        //check if the user choice is yes : true otherwise false
        return choice.startsWith("y");
    }

    //RA: for registering and storing the user data in file
    public void registerNewUser(Registration reg){
        try {
            FileWriter fileWriter = new FileWriter(this.path,true);
            fileWriter.append("\n");
            fileWriter.append(reg.getEmail()+","+reg.getPassword()+","+reg.getFirstName()+","+reg.getLastName()+","+reg.getAddress()+","+reg.getUserType());
            fileWriter.flush();
            fileWriter.close();
            System.out.println("registered successfully");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //RA: create a default admin
    public void createAdmin() throws IOException {
        if (!checkEmail("admin")){
            Admin defaultAdmin = new Admin("admin","admin","","","","admin");
            registerNewUser(defaultAdmin);
        }


    }

    //RA: this method reads all data stored in registeredUsers file and put them in a list
    public List<Registration> read() throws IOException{
        List<Registration> list = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(this.path));
            String firstLine = fileReader.readLine();

            String line = "";
            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(",");
                list.add(new Registration(elements[0], elements[1], elements[2], elements[3], elements[4],elements[5]));
            }
        }catch (IOException e){
            e.getMessage();
        }
        return list;
    }

    //RA: check if the email is already available in stored data
    public boolean checkEmail(String email) throws IOException {
        List<Registration> listOfRegisteredUsers = read();
        for (Registration reg : listOfRegisteredUsers){
            if (reg.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    //RA: for restoring the password
    public String restorePass(String emailForRestoring) throws IOException {
        //RA: we ask the user to provide first and last name and we check if these are the same for this email address
        String restoredPass="";
        System.out.println("please enter your first name: ");
        String firstNameValidation = this.reader.nextLine();
        firstNameValidation += this.reader.next();
        System.out.println("please enter your last name: ");
        String lastNameValidation = this.reader.nextLine();
        lastNameValidation += this.reader.next();
        List<Registration> listOfRegisteredUsers = read();
        for (Registration registered : listOfRegisteredUsers){
            if (registered.getEmail().equals(emailForRestoring)){
                if (firstNameValidation.equals(registered.getFirstName()) && lastNameValidation.equals(registered.getLastName())) {
                    restoredPass = registered.getPassword();
                    return "Your password is: " + restoredPass;
                }else{
                    return "The input was invalid!";
                }
            }
        }
        return "The input was invalid!";
    }

    //RA: This is an area for admin
    public void adminArea() throws IOException {
        int adminChoice=0;
        while (adminChoice!=5){
            System.out.println("Please choose 1, 2, or 3 for:");
            System.out.println("[1. See the list of users, 2.Make a user admin, 3. delete a user, 4.See the orders of a user, 5. Log out]");
            adminChoice = this.reader.nextInt();
            if (adminChoice==1){
                System.out.println(read().toString());
            }else if(adminChoice==2 || adminChoice==3){
                System.out.println("Please type the email of the user: ");
                String emailOfUser = this.reader.nextLine();
                emailOfUser += this.reader.next();
                List<Registration> listOfCurrentUsers = read();
                for (Registration registered : listOfCurrentUsers){
                    if (registered.getEmail().equals(emailOfUser)){

                        if (adminChoice==2){
                            registered.setUserType("admin");
                        } else if(adminChoice==3){
                            listOfCurrentUsers.remove(registered);
                        }
                    }
                }
                try {
                    //RA: clearing the content
                    new FileWriter(this.path, false).close();
                    //RA: updating the content
                    FileWriter fileWriter = new FileWriter(this.path,true);
                    fileWriter.append("email,password,firstName,lastName,address,userType");
                    fileWriter.append("\n");
                    for (Registration user : listOfCurrentUsers) {
                        fileWriter.append(user.getEmail() + "," + user.getPassword() + "," + user.getFirstName() + "," + user.getLastName() + "," + user.getAddress() + "," + user.getUserType());
                        fileWriter.append("\n");
                    }
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            } else if (adminChoice==4){
                System.out.println("Please type the email of the user: ");
                String emailOfTheUser = this.reader.nextLine();
                emailOfTheUser += this.reader.next();
                readOrders(emailOfTheUser);
            } else {
                System.out.println("under development!");
            }
        }


    }

    //RA: this method reads all orders stored in orders.txt file and put them in a list
    private void readOrders(String emailOfTheUser) throws IOException {
        List<TempOrder> list = new ArrayList<>();
        boolean check = false;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(this.pathOrders));
            String firstLine = fileReader.readLine();

            String line = "";
            while ((line = fileReader.readLine()) != null) {
                //This part should be corrected !
                String[] elements = line.split(",");
                String[] emailAndOrderTime =elements[0].replace("{","").replace("}","").split(",");
                if (emailAndOrderTime[0].equals(emailOfTheUser)){
                    check = true;
                    System.out.println(line);
                }
            }
            if (check==false){
                System.out.println("the typed email is not correct!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
