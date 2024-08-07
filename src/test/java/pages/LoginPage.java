package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){ this.driver = driver; }

    public ProductsPage validLogin(String user, String password){
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        return new ProductsPage(driver);
    }

    public LoginPage invalidLogin(String user, String password){
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        return  this;
    }

    public String loginMsgError() {
        WebElement erroMsg = driver.findElement(By.cssSelector("div.error-message-container.error > h3 "));
        return erroMsg.getText();
    }
}
