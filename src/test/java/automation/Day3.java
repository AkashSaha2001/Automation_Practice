package automation;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
Css selectors----------------------------------
tag id              tag#id
tag class           tag.classname
tag attributre      tag[attribute="value"]
tag class attribute tag.classname[attribute="value"]
 */
public class Day3 {
        public static void main(String args[]) throws InterruptedException {
            WebDriver driver= new ChromeDriver();

            driver.get("https://www.croma.com/");
            driver.manage().window().maximize(); //maximixe the browser window

            // 1. tag#id  -------------------------
            //driver.findElement(By.cssSelector("input#searchV2")).sendKeys("Laptop"+ Keys.ENTER);

            // 2. tag.classname ----------------------------
            /*
            boolean logo=driver.findElement(By.cssSelector("a.logo")).isDisplayed();
            if(logo){
                System.out.print("logo displayed");
            }else{
                System.out.println("logo is not displayed");
            }

             */

            // 3. tag[atttribute="value"] -----------------------
            //driver.findElement(By.cssSelector("input[placeholder=\"Enter Email ID\"]")).sendKeys("abc@gmail.com");

            // 4. tag.classname[attribute="value"] -----------------------------------

            /*
            it was unable to find beacuse Selenium checked the page, the footer was not yet loaded or you have not scrolled down to footer.
            to resolve this problem we have to add scrolling feature and aslo wait time to load
             */

            /*
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Scroll step-by-step until footer loaded
            for (int i = 0; i < 10; i++) {
                js.executeScript("window.scrollBy(0, 600)"); // Scroll down 600px
                Thread.sleep(2000); // Wait 2 seconds for content to load

                try {
                    WebElement footerSection = driver.findElement(
                            By.cssSelector("ul.link-list[data-testid=\"section-list\"]")
                    );
                    if (footerSection.isDisplayed()) {
                        System.out.println("Footer is visible!");
                        break;
                    }
                } catch (NoSuchElementException ignored) {
                    // Continue scrolling if not found yet
                }
            }

             */



            driver.close();
        }
}
