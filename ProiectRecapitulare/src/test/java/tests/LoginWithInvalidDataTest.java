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


        register.clickDropMenuButton();
        register.clickSignUpLink();
        login.loginWithInvalidCredentials();

        Assert.assertEquals(login.getInvalidCredentialsText(), "Invalid email or password");



    }
}
