package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver){ this.driver = driver; }

    public String captureHeader(){
        WebElement header = driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span"));
        return header.getText();
    }

    public ProductsPage addAllProductsToTheCart(){
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket")).click();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.cssSelector("#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)")).click();
        return this;
    }

    public String captureCartNumber(){
        String cartNumb = driver.findElement(By.cssSelector("#shopping_cart_container > a > span")).getText();
        return cartNumb;
    }
    public CartPage addOneProductToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        return new CartPage(driver);
    }
    public CartPage addTwoProductToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement((By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket"))).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        //String productCart = driver.findElement(By.cssSelector(".inventory_item_name")).getText();

        return new CartPage(driver);
    }




}
