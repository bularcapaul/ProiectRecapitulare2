package tests;

import Actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class AddProductToFavoriteList extends BaseTest {

    Register register = null;
    Login login = null;
    AccountPage accountPage = null;
    Favorites favorites = null;
    ProductsPage productsPage = null;

    @Test
    public void addProductsToFavorites() throws InterruptedException {

        favorites = new Favorites(driver);
        productsPage = new ProductsPage(driver);

        registerUser();
        login();

        accountPage.pressFavoritesLink();
        Assert.assertEquals(favorites.getGetCombinationPliersProductNameetNoFavoritesText(), "There are no favorites yet. " +
                "In order to add favorites, please go to the product listing and mark some products as your favorite.");


        register.clickDropMenuButton();
        accountPage.pressHomeLink();
        productsPage.pressOnCombinationPliersProduct();
        productsPage.pressAddToFavoritesButton();
        Assert.assertEquals(productsPage.getProductAddedToFavoritesText(), "Product added to your favorites list.");
        Thread.sleep(2000);
        productsPage.pressOnBoltCuttersProduct();
        Thread.sleep(2000);
        productsPage.pressAddToFavoritesButton();
        productsPage.pressDropMenuButton();


        accountPage.pressToMyProfileLink();
        accountPage.pressToMyFavoritesLink();

        Assert.assertTrue(favorites.isCombinationPliersPresentInFavoriteList());
        Assert.assertTrue(favorites.isBoltCuttersProductPresentInFavoriteList());



//        Assert.assertEquals(productsPage.getProductAddedToFavoritesText(), "Product added to your favorites list.");

    }


    public void registerUser(){
        register = new Register(driver);
        login = new Login(driver);

        register.clickDropMenuButton();
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

        register.clickDropMenuButton();
        register.clickSignUpLink();

        login.login(email, password);

        Assert.assertEquals(accountPage.getMyAccountText(),"My account");

    }
}
