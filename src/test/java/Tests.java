import classes.*;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class Tests extends TestCase {

    public Tests(String s){
        super(s);
    }

    private Product product;
    private User user;
    private ArrayList<User> userList=new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        product=new Product("title","description",100,0.5,"image");
        user=new User("usrname","pass","name","sname","emal","000234", UserRole.ADMIN);
    }

    @Test
    public void testReadWrite(){
        userList= ReadWriteFile.readFile();
        userList.add(user);
        ReadWriteFile.writeFile(userList);
        assertTrue(userList.equals(ReadWriteFile.readFile()));

    }

    @Test
    public void testPassword() throws Exception {
        Password pass1=new Password("hello");
        Password pass2=new Password("hello", pass1.getSalt());
        Assert.assertTrue(pass1.equals(pass2));
    }

    @Test
    public void testOrder1(){
        Assert.assertTrue(product.order(10));
    }

    @Test
    public void testOrder2(){
        Assert.assertFalse(product.order(101));
    }

    @Test
    public void testAddProduct1(){
        user.addProduct(product);
        Assert.assertTrue(user.getProductList().size()==1);
    }

    @Test
    public void testAddProduct2(){
        user.addProduct(product);
        user.addProduct(product);
        Assert.assertFalse(user.getProductList().size()==2);
    }

    @After
    public void tearDown() throws Exception {
        user=null;
    }

}