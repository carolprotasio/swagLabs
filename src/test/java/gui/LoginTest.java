package gui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validate Login Functionality ")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    private WebDriver driver;
    //private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        //this.driver = new FirefoxDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    @DisplayName("CT-001 => Login with success")
    public void testLoginWithSuccess() {
        String actualHeader = new LoginPage(driver)
                .validLogin("standard_user", "secret_sauce")
                .captureHeader();
        assertEquals("Products", actualHeader);

    }
    @Test
    @Order(2)
    @DisplayName("CT-002 => Login with invalid User Name")
    public void testLoginInvalidUserName() {
        String errorMsg = new LoginPage(driver)
                .invalidLogin("invalidUserName", "secret_sauce")
                .loginMsgError();
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMsg);
    }
    @Test
    @Order(3)
    @DisplayName("CT-003 => Login with invalid Password")
    public void testLoginInvalidPassword() {
        String errorMsg = new LoginPage(driver)
                .invalidLogin("standard_user", "invalidPassword")
                .loginMsgError();
        assertEquals("Epic sadface: Username and password do not match any user in this service", errorMsg);
    }
    @Test
    @Order(4)
    @DisplayName("CT-004 => Login with ALL empty field")
    public void testLoginWithEmptyField() {
        String errorMsg = new LoginPage(driver)
                .invalidLogin("", "")
                .loginMsgError();
        assertEquals("Epic sadface: Username is required", errorMsg);
    }
    @Test
    @Order(5)
    @DisplayName("CT-005 => Login with empty Password field")
    public void testLoginWithEmptyPasswordield() {
        String errorMsg = new LoginPage(driver)
                .invalidLogin("standard_user", "")
                .loginMsgError();
        assertEquals("Epic sadface: Password is required", errorMsg);
    }
    @Test
    @Order(6)
    @DisplayName("CT-006 => Login with User Name empty field")
    public void testLoginWithUserNameEmptyField() {
        String errorMsg = new LoginPage(driver)
                .invalidLogin("", "secret_sauce")
                .loginMsgError();
        assertEquals("Epic sadface: Username is required", errorMsg);
    }
    @Test
    @Order(7)
    @DisplayName("CT-007 => Verify Login Button Clickable with Empty Fields")
    public void testLoginButtonClickableWithEmptyFields() {
        WebElement loginButton = driver.findElement(By.id("login-button"));

        assertTrue(loginButton.isEnabled(), "The login button should be enabled when fields are empty.");

        loginButton.click();

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3"));
        String actualErrorMsg = errorMsg.getText();

        assertEquals("Epic sadface: Username is required", actualErrorMsg, "The error message for empty username field is not displayed correctly.");
    }



    @AfterEach
    public void afterEach() {
        driver.quit();
    }

}
