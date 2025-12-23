package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v125.page.model.Screenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Vid43 {
    WebDriver driver;
    @Test(priority=1)
    void siteConnnect(){
        driver=new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test(priority=2)
    void formFill(){
        driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]")).sendKeys("Akash");
        driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]")).sendKeys("Saha");
        driver.findElement(By.xpath("//textarea[contains(@class,'form-control')]")).sendKeys("123,London,70129");
        driver.findElement(By.xpath("//input[@ng-model=\"EmailAdress\"]")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@type=\"tel\"]")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@value=\"Male\" and @type=\"radio\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"checkbox2\" and @value=\"Movies\"]")).click();

        //Drop down
        WebElement DropDown= driver.findElement(By.xpath("//select[@id=\"Skills\"]"));
        Select DropSkill=new Select(DropDown);
        DropSkill.selectByValue("Analytics");

    }

    @Test(priority=3)
    void  FileUpload(){
        String filepath="C:\\Users\\Akash Saha\\OneDrive\\Pictures\\img1.jpg";
        driver.findElement(By.xpath("//input[@id=\"imagesrc\"]")).sendKeys(filepath);
    }

    @Test(priority=4)
    void Screenshot(){
        TakesScreenshot ts=(TakesScreenshot) driver;
        File sourceFile=ts.getScreenshotAs(OutputType.FILE);
        File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\screenshot2.jpg");
        sourceFile.renameTo(targetFile);

    }

}
