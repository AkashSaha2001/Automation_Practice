package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

/*

TestNG Listners and Extent Report
 1.Create Test Case
 2.Create Listener Class
 3.Create XML file and include both test case and Listener class

 2 ways to implement listener class
 Method 1:
 class myListner implements ITestListener
 {
 }
 Method 2:
 class mtListner extends TestListnerAdapter
 {
 }




Test Case is written as -----------
Passed
Failed
Skipped

1.We can execute my using XML file.
    <listeners>
        <listener class-name="automation.MyListner"/>
    </listeners>
    <test name="Smoke Tests1">
        <classes>
            <class name="automation.Vid47"/>
        </classes>
     </test>


2. have to add one line before the class ------
@Listeners(automation.MyListner.class)
 */

@Listeners(automation.MyListner.class)
public class Vid47 {

    WebDriver driver;
    @BeforeTest
    void BeforeTest(){
        driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority=1)
    void testLogo(){
        String title=driver.findElement(By.xpath("//h1[@class=\"title\"]")).getText();
        Assert.assertEquals(title, "Automation Testing Practice");
    }

    @Test(priority = 2)
    void testURL(){
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url,"https://test.blogspot.com/");
    }

    @Test(priority = 3,dependsOnMethods = {"testURL"})
    void pageTitle(){
        String title=driver.getTitle();
        Assert.assertEquals(title,"Automation Testing Practice");
    }

    @AfterTest
    void tearDown(){
        driver.close();
    }

}
