package automation;
/*

Data Provider and Parallel Testing

1. @DataProvider -- data Driven testing
2. using XML file -- parallel testing


 */
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Vid46 {

    WebDriver driver;
/*
    @BeforeClass
    void Setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority=1)
    void login() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        String username=driver.findElement(By.xpath("//section[@id=\"login\"]/ul/li[2]/b[1]")).getText();
        String password=driver.findElement(By.xpath("//section[@id=\"login\"]/ul/li[2]/b[2]")).getText();

        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);

        driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
        if(driver.findElement(By.xpath("//div[@id=\"error\"]")).isDisplayed()){
            Assert.assertTrue(false);
        }else{
            Assert.assertTrue(true);
        }
    }

    @Test(priority=2, dependsOnMethods = {"login"})
    void validation(){
        String loginText=driver.findElement(By.xpath("//h1[@class=\"post-title\"]")).getText();
        if(loginText.equalsIgnoreCase("Logged In Successfully")){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 3,dependsOnMethods = {"login"})
    void logout(){
        driver.findElement(By.xpath("//a[text()='Log out']")).click();
        Assert.assertTrue(true);
    }

    @AfterClass
    void tearDown() {
        driver.close();
        Assert.assertTrue(true);
    }

 */

    // With DataProvider ------------------------------------
/*
@BeforeClass
void Setup() {
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

    @Test(priority=1,dataProvider = "data")
    void login(String username,String password) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
//        String username=driver.findElement(By.xpath("//section[@id=\"login\"]/ul/li[2]/b[1]")).getText();
//        String password=driver.findElement(By.xpath("//section[@id=\"login\"]/ul/li[2]/b[2]")).getText();

        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);

        driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();
        String loginText=driver.findElement(By.xpath("//h1[@class=\"post-title\"]")).getText();
        if(loginText.equalsIgnoreCase("Logged In Successfully")) {
            Assert.assertTrue(true);
            driver.findElement(By.xpath("//a[text()='Log out']")).click();
        }else{
            Assert.assertTrue(false);
        }
    }

    @AfterClass
    void tearDown() {
        driver.close();
        Assert.assertTrue(true);
    }

    @DataProvider(name="data",indices = {0,1,2})
    Object[][] dataProvider(){
        Object data[][]={
                {"student","Password123"},
                {"Student","password123"},
                {"students","password"},
                {"Students","password@123"}
        };
        return data;
    }

 */

    //parallel Testing using XML file -------------------------------

    @BeforeClass
    @Parameters({"browser"})
    void setup(String browser){
        switch (browser){
            case "chrome" : driver=new ChromeDriver(); break;
            case "edge" : driver=new EdgeDriver(); break;
            case "firefox" : driver=new FirefoxDriver(); break;
            default:System.out.println("Driver Selection is invalid"); return;
        }
    }

    @Test(priority = 1)
    void logoVerify(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        if(driver.findElement(By.xpath("//img[@alt=\"Practice Test Automation\"]")).isDisplayed()){
            Assert.assertTrue(true);
        }
    }
    @Test(priority = 2)
    void urlVerify(){
        Assert.assertEquals("https://practicetestautomation.com/practice-test-login/",driver.getCurrentUrl());
    }
    @Test(priority = 3)
    void pageNameVerify(){
        String pageName=driver.getTitle();
        if(pageName.equalsIgnoreCase("Test Login | Practice Test Automation")){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }
    @AfterClass
    void teardown(){
        driver.close();
    }



}
