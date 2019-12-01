package tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationCalisma {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }


    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }


    @BeforeMethod
    public void setup() {
        System.out.println("Before method");
        System.out.println("I am running with every method");
    }


    @AfterMethod
    public void teardown(){
        System.out.println("After method");
        System.out.println("I am with every code");
    }



    @Test
    public void test1(){
        System.out.println("Test 1!");
        Assert.assertTrue(5==5);
    }



    @Test
    public void test2(){
       System.out.println("Test 2!");
 }


    @Test
    public void test3(){
        System.out.println("Test 3!");
    }

}




