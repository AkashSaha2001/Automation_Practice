package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vid38 {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        driver.manage().window().maximize();
/*
        //javascript - sendkeys function using JS -------------------------
        WebElement element= driver.findElement(By.xpath("//input[@id=\"name\"]"));
        js.executeScript("arguments[0].setAttribute('value','Akash')",element);


 */
        /*
        //To get the page length Y axis after scrolling the webpage -------------------------
        js.executeScript("window.scrollBy(0,300);");
        System.out.println("the page length through Y axis is : "+js.executeScript("return window.pageYOffset;"));

         */
/*
        //scroll till the element is visible and print the Y axis ------------------------------------
       WebElement text= driver.findElement(By.xpath("//a[text()='merrymoonmary']"));
       js.executeScript("arguments[0].scrollIntoView();",text);
        System.out.println("element is visible in Y axis is : "+js.executeScript("return window.pageYOffset;"));
        //element is visible in Y axis is : 3413.60009765625

 */
/*
        // Single File upload ---------------------------------
        driver.findElement(By.xpath("//input[@id=\"singleFileInput\"]")).sendKeys("C:\\Users\\Akash Saha\\OneDrive\\Pictures\\img1.jpg");
        driver.findElement(By.xpath("//button[@type=\"submit\" and text()='Upload Single File']")).click();
        String filename=driver.findElement(By.xpath("//p[@id=\"singleFileStatus\"]")).getText();
        System.out.println(filename);
        if(filename.contains("img1.jpg")){
            System.out.println("file uploaded successfully");
        }else{
            System.out.println("failed");
        }

 */
/*
        //Multiple file upload
        String img1="C:\\Users\\Akash Saha\\OneDrive\\Pictures\\img1.jpg";
        String img2="C:\\Users\\Akash Saha\\OneDrive\\Pictures\\img2.jpg";
        driver.findElement(By.xpath("//input[@id=\"multipleFilesInput\"]")).sendKeys(img1+"\n"+img2);
        driver.findElement(By.xpath("//button[@type=\"submit\" and text()='Upload Multiple Files']")).click();
        String str=driver.findElement(By.xpath("//p[@id=\"multipleFilesStatus\"]")).getText();
        if(str.contains("img1") && str.contains("img2")){
            System.out.println("two files uploaded successfully");
        }else{
            System.out.println("failed");
        }

 */
    }
}
