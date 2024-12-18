package tests.register;

import home.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.TestBase;

public class SignUpTest extends TestBase {
    public SoftAssert softAssert;
    public SignUpPage signUpPage;

    @BeforeMethod(alwaysRun = true)
    public void methodSetup() {
        softAssert = new SoftAssert();
        signUpPage = new SignUpPage(driver);
        signUpPage.navigateToWebsiteHome();

    }
    @Test
    public void VerifyEnterValidData() throws Exception {
        signUpPage.accountLoginBtn()
                  .clickOnSignUp()
                  .validName()
                  .validMobileNum()
                  .validPassword()
                  .validConfirmPassword()
                  .register();
        softAssert.assertTrue(signUpPage.captchaPageHeader());
    }

    @Test
    public void verifyEnterInvalidMobileNumber() throws Exception {
        signUpPage.accountLoginBtn()
                .clickOnSignUp()
                .validName()
                .invalidMobileNum()
                .validPassword()
                .validConfirmPassword()
                .register();
        softAssert.assertTrue(signUpPage.mobileNumErrorMessage());
    }
    @Test
    public void verifyEnterInvalidConfirmPassword() throws Exception {
        signUpPage.accountLoginBtn()
                .clickOnSignUp()
                .validName()
                .validMobileNum()
                .validPassword()
                .invalidConfirmPassword()
                .register();
        softAssert.assertTrue(signUpPage.confirmPasswordErrorMessage());
    }

}

