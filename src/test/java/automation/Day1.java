package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.*;

public class Day1 {
    public static void main(String[] args){

//        WebDriver driver=new ChromeDriver();
        WebDriver driver=new EdgeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        String title= driver.getTitle();
        if(title.equals("Test Login | Practice Test Automation")){
            System.out.println("test Passed");
        }
        else{
            System.out.println("Test Failed");
        }

            driver.close();
    }
}
