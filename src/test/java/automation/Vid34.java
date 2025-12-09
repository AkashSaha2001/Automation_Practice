package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.*;

public class Vid34 {
    //static WebDriver driver;
    public static void main(String args[]){
        //driver=new ChromeDriver();
        /*
        driver.get("https://demo3x.opencartreports.com/admin/index.php?route=common/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@name=\"username\" and @placeholder=\"Username\"]")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@name=\"password\" and @placeholder=\"Password\"]")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        handleAlertIfPresent();

        driver.findElement(By.xpath("//a[@data-toggle=\"collapse\" and text()=' Design']")).click();
        handleAlertIfPresent();

        driver.findElement(By.xpath("//ul[@id=\"collapse3\"]/li[5]")).click();
        handleAlertIfPresent();

        String path=driver.findElement(By.xpath("//div[@class=\"col-sm-6 text-right\"]")).getText();
        System.out.println(path);
        handleAlertIfPresent();

        //
        //Showing 1 to 20 of 67 (4 Pages)
        int start= path.indexOf("(")+1;
        int end=path.indexOf(" Pages");
        String index=path.substring(start,end);
        int number=Integer.parseInt(index);
        System.out.println(number); //4
        handleAlertIfPresent();
/*
        for(int i=1;i<=number;i++){
            //no of rows in the pages
            List<WebElement> rows=driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table-hover')]//tbody//tr"));
            System.out.println("Page "+i+" have "+rows.size()+" rows");

            //get the next page number
            int num=Integer.parseInt(driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//a[text()="+(i+1)+"]")).getText());
            //check if it is greater than current page number
            if(num>i){
                //if yes then click on next page number
                driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//a[text()="+num+"]")).click();

                boolean rowIsPresent= driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-hover')]//tr//td[@class=\"text-left\" and text()=\"category_id=40\"]")).isDisplayed();
                if(!rowIsPresent){
                    continue;
                }else{
                    System.out.println("category_id=40 is displayed");
                }
            }
        }

 */
        /*
        for (int i = 1; i <= number; i++) {

            System.out.println("Checking Page " + i);
            List<WebElement> rows=driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table-hover')]//tbody//tr"));
            System.out.println("Page "+i+" have "+rows.size()+" rows");

            List<WebElement> element = driver.findElements(
                    By.xpath("//td[contains(text(),'category_id=40')]")
            );
            if (!element.isEmpty()) {
                System.out.println("FOUND category_id=40 on Page " + i);
                break;
            }
            // Move to next page only if not last page
            if (i < number) {
                driver.findElement(By.xpath("//ul[@class='pagination']//a[text()='" + (i + 1) + "']")).click();
                handleAlertIfPresent();
                driver.navigate().refresh();  // ensure table reloads
            }
        }
    }
    public static void handleAlertIfPresent() {
        try {
            driver.switchTo().alert().accept();
            System.out.println("Alert accepted");
        } catch (NoAlertPresentException e) {
            // No alert found - safe to ignore
        }

         */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/?_sm_au_=iVV6q22s63rZTWr4M7BKNK07qH22M");

        List<WebElement> pagecount=driver.findElements(By.xpath("//ul[@class=\"pagination\"]//li"));
        System.out.println("Total number of page is "+pagecount.size()); //4

        for (int i=1;i<=pagecount.size();i++){
            driver.findElement(By.xpath("//ul[@class=\"pagination\"]//li//a[text()='"+i+"']")).click();

            List<WebElement> rowCount=driver.findElements(By.xpath("//table[@id=\"productTable\"]//tr"));
            System.out.println("Page "+i+" have "+rowCount.size()+" rows");

            try {
                WebElement str = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tr//td[text()='Streaming Device']"));
                if (str.isDisplayed()) {
                    System.out.println("Name: " + str.getText() + " is displayed on page no. " + i);
                }
            }
            catch (Exception e){
                //System.out.println(e);
            }

            for(int j=1;j<rowCount.size();j++){
                driver.findElement(By.xpath("(//table[@id=\"productTable\"]//tr//td//input[@type=\"checkbox\"])["+j+"]")).click();
            }
        }
        }
}
