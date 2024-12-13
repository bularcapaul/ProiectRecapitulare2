package tests;

import Actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class Add2ProductsInCartAndCheckThePrices extends BaseTest {

    Register register = null;
    Login login = null;
    AccountPage accountPage = null;
    ProductsPage productsPage = null;
    CartPage cartPage = null;

    @Test
    public void Add2ProductsInCartAndCheckThePrices() throws InterruptedException {

        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        ConfigLoader configLoader = new ConfigLoader("src/main/java/resources/products.properties");
        String combinationPliers = configLoader.getProperty("product1Name");
        String expectedCombinationPliersPrice = configLoader.getProperty("product1Price");
        String boltCutters = configLoader.getProperty("product2Name");
        String expectedBoltCuttersPrice = configLoader.getProperty("product2Price");

        driver.manage().window().maximize();

        registerUser();
        login();
        accountPage.pressHomeLink();

        productsPage.pressOnCombinationPliersProduct();
        productsPage.pressAddToCartButton();
        Assert.assertEquals(productsPage.getProductAddedToCartText(), "Product added to shopping cart.");
        Thread.sleep(2000);

        productsPage.pressOnBoltCuttersProduct();
        Thread.sleep(2000);
        productsPage.pressAddToCartButton();
        Assert.assertEquals(productsPage.getProductAddedToCartText(), "Product added to shopping cart.");

        productsPage.pressToCartButton();

        String actualCombinationPliersPrice = cartPage.getPriceFromSpecificProduct(combinationPliers);
        String actualBoltCuttersPrice = cartPage.getPriceFromSpecificProduct(boltCutters);

        Assert.assertEquals(actualCombinationPliersPrice, expectedCombinationPliersPrice);
        Assert.assertEquals(actualBoltCuttersPrice, expectedBoltCuttersPrice);

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
