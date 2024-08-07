package gui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

@DisplayName("Validate Functionality of the Navigation")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NavTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        new LoginPage(driver)
                .validLogin("standard_user", "secret_sauce");
    }

    @Test
    @Order(1)
    @DisplayName("CT-001 => Validate 'Logout' link on Navigation")
    public void testLogout(){
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-burger-menu-btn")));
        menuButton.click();

        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout_sidebar_link")));
        logoutLink.click();

        String logo = driver.findElement(By.cssSelector(".login_logo")).getText();
        Assertions.assertEquals("Swag Labs", logo);

    }
    @Test
    @Order(2)
    @DisplayName("CT-002 => Validate About link on Navigation")
    public void testAboutLink(){
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-burger-menu-btn")));
        menuButton.click();

        WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#about_sidebar_link")));
        aboutLink.click();

        WebElement imageLogo = driver.findElement(By.cssSelector("div.MuiBox-root.css-lwb5go > span > img"));
        String imageUrl = imageLogo.getAttribute("src");
        Assertions.assertEquals("https://saucelabs.com/images/logo.svg", imageUrl);

    }
    @Test
    @Order(3)
    @DisplayName("CT-003 => Validate 'All Items' link on Navigation")
    public void testAllItemsLink(){
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-burger-menu-btn")));
        menuButton.click();

        WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#inventory_sidebar_link")));


        String Link = aboutLink.getAttribute("href");
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html#", Link);

    }
    @Test
    @Order(4)
    @DisplayName("CT-004 => Validate 'Reset App State' link on Navigation")
    public void testResetAppLink(){
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-burger-menu-btn")));
        menuButton.click();
        WebElement resetApp = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#reset_sidebar_link")));

        String link = resetApp.getAttribute("href");
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html#", link);

    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
