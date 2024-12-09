package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class RegisterTest extends BaseTest {

    private Register register = null;
    private Login login = null;

    @Test
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


}

