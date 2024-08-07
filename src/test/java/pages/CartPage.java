package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) { this.driver = driver; }

    public CheckOutPage submitChechout() {
        driver.findElement(By.cssSelector("#checkout")).click();
        return new CheckOutPage(driver);
    }


}
