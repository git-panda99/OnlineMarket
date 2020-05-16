package classes;

import java.util.Objects;

public class Password {
    byte[] salt=null;
    String password;

    public Password(String password) throws Exception{
        salt=EncodePassword.createSalt();
        this.password = EncodePassword.getSecurePassword(password, salt);
    }

    public Password(String password, byte[] salt) throws Exception{
        this.password = EncodePassword.getSecurePassword(password, salt);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Password)
        if(password.equals(((Password) o).getPassword()))
        return true;
        return false;
    }

    public byte[] getSalt() {
        return salt;
    }

    public String getPassword() {
        return password;
    }

    /*
    public static void main(String[] args) throws Exception{
        Password pass1=new Password("hello");
        Password pass2=new Password("hello", pass1.getSalt());

        System.out.println("pass1: "+pass1.getPassword());
        System.out.println("pass2: "+pass2.getPassword());

        System.out.println(pass1.equals(pass2));
    }
     */
}
