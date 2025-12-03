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
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement dropdown= driver.findElement(By.xpath("//select[@id=\"country\"]"));
        Select dropdownCountry= new Select(dropdown);
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
       List<WebElement> dropdownlist= dropdownCountry.getOptions();
        System.out.println(dropdownlist.size());

        for(int i=1;i<=dropdownlist.size();i++){
            System.out.println("DropDown Elements are "+i+" = "+dropdownlist.get(i-1).getText());
        }
    }
}
