package automation;

public class Vid30 {
    public static void main(String args[]){
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\2781482\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/?_sm_au_=iVVkD60rSnq4S755M7BKNK07qH22M");
        WebDriverWait wait=new WebDriverWait(driver, 10);
        boolean section=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"form-group\"][4]"))).isDisplayed();
        if(section){
            System.out.println("section is displayed");
        }
        WebElement sundayCheckBox=driver.findElement(By.xpath("//input[@id=\"sunday\"]"));
        boolean checkbox_Sunday=sundayCheckBox.isSelected();
        if(checkbox_Sunday){
            System.out.println("check box is not selected");
        }else{
            sundayCheckBox.click();
        }
    }
}

