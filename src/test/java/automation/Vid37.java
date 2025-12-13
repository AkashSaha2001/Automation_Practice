package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Vid37 {
    public static void main(String args[]) {
        WebDriver driver = new ChromeDriver();
        //driver.get("https://testautomationpractice.blogspot.com/");
        driver.get("https://www.croma.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions act=new Actions(driver);
        /* Slider ----------------------------
        WebElement leftslider=driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[1]"));
        System.out.println("Left slider location"+leftslider.getLocation()); //734, 2024 (x,y)

        act.dragAndDropBy(leftslider,50,0).build().perform();
        System.out.println("After sliding left slider location"+leftslider.getLocation()); //784, 2024


         */

/*
        //Keyboard short cut ----------------------------
        driver.findElement(By.xpath("//input[@id=\"input1\"]")).sendKeys("Akash");
        //ctrl+A
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
        //ctrl+C
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();
        //TAB
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
        //Ctrl+v
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();


 */
/*
//right lick on a link one it with a new tab ----------------------------
        WebElement profile=driver.findElement(By.xpath("//a[@class=\"user-link\"]"));


        // works but does't open new tab
        act.contextClick(profile).build().perform();
        act.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).build().perform();
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();


        act.keyDown(Keys.CONTROL).click(profile).keyUp(Keys.CONTROL).perform();
        //window switch
        ArrayList<String> windowSwitch=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowSwitch.get(1));
        driver.findElement(By.xpath("//input[contains(@class,'input-login')]")).sendKeys("6059000025");
        */

/*
 // create new blank window and driver.get() ----------------------------

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://testautomationpractice.blogspot.com/");
        
 */
    }

}
