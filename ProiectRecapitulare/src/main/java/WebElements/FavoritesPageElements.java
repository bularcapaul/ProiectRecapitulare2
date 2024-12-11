package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavoritesPageElements{

    private WebDriver driver;

    public FavoritesPageElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement noFavoritesText(){
        return driver.findElement(By.xpath("//div[contains(text(), 'There are no favorites yet')]"));
    }

    public WebElement combinationPliersProductName(){
        return driver.findElement(By.xpath("//h5[contains(@class, 'card-title') and contains(text(), 'Combination Pliers')]"));
    }

    public WebElement boltCuttersProductName(){
        return driver.findElement(By.xpath("//h5[contains(@class, 'card-title') and contains(text(), 'Bolt Cutters')]"));
    }


}
