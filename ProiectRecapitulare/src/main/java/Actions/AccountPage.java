package Actions;

import WebElements.AccountPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private AccountPageElements accountPageElements;
    private Wait<WebDriver> wait;

    public AccountPage(WebDriver driver){
        this.accountPageElements = new AccountPageElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public String getMyAccountText(){
        wait.until(d -> accountPageElements.myAccountText().isDisplayed());
        return accountPageElements.myAccountText().getText();
    }

    public void pressDropMenuButton(){
        wait.until(d -> accountPageElements.dropButtonMenu().isDisplayed());
        accountPageElements.dropButtonMenu().click();
    }

    public void pressProfileLink(){
        wait.until(d -> accountPageElements.profileLink().isDisplayed());
        accountPageElements.profileLink().click();
    }

    public String getTextFromEmailField(){
        wait.until(ExpectedConditions.attributeToBeNotEmpty(accountPageElements.emailField(), "value"));
        return accountPageElements.emailField().getAttribute("value");
    }

    public void clearCurrentPhone(){
        wait.until(ExpectedConditions.attributeToBeNotEmpty(accountPageElements.phoneField(), "value"));
        accountPageElements.phoneField().clear();
    }

    public void setNewPhone(String phone){
        accountPageElements.phoneField().sendKeys(phone);
    }

    public void pressUpdateProfileButton(){
        accountPageElements.updateProfileButton().click();
    }

    public String getProfileUpdatedSuccessfullyText(){
        wait.until(d -> accountPageElements.profileUpdateSuccessfullyText().isDisplayed());
        return accountPageElements.profileUpdateSuccessfullyText().getText();
    }

    public void pressFavoritesLink(){
        accountPageElements.favoritesLink().click();
    }

    public void pressHomeLink(){
        wait.until(d -> accountPageElements.homeLink().isDisplayed());
        accountPageElements.homeLink().click();
    }

    public void pressToMyProfileLink(){
        wait.until(d -> accountPageElements.toMyProfileLink().isDisplayed());
        accountPageElements.toMyProfileLink().click();
    }

    public void pressToMyFavoritesLink(){
        wait.until(d -> accountPageElements.toMyFavoritesLink().isDisplayed());
        accountPageElements.toMyFavoritesLink().click();
    }



}
