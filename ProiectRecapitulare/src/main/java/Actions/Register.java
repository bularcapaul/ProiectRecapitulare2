package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.io.ObjectInputFilter;
import java.time.Duration;

public class Register {

    private RegisterElements registerElements;
    private Wait<WebDriver> wait;

    public Register(WebDriver driver) {
        this.registerElements = new RegisterElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void clickDropMenuButton(){
        wait.until(d -> registerElements.dropMenuButton().isDisplayed());
        registerElements.dropMenuButton().click();
    }

    public void clickSignUpLink(){
        wait.until(d -> registerElements.signUpLink().isDisplayed());
        registerElements.signUpLink().click();
    }

    public void clickRegisterLink(){
        wait.until(d -> registerElements.registerLink().isDisplayed());
        registerElements.registerLink().click();
    }

    public void setFirstname(String firstname){
        registerElements.firstName().sendKeys(firstname);
    }

    public void setLastname(String lastname){
        registerElements.lastName().sendKeys(lastname);
    }

    public void setDateOfBirth(String dob){
        registerElements.dateOfBirth().sendKeys(dob);
    }

    public void setAddress(String address){
        registerElements.address().sendKeys(address);
    }

    public void setPostcode(String postcode){
        registerElements.postcode().sendKeys(postcode);
    }

    public void setCity(String city){
        registerElements.city().sendKeys(city);
    }

    public void setState(String state){
        registerElements.state().sendKeys(state);
    }

    public void setCountry(String country){
        Select countryList = new Select(registerElements.country());
        wait.until(ExpectedConditions.textToBePresentInElement(registerElements.country(), country));
        countryList.selectByVisibleText(country);
    }

    public void setPhone(String phone){
        registerElements.phone().sendKeys(phone);
    }

    public void setEmail(String email){
        registerElements.email().sendKeys(email);
    }

    public void setPassword(String password){
        registerElements.password().sendKeys(password);
    }

    public void pressRegisterButton(){
        registerElements.registerButton().click();
    }



    public void registerUser(){
        ConfigLoader configLoader = new ConfigLoader("src/main/java/resources/user.properties");
        String firstname = configLoader.getProperty("firstName");
        String lastname = configLoader.getProperty("lastName");
        String dob = configLoader.getProperty("dob");
        String address = configLoader.getProperty("address");
        String postcode = configLoader.getProperty("postcode");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String country = configLoader.getProperty("country");
        String phone = configLoader.getProperty("phone");
        String email = configLoader.getProperty("email");
        String weakPass = configLoader.getProperty("password");

        setFirstname(firstname);
        setLastname(lastname);
        setDateOfBirth(dob);
        setAddress(address);
        setPostcode(postcode);
        setCity(city);
        setState(state);
        setCountry(country);
        setPhone(phone);
        setEmail(email);
        setPassword(weakPass);

        pressRegisterButton();
    }


}
