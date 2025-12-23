package automation;

/*

@Test

@BeforeMethod
@AfterMethod

@BeforeClass
@AfterClass

@BeforeTest
@AfterTest

@BeforeSuite
@AfterSuite

Suite > Test > Classes > Method
 */

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Vid44 {
    WebDriver driver;
    @Test(priority = 1)
    void mainTest1(){
        System.out.println("This is main Test 1");
    }

    @Test(priority = 2)
    void mainTest2(){
        System.out.println("This is main Test 2");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("This is before Method");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("This is after Method");
    }

    @BeforeClass
    void BeforeClass(){
        System.out.println("This is before Class");
    }

    @AfterClass
    void afterClass(){
        System.out.println("This is after Class");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("This is before Test");
    }

    @AfterTest
    void afterTest(){
        System.out.println("This is after Test");
    }

    @BeforeSuite
    void BeforeSuite(){
        System.out.println("This is before Suite");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("This is after Suite");
    }
}
