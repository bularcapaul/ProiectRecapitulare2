package Actions;

import WebElements.ProductsElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private ProductsElements productsElements;
    private Wait<WebDriver> wait;
    private Actions action;

    public ProductsPage(WebDriver driver){
        this.productsElements = new ProductsElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        action = new Actions(driver);
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

    public void enterTheProductToSearch(String searchedProduct){
        productsElements.searchInputField().sendKeys(searchedProduct);
    }

    public void pressSearchButton(){
        productsElements.searchButton().click();
    }

    public void searchForAProduct(String searchedProduct){
        enterTheProductToSearch(searchedProduct);
        pressSearchButton();
    }

    public void sortProducts(String sortType){
        Select sortList = new Select(productsElements.sortMenu());
        wait.until(ExpectedConditions.textToBePresentInElement(productsElements.sortMenu(), sortType));
        sortList.selectByVisibleText(sortType);
    }

    public void clickTheCheapestHammer(){
        wait.until(d -> productsElements.theCheapestHammer().isDisplayed());
        productsElements.theCheapestHammer().click();
    }

    public void pressAddToCartButton(){
        wait.until(d -> productsElements.addToCartButton().isDisplayed());
        productsElements.addToCartButton().click();
    }

    public void pressToCartButton(){
        wait.until(d -> productsElements.toCartButton().isDisplayed());
        productsElements.toCartButton().click();
    }

    public void pressCordlessDrillProduct(){
        wait.until(d -> productsElements.cordlessDrill().isDisplayed());
        productsElements.cordlessDrill().click();
    }

    public void moveLeftSlider(int XOffset, int YOffset){
        action.dragAndDropBy(productsElements.leftSideSlider(), XOffset, YOffset).perform();
    }

    public void moveRightSlider(int XOffset, int YOffset){
        action.dragAndDropBy(productsElements.rightSideSlider(), XOffset, YOffset).perform();
    }

    public String getProductAddedToCartText(){
        wait.until(d -> productsElements.productAddedToCartText().isDisplayed());
        return productsElements.productAddedToCartText().getText();
    }

    public void checkMeasuresCategory(){
        wait.until(d -> productsElements.measuresCategory().isDisplayed());
        productsElements.measuresCategory().click();
    }

    public void pressTapeMeasure5m(){
        wait.until(d -> productsElements.tapeMeasure5m().isDisplayed());
        productsElements.tapeMeasure5m().click();
    }

    public void pressPlusItemToCart(int numberOfClicks){
        wait.until(d -> productsElements.plusItemToCart().isDisplayed());
        for (int i = 0; i < numberOfClicks; i++ ){
            productsElements.plusItemToCart().click();
        }
    }




}
