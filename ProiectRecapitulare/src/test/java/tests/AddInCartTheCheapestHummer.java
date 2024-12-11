package tests;

import Actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class AddInCartTheCheapestHummer extends BaseTest {

    Register register = null;
    Login login = null;
    AccountPage accountPage = null;
    ProductsPage productsPage = null;
    CartPage cartPage = null;

    @Test
    public void addTheCheapestHummerInCart(){

        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        ConfigLoader configLoader = new ConfigLoader("src/main/java/resources/search.properties");
        String searchedProduct = configLoader.getProperty("searchedProduct");
        String fromLowToHigh = configLoader.getProperty("sortType");

        driver.manage().window().maximize();

        registerUser();
        login();
        accountPage.pressHomeLink();
        productsPage.searchForAProduct(searchedProduct);
        productsPage.sortProducts(fromLowToHigh);
        productsPage.clickTheCheapestHammer();
        productsPage.pressAddToCartButton();
        productsPage.pressToCartButton();
        Assert.assertEquals(cartPage.getItemName(), "Thor Hammer ");
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
