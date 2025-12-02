package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Xpath Axes
<form id=fmLogin" method=post" action="......">    = parent
    <input name="txtname" id="txtname" type="text">= current
1. //input[@id="txtname"]/parent::form      -> locate parent from child element (bottom up approch)
2. //form[@id="fmLogin"]/child::input[1]    -> locating child element from parent element (top down approach)
 */
public class Vid26 {
    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.get("");

    }
}