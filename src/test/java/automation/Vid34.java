package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.*;

public class Vid34 {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo3x.opencartreports.com/admin/index.php?route=common/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@name=\"username\" and @placeholder=\"Username\"]")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@name=\"password\" and @placeholder=\"Password\"]")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        driver.findElement(By.xpath("//a[@data-toggle=\"collapse\" and text()=' Design']")).click();
        try {
            driver.switchTo().alert().accept();
            System.out.println("Alert Accepted");
        } catch (NoAlertPresentException e) {
            System.out.println("No alert found");
        }
        driver.findElement(By.xpath("//ul[@id=\"collapse3\"]/li[5]")).click();

        String path=driver.findElement(By.xpath("//div[@class=\"col-sm-6 text-right\"]")).getText();
        System.out.println(path);

        //
        //Showing 1 to 20 of 67 (4 Pages)
        int start= path.indexOf("(")+1;
        int end=path.indexOf(" Pages");
        String index=path.substring(start,end);
        int number=Integer.parseInt(index);
        System.out.print(number);





    }
}
