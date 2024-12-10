package Actions;

import WebElements.LoginElements;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class Login {

    private LoginElements loginElements;
    private Wait<WebDriver> wait;

public Login(WebDriver driver){
    this.loginElements = new LoginElements(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

public String getLoginText(){
    wait.until(d -> loginElements.loginText().isDisplayed());
    return loginElements.loginText().getText();
}

public Boolean checkVisibilityOfEmailField(){
    return loginElements.emailField().isDisplayed();
}

public void setEmail(String email){
    wait.until(d -> loginElements.emailField().isDisplayed());
    loginElements.emailField().sendKeys(email);
}

public void setPassword(String password){
    loginElements.passwordField().sendKeys(password);
}

public void pressLoginButton(){
    loginElements.loginButton().click();
    }

    public void pressLoginButtonMultipleTimes() throws InterruptedException {
    for(int i = 0; i < 10; i++) {
        loginElements.loginButton().click();
        Thread.sleep(1000);
    }
    }

    public void login(String email, String password){
        setEmail(email);
        setPassword(password);
        pressLoginButton();
    }

    public void loginWithMultipleAttempts(String invalidEmail, String invalidPassword) throws InterruptedException {
        setEmail(invalidEmail);
        setPassword(invalidPassword);
        pressLoginButtonMultipleTimes();
    }

    public String getInvalidCredentialsText()
    {
        wait.until(d -> loginElements.invalidCredentialsText().isDisplayed());
        return loginElements.invalidCredentialsText().getText();
    }

    public String getMultipleAttemptsText()
    {
        wait.until(d -> loginElements.multipleAttemptsText().isDisplayed());
        return loginElements.multipleAttemptsText().getText();
    }



}
