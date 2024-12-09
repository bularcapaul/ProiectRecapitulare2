package tests;

import Actions.AccountPage;
import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class LoginTest extends BaseTest {


    private Register register = null;
    private Login login = null;
    private AccountPage accountPage = null;

    @Test
    public void loginTest(){

        ConfigLoader configLoader = new ConfigLoader("src/main/java/resources/user.properties");
        String email = configLoader.getProperty("email");

        register = new Register(driver);
        login = new Login(driver);
        accountPage = new AccountPage(driver);

        register.clickDropMenuButton();
        register.clickSignUpLink();

        login.login();

        Assert.assertEquals(accountPage.getMyAccountText(),"My account");
        Assert.assertEquals(accountPage.getTextFromEmailField(), email);

    }
}
