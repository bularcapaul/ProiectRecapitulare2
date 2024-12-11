package Actions;

import WebElements.FavoritesPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Favorites {

    private FavoritesPageElements favoritesPageElements;
    private Wait<WebDriver> wait;

    public Favorites(WebDriver driver){
        this.favoritesPageElements = new FavoritesPageElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getGetCombinationPliersProductNameetNoFavoritesText(){
        wait.until(d -> favoritesPageElements.noFavoritesText().isDisplayed());
        return favoritesPageElements.noFavoritesText().getText();
    }

    public boolean isCombinationPliersPresentInFavoriteList(){
        wait.until(d -> favoritesPageElements.combinationPliersProductName().isDisplayed());
        return favoritesPageElements.combinationPliersProductName().isDisplayed();
    }

    public boolean isBoltCuttersProductPresentInFavoriteList(){
        wait.until(d -> favoritesPageElements.boltCuttersProductName().isDisplayed());
        return favoritesPageElements.boltCuttersProductName().isDisplayed();
    }


}
