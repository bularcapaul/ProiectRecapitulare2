package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public List<WebElement> cartTableRows(){
        return driver.findElements(By.xpath("//table//tbody//tr"));
    }

    public WebElement productName(int row){
        return driver.findElement(By.xpath("//table/tbody/tr[" + row + "]/td[1]"));

    }

    public WebElement priceColumn(int row){
        return driver.findElement(By.xpath("//table/tbody/tr[" + row + "]/td[3]"));

    }

    public WebElement totalColumn(int row){
        return driver.findElement(By.xpath("//table/tbody/tr[" + row + "]/td[4]"));
    }
}
