package gui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.ProductsPage;

@DisplayName("Validate Products Functionality")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        new LoginPage(driver)
                .validLogin("standard_user", "secret_sauce");
    }

    @Test
    @Order(1)
    @DisplayName("CT-001 => Add ONE product in the cart with success")
    public void testAddOneProductInTheCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        String removeButton = driver.findElement(By.cssSelector("#remove-sauce-labs-bike-light")).getText();
        Assertions.assertEquals("Remove", removeButton);


    }
    @Test
    @Order(2)
    @DisplayName("CT-002 => Add ALL 6 product in the cart with success")
    public void testAddAllSixProductInTheCart() {
        String cartQtd = new ProductsPage(driver)
                .addAllProductsToTheCart()
                .captureCartNumber();

        Assertions.assertEquals("6", cartQtd);
    }
    @Test
    @Order(3)
    @DisplayName("CT-003 => Filter product from Z to A")
    public void testFilterZToA() {
        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);

        select.selectByValue("za");
    }
    @Test
    @Order(4)
    @DisplayName("CT-004 => Filter product fro: Price (low to high)")
    public void testFilterPriceLToH() {
        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);

        select.selectByValue("lohi");
    }
    @Test
    @Order(5)
    @DisplayName("CT-005 => Filter product fro: Price (high to low)")
    public void testFilterPriceHToL() {
        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);

        select.selectByValue("hilo");
    }
    @Test
    @Order(6)
    @DisplayName("CT-006 => Add a product and confirm it name in the cart")
    public void testAddProduct() {
        driver.findElement(By.cssSelector("#item_4_title_link > div")).click( );
        String productName = driver.findElement(By.cssSelector("div.inventory_details_name.large_size")).getText();

        Assertions.assertEquals("Sauce Labs Backpack", productName);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
