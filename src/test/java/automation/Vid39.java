package automation;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class Vid39 {
    public static void main(String args[]){
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://testautomationpractice.blogspot.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
/*

        // Take ScreenShot ---------------------------------
        //C:\Users\Akash Saha\IdeaProjects\SeleniumWebDriver\screenshots
        TakesScreenshot ts=(TakesScreenshot) driver;
        File sourceFile=ts.getScreenshotAs(OutputType.FILE); // system stored which we dont know where it stored, so we need to capture this file
        File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\screenshot1.jpg"); // make the file access in the directory
        sourceFile.renameTo(targetFile); //copy source file to target file

 */
 /*
        // HeadLess testing ------------------
         (UI will not be shown, all things will work in backend, only the result will be displayed)

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println(driver.getTitle());
        if(driver.getTitle().equals("Automation Testing Practice")){
            System.out.println("test passes");
        }else{
            System.out.println("test failed");
        }

  */
/*
        // to make the test in incognito mode -----------------------------
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println(driver.getTitle());
        if(driver.getTitle().equals("Automation Testing Practice")){
            System.out.println("test passes");
        }else{
            System.out.println("test failed");
        }


 */



    }
}
