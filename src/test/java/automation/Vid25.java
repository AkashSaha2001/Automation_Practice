package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Vid25 {
    public static void main(String args[]) {
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\2781482\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.croma.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Done----------------clicking on ham logo
        WebElement hamburger_logo = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div/div[5]/span[1]"));
        if (hamburger_logo.isDisplayed()) {
            System.out.println("logo is present TEST CASE PASSED 1");
            hamburger_logo.click();

        } else {
            System.out.println("logo is not present");
        }
//Done------------------click on Televisions & Accessories
        driver.findElement(By.xpath("//*[@id=\"category-Televisions & Accessories\"]")).click();

// click on All Televisions & Accessories -- not applicable cuz we are not hivering we are clicking in the previous
//driver.findElement(By.xpath("//*[@id=\"navigation-2\"]/li[1]/a/h5")).click();

//Done------------------ search with product id and click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='317872']")));
        if (product.isDisplayed()) {
            product.click();
            System.out.println("Product id is present TEST CASE PASSED 2");
        } else {
            System.out.println("Product id is not present");
        }
//Done------------------ Switch to the new tab
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Switch to second taba
        System.out.println("Switched to new tab: " + driver.getTitle());


//Done------------------ scroll the webpage to get the add to cart button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");


//Done------------------click on add to cart
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@type='button' and @class='btn btn-secondary pdp-add-to-cart' and normalize-space(text())='Add to Cart']")
        ));
        if (addToCartButton.isDisplayed()) {
            addToCartButton.click();
            System.out.println("Add to cart done, TEST CASE PASSED 3");
        }
        //Done------------------ if the pop come then proceed to cart
        WebElement proceedToCartpopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class=\"mini-cart-product-container\"]")));
        if (proceedToCartpopup.isDisplayed()) {
            driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-default proceed-tocart' and normalize-space(text())='Proceed to Cart']")).click();
            System.out.println("Proceed to cart done, TEST CASE PASSED 4");
        }


//Done------------------remove from cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary cart-del' and normalize-space(text())='Remove']"))).click();

        //Done------------------if the pop up comes
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"modal-wrap modal-sm\"]")));
        if (popup.isDisplayed()) {
            driver.findElement(By.xpath("//button[@data-testid=\"proceedBtn\" and @class=\"btn btn-default\" and normalize-space(text())='Yes']")).click();
            System.out.println("Remove From Cart, TEST CASE PASSED 5");
        } else {
            System.out.print("NO pop up came");
        }

//------------------ removed from cart successfully
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class=\"title empty-title\" and normalize-space(text()=\"Your Cart is Empty\")]")));
        if (confirmation.isDisplayed()) {
            System.out.println("Cart is empty successfully, TEST CASE PASSED 6 ");
        } else {
            System.out.println("Cart is not empty successfully");
        }
    }
}