package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyPractice {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");

        driver.findElement(By.id("submit")).click();
        boolean logoutText=driver.findElement(By.className("post-title")).isDisplayed();
        if(logoutText){
            System.out.println("login successful");
        }
        else{
            System.out.println("some error occur");
        }
        driver.findElement(By.linkText("Log out")).click();

        boolean logintext=driver.findElement(By.id("login")).isDisplayed();
        if(logintext){
            System.out.println("Logout successful");
        }
        else{
            System.out.println("some error occur");
        }
    }
}
