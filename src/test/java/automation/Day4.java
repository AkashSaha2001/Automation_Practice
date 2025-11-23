package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*

XPath--------------
1. Absolute XPath (Full Xpath) --> copy -> full Xpath -> /html/body/div[6]/header/div[2]/div[2]/form/input
  It navigate from the root of the HTML Page,

2. Relative XPath (Partial Xpath) --> copy -> copy Xpath -> //*[@id="small-searchterms"]

croma search bar-------------------

1. tag.classame[attribute="value"]  --> input.MuiAutocomplete-input[id="search"]
2. relative xpath --> //*[@id="searchV2"]  (in place if * we have also put the tag name -> //input[@id="searchV2"])
3. absolute xpath --> /html/body/main/div/div[1]/div[1]/div/div[6]/div[1]/div[1]/div/div/div/input



 */



public class Day4 {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.croma.com/");
        driver.manage().window().maximize(); //maximize the web page

        /* Relative Xpath (Single attribute)
        WebElement searchbar =driver.findElement(By.xpath("//input[@id=\"searchV2\"]"));
        if(searchbar.isDisplayed()){
            searchbar.sendKeys("Laptop"+ Keys.ENTER);
        }else{
            System.out.print("Search bar is not displayed");
        }
         */

        //Relative Xpath (Multiple attribute)
        /*
        WebElement searchbar =driver.findElement(By.xpath("//input[@id=\"searchV2\"][@placeholder=\"What are you looking for ?\"]"));
        if(searchbar.isDisplayed()){
            searchbar.sendKeys("Laptop"+ Keys.ENTER);
        }else{
            System.out.print("Search bar is not displayed");
        }
         */


        //XPath with AND OR attribute
        /*
        AND (Both condition should be correct)-> //input[@id="searchV2" and @placeholder="What are you looking for ?"
        OR (if only one condition is correct it will execute)-> //input[@id="searchV2" or @placeholder="What are you looking for ?"]

        WebElement searchbar =driver.findElement(By.xpath("//input[@id=\"searchV2\" and @placeholder=\"What are you looking for ?\"]"));
        if(searchbar.isDisplayed()){
            searchbar.sendKeys("Laptop"+ Keys.ENTER);
        }else{
            System.out.print("Search bar is not displayed");
        }

         */

        //Xpath with innterText - text()
        /*
        WebElement text=driver.findElement(By.xpath("//h2[text()=\"Exciting Bank Offers For You\"]"));
        if(text.isDisplayed()){
            System.out.print("text is displayed");
        }else{
            System.out.print("text is not displayed");
        }

         */

        //chainer Xpath
        boolean logo= driver.findElement(By.xpath("//div[@class=\"container\"]/div/a/img")).isDisplayed();
        if(logo){
            System.out.print("logo is displayed");
        }else{
            System.out.print("not displayed");
        }



//        driver.close();
    }
}
