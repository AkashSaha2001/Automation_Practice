package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;
import java.util.List;

public class Day2 {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");

        /* name + sendKey---------------------
         driver.findElement(By.name("q")).sendKeys("Laptop");
         */

        /*find element by id---------------------------
         boolean isPresent= driver.findElement(By.id("topcartlink")).isDisplayed()
         */

        /* classname to see logo is displayed or not-----------------------------
        boolean logo=driver.findElement(By.className("header-logo")).isDisplayed();
        if(logo){
            System.out.print("displayed");
        }
        else{
            System.out.print("not displayed");
        }
         */

        /* linkTest to check hyperlink is working or not --------------------------------
        driver.findElement(By.linkText("Computers")).click();
         */

        /* find all same classname counts --------------------------
        List<WebElement> nooffooter=driver.findElements(By.className("footer-menu__item"));
        System.out.println("no of footer link : "+nooffooter.size());
         */

        /* TagName to check how many hyperlink
        List<WebElement> nooftags=driver.findElements(By.tagName("a"));
        System.out.print("no of hyperlink = "+nooftags);
         */


        driver.quit();


    }
}
