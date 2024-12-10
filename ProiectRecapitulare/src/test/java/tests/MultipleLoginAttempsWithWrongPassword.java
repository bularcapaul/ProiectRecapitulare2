package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class MultipleLoginAttempsWithWrongPassword extends BaseTest {

    Register register = null;
    Login login = null;

    @Test
    public void multipleLoginAttemptsWithWrongPassword() throws InterruptedException {

        ConfigLoader configLoader = new ConfigLoader("src/main/java/resources/user.properties");

        String email = configLoader.getProperty("email");
        String invalidPassword = configLoader.getProperty("invalidPassword");

        register = new Register(driver);
        login = new Login(driver);

        register.clickDropMenuButton();
        register.clickSignUpLink();

        login.loginWithMultipleAttempts(email, invalidPassword);

        Assert.assertEquals(login.getMultipleAttemptsText(), "Account locked, too many failed attempts. Please contact the administrator.");



    }
}
