package main.Classes;

import javax.management.relation.Role;
//import javax.swing.*;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private UserRole role;
    private ArrayList<Product> productList=new ArrayList<Product>(); //to be revised in future

    public User(String username, String password, String name, String surnmae, String email, String phoneNumber, UserRole role){
        this.username=username;
        this.password=password;
        this.name=name;
        this.surname=surnmae;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.role=role;
    }

    public void addProduct(Product p){
        productList.add(p);
    }

    public void addAllProducts(ArrayList<Product> productList){
        this.productList.addAll(productList);
    }

    public String toString(){
        return username+" - "+name+" "+surname+'\n'+email+" "+phoneNumber+", role: "+role;
    }

    public boolean validCredentials(String username, String password){
        if(username.equals(this.username)&&password.equals(this.password))
            return true;
        return false;
    }
}
