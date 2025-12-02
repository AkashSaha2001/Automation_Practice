package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

/*

WebDriver Methods :
        1.  get method
2. conditional method
3. browser method
4 . navigational method
5. wait method
get methods - we can access these methods through webdriver instance
----------
get(url) - opens the url on the browser
getTitle() - returns title of the page
getCurrentUrl() - retuns URL of the page
getPageSource()- returns source code of the page
getWindowHandle() - returns ID of the single Browser window (if we are switching tabs to tabs)
getWindowHandles() - retuns ID's of the multiple browser windows

conditional methods - access these commands thorugh WebElement
-----------------------
retuns boolean value( true/false)

isDisplayed() - we can check display status of the element
isEnabled() - we can check enable/disable status of the element/operational element
isSelected() - we can use to check the element is selected or not

browser methods
---------
close() - close single browser
quit() - close multiple browsers
 */
public class Vid27 {
    public static void main(String args[]) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1. get method
        driver.get("https://www.croma.com/");

        //2. maximize the window size
        driver.manage().window().maximize();

        //3. get title method
        //System.out.println(driver.getTitle());

        //4. get current URL
        //System.out.println(driver.getCurrentUrl());

        //5. String windowid=driver.getWindowHandle(); //get the window id in string format
        //System.out.println("Croma1 id = "+windowid);

        //6. multiple window (getWindowHandles())
        driver.get("https://www.croma.com/");
        System.out.println("Croma2 id = "+driver.getWindowHandle());

        ArrayList<String> windowids=new ArrayList<String>(driver.getWindowHandles());
        for(int i=0;i<windowids.size();i++){
            System.out.println(i+" = "+windowids.get(i));
        }
        //--------------------------------------------------------------------
        //1. isDisplayed() (have used '/child::img' to locate img tag)
        boolean logo=driver.findElement(By.xpath("//a[@class=\"logo custom-s-logo croma-desktop-logo\" and @data-testid=\"Logo\"]/child::img")).isDisplayed();

        if(logo){
            System.out.println("logo is displayed");
        }else{
            System.out.println("logo is not displayed");
        }

//2. isSelected()

        driver.findElement(By.xpath("//a[@class=\"user-link\"]")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean popup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"card pd-100 desktop-modal-otp\"]"))).isDisplayed();
        if(popup){
            boolean checkbox=driver.findElement(By.xpath("//input[@type=\"checkbox\" and @id=\"rememberMe\"]")).isSelected();
            if(checkbox){
                System.out.println("check box is selected");
            }else{
                System.out.println("check box is not selected");
            }
        }
        //now uncheck it
        driver.findElement(By.xpath("//span[@class=\"check\"]")).click();

        //now checking if it is showing as selected or not
        if(driver.findElement(By.xpath("//input[@type=\"checkbox\" and @id=\"rememberMe\"]")).isSelected()){
            System.out.print("check box is selected");
        }else{
            System.out.println("check box is not selected");
        }


        //3.isEnabled()

        boolean searchbar= driver.findElement(By.xpath("//input[@id=\"searchV2\" and @name=\"search\"]")).isEnabled();
        if(searchbar){
            System.out.println("search is enabled");
        }else{
            System.out.print("search bar is disabled");
        }
    }
}
