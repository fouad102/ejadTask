package tests.login;

import home.SignUpPage;
import login.signInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.TestBase;

public class signInTest extends TestBase {
    String oldWelcomeMsg , loginedWelcomeMsg;
        public SoftAssert softAssert;
        public signInPage signinpage;

        @BeforeMethod(alwaysRun = true)
        public void methodSetup() {
            softAssert = new SoftAssert();
            signinpage = new signInPage(driver);
            signinpage.navigateToWebsiteHome();

        }

        @Test(priority = 3)
        public void VerifyLoginWithValidData() throws Exception {
            oldWelcomeMsg=signinpage.getWelcomeMsg();
            signinpage.accountLoginBtn()
                    .validPhoneNum()
                    .login()
                    .validpassword()
                    .signin();
            loginedWelcomeMsg=signinpage.getWelcomeMsg();
            softAssert.assertNotEquals(oldWelcomeMsg,loginedWelcomeMsg);
            softAssert.assertAll();
        }

    @Test(priority = 1)
    public void VerifyLoginWithInValidData() throws Exception {

        signinpage.accountLoginBtn()
                .validPhoneNum()
                .login()
                .invalidPassword()
                .signin();
        softAssert.assertTrue(signinpage.getAuthError());
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public void VerifyClickOnForgotPassword() throws Exception {
        signinpage.accountLoginBtn()
                .validPhoneNum()
                .login()
                .clickOnForgotPassword()
                .validPhoneNum()
                .login();
        softAssert.assertAll();
    }

}

