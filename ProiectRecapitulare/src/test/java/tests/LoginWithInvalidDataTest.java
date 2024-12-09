package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class LoginWithInvalidDataTest extends BaseTest {

    private Login login = null;
    private Register register = null;

    @Test
    public void loginWithInvalidData(){
        login = new Login(driver);
        register = new Register(driver);
        ConfigLoader configLoader = new ConfigLoader("src/main/java/resources/user.properties");

        String invalidEmail = configLoader.getProperty("invalidEmail");
        String invalidPassword = configLoader.getProperty("invalidPassword");


        register.clickDropMenuButton();
        register.clickSignUpLink();
        login.login(invalidEmail, invalidPassword);

        Assert.assertEquals(login.getInvalidCredentialsText(), "Invalid email or password");



    }
}
