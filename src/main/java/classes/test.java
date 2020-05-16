package classes;

public class test {
    public static void main(String[] args) throws Exception{
        Password pass1=new Password("hello");
        Password pass2=new Password("hello", pass1.getSalt());

        System.out.println("pass1: "+pass1.getPassword());
        System.out.println("pass2: "+pass2.getPassword());

        System.out.println(pass1.equals(pass2));
    }
}
