package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsElements {

    private WebDriver driver;

    public ProductsElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement combinationPliers(){
        return driver.findElement(By.xpath("//h5[contains(@class, 'card-title') and contains(text(), 'Combination Pliers')]"));
    }

    public WebElement addProductToFavoritesButton(){
        return driver.findElement(By.id("btn-add-to-favorites"));
    }

    public WebElement boltCuttersProduct(){
        return driver.findElement(By.xpath("//h5[contains(@class, 'card-title') and contains(text(), 'Bolt Cutters')]"));
    }


    public WebElement productAddedToFavoritesText(){
        return driver.findElement(By.cssSelector("div[role='alert']"));
    }

    public WebElement dropMenuButton(){
        return driver.findElement(By.cssSelector("[class='navbar-toggler-icon']"));
    }

    public WebElement searchInputField(){
        return driver.findElement(By.cssSelector("[data-test='search-query']"));
    }

    public WebElement searchButton(){
        return driver.findElement(By.cssSelector("[data-test='search-submit']"));
    }

    public WebElement sortMenu(){
        return driver.findElement(By.cssSelector("[data-test='sort']"));
    }

    public WebElement theCheapestHammer(){
        return driver.findElement(By.xpath("//h5[contains(@class, 'card-title') and contains(text(), 'Thor Hammer')]"));
    }

    public WebElement addToCartButton(){
        return driver.findElement(By.id("btn-add-to-cart"));
    }

    public WebElement toCartButton(){
        return driver.findElement(By.cssSelector("#navbarSupportedContent > ul > li:nth-child(5) > a > fa-icon > svg"));
    }

    public WebElement leftSideSlider(){
        return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/ngx-slider/span[5]"));
    }

    public WebElement rightSideSlider(){
        return driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/ngx-slider/span[6]"));
    }

    public WebElement cordlessDrill(){
        return driver.findElement(By.xpath("//h5[contains(@class, 'card-title') and contains(text(), 'Cordless Drill 20V')]"));
    }

    public WebElement productAddedToCartText(){
        return driver.findElement(By.cssSelector("[aria-label='Product added to shopping cart.']"));
    }

    public WebElement measuresCategory(){
        return driver.findElement(By.cssSelector("[data-test='category-01JF053K8ZYE727WDTJ2PC7XW8']"));
    }

    public WebElement tapeMeasure5m(){
        return driver.findElement(By.xpath("//h5[contains(@class, 'card-title') and contains(text(), 'Tape Measure 5m')]"));
    }

    public WebElement plusItemToCart(){
        return driver.findElement(By.cssSelector("[data-icon='plus']"));
    }







}
