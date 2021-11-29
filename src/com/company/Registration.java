package com.company;
import java.util.Scanner;

//RA:This class should be modified later
public class Registration {

    //RA: for all inputs through terminal we define a scanner once
    private final Scanner reader = new Scanner(System.in);

    //RA: defining the necessary fields for the registration
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;

    public Registration() {
    }

    //RA: a constructor for the user information
    public Registration(String email, String password, String firstName, String lastName, String address) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    //RA: getters and setters for user information
    public Scanner getReader() {
        return reader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //RA: a method for registering new user
    public void register(){
        System.out.println("please enter your email address: ");
        setEmail(this.reader.nextLine());
        System.out.println("please enter your password: ");
        setPassword(this.reader.nextLine());
        System.out.println("please enter your first name: ");
        setFirstName(this.reader.nextLine());
        System.out.println("please enter your last name: ");
        setLastName(this.reader.nextLine());
        System.out.println("please enter your address: ");
        setAddress(this.reader.nextLine());
    }

}
