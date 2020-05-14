package main.Classes;

public enum UserRole {
    CUSTOMER("Customer"),
    FARMER("Farmer"),
    ADMIN("Admin");
    private final String role;
    UserRole(String role){
        this.role=role;
    };

    public String toString(){
        return role;
    }
}
