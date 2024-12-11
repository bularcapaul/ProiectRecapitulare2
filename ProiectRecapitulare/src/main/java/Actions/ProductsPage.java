package Actions;

import WebElements.ProductsElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private ProductsElements productsElements;
    private Wait<WebDriver> wait;

    public ProductsPage(WebDriver driver){
        this.productsElements = new ProductsElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void pressOnCombinationPliersProduct(){
        wait.until(d -> productsElements.combinationPliers().isDisplayed());
        productsElements.combinationPliers().click();
    }

    public void pressAddToFavoritesButton(){
        wait.until(d -> productsElements.addProductToFavoritesButton().isDisplayed());
        productsElements.addProductToFavoritesButton().click();
    }

    public void pressOnBoltCuttersProduct(){
        wait.until(d -> productsElements.boltCuttersProduct().isDisplayed());
        productsElements.boltCuttersProduct().click();
    }

    public String getProductAddedToFavoritesText(){
        wait.until(d -> productsElements.productAddedToFavoritesText().isDisplayed());
        return productsElements.productAddedToFavoritesText().getText();

    }

    public void pressDropMenuButton(){
        wait.until(ExpectedConditions.invisibilityOf(productsElements.productAddedToFavoritesText()));
        productsElements.dropMenuButton().click();
    }

}
