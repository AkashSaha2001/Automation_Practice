package automation;
/*
*
To solve the synchronization problem we use wait method
NoSuchElementException - Element is not present on the page. Synchronization.
ElementNotFoundException - Locator is in-correct

Thread.sleep(time in ms) //not recommended

type of wait---
1. implicit wait---
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
NOTE : after, WebDriver driver=new ChromeDriver(); this line we have to write this line.
       this 10sec will be applicable for all operation,
       not every operation will not execute after 10sec, if any operation will take 2sec, then it will take 2sec, 10sec is the max wait timw

2. explicit wait-----
works based on time and condition
WebDriverWait wait=new WebDriverWait(driver,5);
//visible
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")))
//clickable
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
alertIsPresent()
elementSelectionStateToBe()
elementToBeClickable()
elementToBeSelected()
frameToBeAvaliableAndSwitchToIt()
presenceOfAllElementsLocatedBy()
presenceOfElementLocated()
textToBePresentInElement()
textToBePresentInElementLocated()
textToBePresentInElementValue()
titleIs()
titleContains()
visibilityOf()
visibilityOfAllElements()
visibilityOfAllElementsLocatedBy()
visibilityOfElementLocated()

3. Fluent wait---------------
Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
NOTE : Best for dynamic webelement ,
polling,means every that second it will check if the element is visible or not,
ignore - if after polling time, if the element is not visible then dont throw exception


 */

/*
public class Vid28 {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.croma.com/");
        driver.manage().window().maximize();


        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

    }
}

*/

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Vid28 {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.croma.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));

    }
}


