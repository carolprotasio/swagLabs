package gui;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

@DisplayName("Validate Product Checkout Functionality")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CheckoutTest {
    Faker faker = new Faker();
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
    @DisplayName("CT-001 => Add Successfully a product to a cart")
    public void testAddProductToCart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        String productCart = driver.findElement(By.cssSelector(".inventory_item_name")).getText();

        Assertions.assertEquals("Sauce Labs Bike Light", productCart);
    }
    @Test
    @Order(2)
    @DisplayName("CT-002 => Add one product to a cart and successfully validate checkout ")
    public void testAddProductToCartAndCheckout(){
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String zipCode = faker.address().zipCode();

        String msgSucess = new ProductsPage(driver)
                .addOneProductToCart()
                .submitChechout()
                .checkoutInformation(name, lastname, zipCode)
                .submitCheckoutFinish()
                .captureCheckoutMsgSuccess();


        Assertions.assertEquals("Thank you for your order!", msgSucess);
    }
    @Test
    @Order(3)
    @DisplayName("CT-003 => Add TWO product to a cart and successfully validate checkout ")
    public void testAddTwoProductToCartAndCheckout(){
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String zipCode = faker.address().zipCode();

        String msgSucess = new ProductsPage(driver)
                .addTwoProductToCart()
                .submitChechout()
                .checkoutInformation(name, lastname, zipCode)
                .submitCheckoutFinish()
                .captureCheckoutMsgSuccess();


        Assertions.assertEquals("Thank you for your order!", msgSucess);
    }
    @Test
    @Order(4)
    @DisplayName("CT-004 => Add TWO product and validate the total value")
    public void testAddTwoProductValidateTheTotal(){
        String name = faker.name().firstName();
        String lastname = faker.name().lastName();
        String zipCode = faker.address().zipCode();
        String expectValue = "$64.78";

        String actualValue = new ProductsPage(driver)
                .addTwoProductToCart()
                .submitChechout()
                .checkoutInformation(name, lastname, zipCode)
                .captureTotalValue();


        Assertions.assertEquals(expectValue, actualValue);
    }


    @AfterEach
    public void afterEach(){ driver.quit(); }

}
