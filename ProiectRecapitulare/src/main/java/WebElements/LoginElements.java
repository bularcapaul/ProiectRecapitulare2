package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElements {

    private WebDriver driver = null;

    public LoginElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement loginText(){
        return driver.findElement(By.xpath("//h3[text()='Login']"));

    }

    public WebElement emailField(){
        return driver.findElement(By.id("email"));

    }

    public WebElement passwordField(){
        return driver.findElement(By.id("password"));

    }

    public WebElement loginButton(){
         return driver.findElement(By.cssSelector("[data-test='login-submit']"));

    }

    public WebElement invalidCredentialsText(){
        return driver.findElement(By.className("help-block"));
    }

    public WebElement multipleAttemptsText(){
        return driver.findElement(By.className("help-block"));
    }


}
