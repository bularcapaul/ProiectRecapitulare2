package tests;

import Actions.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class CheckTotalPriceTest extends BaseTest {

    Register register = null;
    Login login = null;
    AccountPage accountPage = null;
    ProductsPage productsPage = null;
    CartPage cartPage = null;

    @Test
    public void checkTotalPriceTest(){

        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        ConfigLoader configLoader = new ConfigLoader("src/main/java/resources/products.properties");
        //Quantity = 4 x Price = 12.91
        String tapeMeasure5M = configLoader.getProperty("product3Name");
        String expectedTotalPrice = "51.64";


        driver.manage().window().maximize();

        registerUser();
        login();
        accountPage.pressHomeLink();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        productsPage.checkMeasuresCategory();
        productsPage.pressTapeMeasure5m();
        productsPage.pressPlusItemToCart(3);
        productsPage.pressAddToCartButton();
        productsPage.pressToCartButton();

        String actualTotalPrice = cartPage.getTotalPriceFromSpecificProduct(tapeMeasure5M);

        Assert.assertEquals(actualTotalPrice,expectedTotalPrice);






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

        register.clickSignUpLink();
        login.login(email, password);

        Assert.assertEquals(accountPage.getMyAccountText(),"My account");

    }

}
