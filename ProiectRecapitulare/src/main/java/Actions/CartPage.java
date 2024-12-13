package Actions;

import WebElements.CartElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public String getItemPrice(){
        wait.until(d -> cartElements.itemPrice().isDisplayed());
        return cartElements.itemPrice().getText();
    }

    public int getCartTableRows(){
       return cartElements.cartTableRows().size();
    }

    public String getPriceFromSpecificProduct(String productName){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tbody//tr")));
        int tableRows = getCartTableRows();
        String price = "";
        for (int i = 1;i <= tableRows; i++){
            String name = cartElements.productName(i).getText();

        if (name.contains(productName))  {
            price = cartElements.priceColumn(i).getText().replace("$", "");
            break;
        }

        }
        return price;
    }

    public String getTotalPriceFromSpecificProduct(String productName){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tbody//tr")));
        int tableRows = getCartTableRows();
        String totalPrice = "";
        for (int i = 1; i <= tableRows; i++){
            String name = cartElements.productName(i).getText();
            if (name.contains(productName)) {
                totalPrice = cartElements.totalColumn(i).getText().replace("$", "");
                break;
            }
        }
        return totalPrice;
    }
}
