package GroceriesLists;
import java.io.*;
import java.util.*;

public class GroceriesManagement {

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
                if(log.doLogin(read())){
                    //go to luay's classes for shoping, etc
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
            fileWriter.append(reg.getEmail()+","+reg.getPassword()+","+reg.getFirstName()+","+reg.getLastName()+","+reg.getAddress());
            fileWriter.flush();
            fileWriter.close();
            System.out.println("registered successfully");
        } catch (IOException e) {
            e.getMessage();
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
                list.add(new Registration(elements[0], elements[1], elements[2], elements[3], elements[4]));
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

}
