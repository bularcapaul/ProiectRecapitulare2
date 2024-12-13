package tests;

import Actions.AccountPage;
import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class ChangePhoneNumberTest extends BaseTest {

    Register register = null;
    AccountPage accountPage = null;
    Login login = null;

    @Test
    public void changeNumber(){

        register = new Register(driver);
        accountPage = new AccountPage(driver);
        login = new Login(driver);

        ConfigLoader configLoader = new ConfigLoader("src/main/java/resources/user.properties");
        String newPhone = configLoader.getProperty("newPhone");

        loginTest();

        accountPage.pressProfileLink();
        accountPage.clearCurrentPhone();
        accountPage.setNewPhone(newPhone);
        accountPage.pressUpdateProfileButton();

        Assert.assertEquals(accountPage.getProfileUpdatedSuccessfullyText(), "Your profile is successfully updated!");

    }

    public void loginTest(){

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
