package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Vid35 {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/?_sm_au_=iVV6q22s63rZTWr4M7BKNK07qH22M");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//Method 1 : SendKey()
//driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("12/08/2025"); //mm/dd/yyy
//Method 2
        String year="2026";
        String month="December";
        String date="21";
        driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();
        while(true){
            String currentYear=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();
            String currenrMonth=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
            if(currentYear.equals(year) && currenrMonth.equals(month)){
                break;
            }
            else{
                driver.findElement(By.xpath("//span[contains(@class,'ui-icon') and text()='Next']")).click();
            }
        }
        driver.findElement(By.xpath("//a[@class=\"ui-state-default\" and @data-date=\""+date+"\" and text()='"+date+"']")).click();
    }
}
