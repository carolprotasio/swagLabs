package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private WebDriver driver;
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    public String captureCheckoutMsgSuccess(){
        String msgCheckoutSuccess = driver.findElement(By.cssSelector("#checkout_complete_container > h2")).getText();
        return msgCheckoutSuccess;
    }

}
