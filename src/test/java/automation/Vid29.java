
/*
Navigation Commands-----------------
navigate().to()
navigate().back()
navigate().forward()
navigate().refresh()

getWindowHandel()
getWindowHandels()


 */

package automation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Vid29 {
    public static void main(String args[]){
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\2781482\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

//        driver.get("https://www.croma.com/");
//        driver.manage().window().maximize();


        //navigate.to()
        driver.navigate().to("https://www.croma.com/");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        for(int i=0;i<10;i++){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,400);");
        }

boolean footer= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class=\"footer-list\"]"))).isDisplayed();
 if(footer){
     System.out.println("Footer is displayed");
 }else{
     System.out.println("Footer is not displayed");
 }


 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"link\" and normalize-space(text())='FAQs']"))).click();
 System.out.println(driver.getCurrentUrl());

 //navigate.back()
 driver.navigate().back();
 System.out.println(driver.getCurrentUrl());

 //navigate().forward()
 driver.navigate().forward();
 System.out.println(driver.getCurrentUrl());

 //navigate().refresh()
 driver.navigate().refresh();
 System.out.println(driver.getCurrentUrl());

driver.get("https://www.croma.com/");
        Set<String> window=driver.getWindowHandles();

        //approach1 (if we have 2 or 3 windows)
        List<String> windowList=new ArrayList<String>(window);
        String parentwindow=windowList.get(0);
        String chilcwindow=windowList.get(1);

        driver.switchTo().window(chilcwindow);
        //or
        driver.switchTo().window(windowList.get(1));

        //approach 2 (if we have multiple windows)
        Set<String> windows=driver.getWindowHandles();
        for(String str:windows){
            String title= driver.switchTo().window(str).getTitle();
            System.out.println(title);

            if(title.equals("fsdfdfd")){
                driver.close();
                break;
            }
        }
    }
}


