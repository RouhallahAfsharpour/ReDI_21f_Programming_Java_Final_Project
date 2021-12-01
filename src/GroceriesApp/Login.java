package GroceriesApp;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Login {
    private String emailForLogin;
    private String passwordForLogin;

    //RA: for all inputs through terminal we define a scanner once
    private final Scanner reader = new Scanner(System.in);

    public int doLogin(List<Registration> listOfRegisteredUsers) throws IOException {
        System.out.println("please enter your email address: ");
        this.emailForLogin = this.reader.nextLine();
        System.out.println("please enter your password: ");
        this.passwordForLogin = this.reader.nextLine();
        return checkRegistration(listOfRegisteredUsers,this.emailForLogin,this.passwordForLogin);
    }

    //RA: check if the given password and email match the information already available in stored data
    public int checkRegistration(List<Registration> listOfRegisteredUsers,String email, String password) throws IOException {
        for (Registration reg : listOfRegisteredUsers){
            if (reg.getEmail().equals(email) && reg.getPassword().equals(password)){
                System.out.println("welcome " + reg.getFirstName());
                if (reg.getUserType().equals("admin")){
                    return 1;
                }else {
                    //RA: go to user area
                    System.out.println("User Area:");
                    User user = new User(reg.getEmail(),reg.getFirstName());
                    user.askUser();
                    return 0;
                }
            } else if (reg.getEmail().equals(email) && !reg.getPassword().equals(password)){
                System.out.println("The password is not correct!");
                System.out.println(reg.getEmail()+" is already registered, try to restore the password!");
                return -1;
            }
        }
        return -1;
    }
}
