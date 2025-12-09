package automation;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/*
Mouse Action
1.Mouse hover
2. Right click
3. Left click
4. Double click
5. Drag and Drop
 */
public class Vid36 {
    public static void main(String args[]) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
/*
// Hover Function -----------------moveToElement()

        driver.get("https://www.croma.com/");
        driver.manage().window().maximize();
        Actions act=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//span[@class=\"menu-icon-hamb\"]")).click();
        WebElement television =driver.findElement(By.xpath("//a[@class=\"tablinks link\"]//h4[text()='Televisions & Accessories']"));
        WebElement LedTV= driver.findElement(By.xpath("//li[@class=\"item parent\"]//a[@class=\"tablinks link\"]//h5[text()='LED TVs']"));
        act.moveToElement(television).moveToElement(LedTV).build().perform();
        WebElement ultraHDTV=driver.findElement(By.xpath("//h6[contains(@class,'text') and normalize-space(text())='4K Ultra HD TVs']"));
        ultraHDTV.click();
 */

 /*
 // Right Click Function-----------------contextClick()
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
       WebElement button= driver.findElement(By.xpath("//span[contains(@class,'context-menu-one')]"));

       Actions action=new Actions(driver);
       action.contextClick(button).perform();

       driver.findElement(By.xpath("//span[text()='Copy']")).click();

       Thread.sleep(1000);
       driver.switchTo().alert().accept();

  */
  /*
  // Double click-----------------------doubleClick()
        Actions action=new Actions(driver);
       action.doubleClick(button).perform();

   */

   // Drag and Drop----------------------
        driver.get("https://demo.automationtesting.in/Static.html");
        driver.manage().window().maximize();
        Actions act=new Actions(driver);

        WebElement source=driver.findElement(By.xpath("//img[@id=\"mongo\"]"));
        WebElement target=driver.findElement(By.xpath("//div[@id=\"droparea\"]"));

        act.dragAndDrop(source,target).build().perform();



    }
}
