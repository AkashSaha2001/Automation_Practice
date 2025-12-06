package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

/*
Drop Down-------------
1. Select DropDown
2. Bootstrap DropDown
3. Hidden DropDown


Select DropDown-----------
selectByVisibleText()
selectByValue()
selectByIndex()

 */
public class Vid32 {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
       // driver.get("https://testautomationpractice.blogspot.com/");
        //driver.get("https://www.jquery-az.com/");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


// DropDown from Select Tag------------------------------------------------------------------------------------
        //WebElement dropdown= driver.findElement(By.xpath("//select[@id=\"country\"]"));
        //Select dropdownCountry= new Select(dropdown);
/*
        //select element------------
        dropdownCountry.selectByVisibleText("India");
        dropdownCountry.selectByValue("india");
        dropdownCountry.selectByIndex(9);//index starts from 0
 */
        /*
        JavascriptExecutor js=(JavascriptExecutor) driver;
        for(int i=0;i<20;i++){
            js.executeScript("window.scrollBy(0,200)");
        }
         */

        // List all the dropdown elements
/*
       List<WebElement> dropdownlist= dropdownCountry.getOptions();
        System.out.println(dropdownlist.size());

        for(int i=1;i<=dropdownlist.size();i++){
            System.out.println("DropDown Elements are "+i+" = "+dropdownlist.get(i-1).getText());
        }
 */
// DropDown from Xpath Tag------------------------------------------------------------------------------------
        /*
        driver.findElement(By.xpath("//div[@class=\"nav-item dropdown\"][1]")).click();

        driver.findElement(By.xpath("//a[@class=\"dropdown-item \" and normalize-space(text())='Python']")).click();


         */
// Hidden DropDown------------------------------------------------------------------------------------

        driver.findElement(By.xpath("//input[@name=\"username\" and @placeholder=\"Username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\" and @placeholder=\"Password\"]")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        driver.findElement(By.xpath("//span[contains(@class,'oxd-text') and text()='PIM']")).click();
        driver.findElement(By.xpath("(//div[contains(@class,'oxd-select-text-input') and @tabindex=\"0\" and normalize-space(text())='-- Select --'])[2]")).click();

        // this drop down is hidden so we have to go to the right side of inspect where styles, layout will be there click on Event Listeners
        //click on the blur and delete it.

        driver.findElement(By.xpath("//span[ text()='Chief Technical Officer']")).click();



    }
}
