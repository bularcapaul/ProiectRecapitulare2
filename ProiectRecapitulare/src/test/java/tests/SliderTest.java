package tests;

import Actions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class SliderTest extends BaseTest {

    Register register = null;
    Login login = null;
    AccountPage accountPage = null;
    ProductsPage productsPage = null;
    CartPage cartPage = null;

    @Test
    public void sliderTest() throws InterruptedException {

        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        String CordlessDrillPrice = "125.23";

        driver.manage().window().maximize();

        registerUser();
        login();
        accountPage.pressHomeLink();

        //274px(width of slidebar)/199 steps = 1.38 step  -> 1.38 step x 75 steps = offset
        productsPage.moveRightSlider(69, 0);
        productsPage.moveLeftSlider(171, 0);


        productsPage.pressCordlessDrillProduct();
        productsPage.pressAddToCartButton();
        productsPage.pressToCartButton();

        Assert.assertEquals(cartPage.getItemPrice().replace("$", " ").trim(), CordlessDrillPrice );

    }

    public void registerUser(){
        register = new Register(driver);
        login = new Login(driver);


        register.clickSignUpLink();
        register.clickRegisterLink();

        register.registerUser();

        Assert.assertEquals(login.getLoginText(), "Login");
        Assert.assertTrue(login.checkVisibilityOfEmailField());
    }

    public void login(){

        ConfigLoader configLoader = new ConfigLoader("src/main/java/resources/user.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        register = new Register(driver);
        login = new Login(driver);
        accountPage = new AccountPage(driver);

        login.login(email, password);

        Assert.assertEquals(accountPage.getMyAccountText(),"My account");

    }
}
