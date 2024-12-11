package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterElements {

    private WebDriver driver;

    public RegisterElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement dropMenuButton(){
        return driver.findElement(By.className("navbar-toggler-icon"));
    }

    public WebElement signUpLink(){
        return driver.findElement(By.xpath("//a[text()='Sign in']"));
    }

    public WebElement registerLink(){
        return driver.findElement(By.xpath("//a[text()='Register your account']"));
    }

    public WebElement firstName(){
        return driver.findElement(By.id("first_name"));
    }

    public WebElement lastName(){
        return driver.findElement(By.id("last_name"));
    }

    public WebElement dateOfBirth(){
        return driver.findElement(By.id("dob"));
    }

    public WebElement address(){
        return driver.findElement(By.id("address"));
    }

    public WebElement postcode(){
        return driver.findElement(By.id("postcode"));
    }

    public WebElement city(){
        return driver.findElement(By.id("city"));
    }

    public WebElement state(){
        return driver.findElement(By.id("state"));
    }

    public WebElement country(){
        return driver.findElement(By.id("country"));
    }

    public WebElement phone(){
        return driver.findElement(By.id("phone"));
    }

    public WebElement email(){
        return driver.findElement(By.id("email"));
    }

    public WebElement password(){
        return driver.findElement(By.id("password"));
    }

    public WebElement registerButton(){
        return driver.findElement(By.cssSelector("[data-test='register-submit']"));
    }


}
