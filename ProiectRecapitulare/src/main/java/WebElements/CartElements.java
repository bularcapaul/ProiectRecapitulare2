package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartElements {

    private WebDriver driver;

    public CartElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement itemName(){
        return driver.findElement(By.cssSelector("[data-test='product-title']"));
    }

    public WebElement itemPrice(){
        return driver.findElement(By.cssSelector("[data-test='product-price']"));
    }
}
