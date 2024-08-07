package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    private WebDriver driver;

    public CheckOutPage(WebDriver driver) { this.driver = driver; }

    public CheckOutPage checkoutInformation(String name, String lastName, String zipCode){
        driver.findElement(By.cssSelector("#first-name")).sendKeys(name);
        driver.findElement(By.cssSelector("#last-name")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#postal-code")).sendKeys(zipCode);

        driver.findElement(By.cssSelector("#continue")).click();
        return this;
    }

    public String captureTotalValue(){
        String totalText = driver.findElement(By.cssSelector("#checkout_summary_container > div > div.summary_info > div.summary_total_label")).getText();
        String totalValue = totalText.replace("Total: ", "").trim();
        return totalValue;
    }

    public CheckoutCompletePage submitCheckoutFinish() {
        driver.findElement(By.cssSelector("#finish")).click();
        return new CheckoutCompletePage(driver);
    }
}
