package GroceriesApp;

//RA: this class is for superusers
public class Admin extends Registration {

    public Admin(String email, String password, String firstName, String lastName, String address, String userType) {
        super(email, password, firstName, lastName, address,"admin");
    }



}
