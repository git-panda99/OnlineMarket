package main.Classes;

import java.util.ArrayList;

//import javax.swing.*;

public class User {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private UserRole role;
    private ArrayList<Product> productList=new ArrayList<Product>(); //to be revised in future

    public User(String username, String password, String name, String surnamae, String email, String phoneNumber, UserRole role){
        this.username=username;
        this.password=password;
        this.name=name;
        this.surname=surnamae;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.role=role;
    }

    public void addProduct(Product p){
        if(productList.contains(p)){
            System.out.println("Product already exists");
            return;
        }
        productList.add(p);
    }

    public boolean containsProduct(Product p){
        return productList.contains(p);
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

    @Override
    public boolean equals(Object o) {
        if(o instanceof User)
        return ((User) o).username.equals(username);
        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
