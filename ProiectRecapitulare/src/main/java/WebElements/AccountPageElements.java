package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPageElements {

    private WebDriver driver;

    public AccountPageElements(WebDriver driver){
        this.driver =  driver;
    }

    public WebElement myAccountText(){
        return driver.findElement(By.cssSelector("[data-test='page-title']"));
    }

    public WebElement dropButtonMenu(){
        return driver.findElement(By.cssSelector("[class='navbar-toggler collapsed']"));
    }

    public WebElement profileLink(){
        return driver.findElement(By.cssSelector("[data-test='nav-profile']"));
    }

    public WebElement emailField(){
        return driver.findElement(By.id("email"));
    }

    public WebElement phoneField(){
        return driver.findElement(By.id("phone"));
    }

    public WebElement updateProfileButton(){
        return driver.findElement(By.cssSelector("[data-test='update-profile-submit']"));
    }

    public WebElement profileUpdateSuccessfullyText(){
        return driver.findElement(By.cssSelector("[role='alert']"));
    }

    public WebElement favoritesLink(){
        return driver.findElement(By.cssSelector("[data-test='nav-favorites']"));
    }

    public WebElement homeLink(){
        return driver.findElement(By.cssSelector("[data-test='nav-home']"));
    }

    public WebElement toMyProfileLink(){
        return driver.findElement(By.cssSelector("[data-test='nav-menu']"));
    }

    public WebElement toMyFavoritesLink(){
        return driver.findElement(By.cssSelector("[data-test='nav-my-favorites']"));
    }

}
