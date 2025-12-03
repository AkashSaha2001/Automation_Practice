package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Vid30 {
    public static void main(String args[]){
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\2781482\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/?_sm_au_=iVVkD60rSnq4S755M7BKNK07qH22M");

        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));


        //1.Selecting one checkbox
        boolean section=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"form-group\"][4]"))).isDisplayed();
        if(section){
            System.out.println("section is displayed");
        }
        WebElement sundayCheckBox=driver.findElement(By.xpath("//input[@id=\"sunday\"]"));
        boolean checkbox_Sunday=sundayCheckBox.isSelected();
        if(checkbox_Sunday){
            System.out.println("check box is not selected");
        }else{
            sundayCheckBox.click();
        }
        //2. find how many check box are there with days
        List<WebElement> checkboxList=driver.findElements(By.xpath("//input[@class=\"form-check-input\" and @type=\"checkbox\"]"));
        System.out.println("Total number of checkbox is "+checkboxList.size());

        //3. select all the check box
        for(int i=1;i<=checkboxList.size();i++){
            WebElement checkbox=driver.findElement(By.xpath("(//input[@class=\"form-check-input\" and @type=\"checkbox\"])["+i+"]"));
            if(! checkbox.isSelected()){
                checkbox.click();
            }else{
                System.out.println("check box is selected");
            }
        }
    }
}

