package Actions;

import WebElements.CartElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private CartElements cartElements;
    private Wait<WebDriver> wait;

    public CartPage(WebDriver driver){
        this.cartElements = new CartElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public String getItemName(){
        wait.until(d -> cartElements.itemName().isDisplayed());
        return cartElements.itemName().getText();
    }
}
