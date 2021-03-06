package classes;

import java.util.ArrayList;

//import javax.swing.*;

public class User {
    private String username;
    private Password password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private UserRole role;
    private ArrayList<Product> productList=new ArrayList<Product>(); //to be revised in future
    private ArrayList<Order> orderList= new ArrayList<>();

    public User(String username, String passwordString, String name, String surnamae, String email, String phoneNumber, UserRole role) throws Exception{
        this.username=username;
        this.password=new Password(passwordString);
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

    public void addOrder(Order o){
        orderList.add(o);
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

    public boolean validCredentials(String username, String password)throws Exception{
        if(username.equals(this.username)&&(new Password(password, this.password.getSalt())).equals(this.password))
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

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

  public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserRole getRole() {
        return role;
    }
}
