package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


/*
Web tables------------------
1. Static web Table
2. Dynamic Web table
3. Table with pagination


 */
public class Vid33 {
    public static void main(String args[]){
        WebDriver driver= new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Dimension noOfrow=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr")).getSize();
//        System.out.println(noOfrow);

        //get the name from 5th row 2nd col, Mukesh
        String name =driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]//td[2]")).getText();
        System.out.print(name);

    }
}
