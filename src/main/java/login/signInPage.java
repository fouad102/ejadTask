package login;

import base.pageBase;
import home.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class signInPage extends pageBase {
By phoneNum=By.id("ap_email");
By accountList = By.id("nav-link-accountList");
By continueBtn = By.id("continue");
By passwordInput =By.id("ap_password");
By signInBtn = By.id("signInSubmit");
By successfulLoginMsg= By.id("nav-link-accountList-nav-line-1");
By authErrorPassword=By.id("auth-error-message-box");
By forgotPassword=By.id("auth-fpp-link-bottom");
By verifcatioMSg=By.cssSelector("span.a-size-base-plus");








    public signInPage(WebDriver driver) {
        super(driver);
    }


    public void navigateToWebsiteHome(){
        driver.get("https://egypt.souq.com/eg-en/");
    }
    public signInPage validPhoneNum() throws Exception {
        setText(phoneNum,"01120856729");
        return this;
    }
    public signInPage accountLoginBtn() throws Exception {
        click(accountList);
        return this;
    }
    public signInPage login() throws Exception {
        click(continueBtn);
        return this;
    }
    public signInPage validpassword() throws Exception {
        setText(passwordInput,"Fo2sh@123");
        return this;
    }
    public signInPage invalidPassword() throws Exception {
        setText(passwordInput,"00000000000");
        return this;
    }
    public signInPage signin() throws Exception {
        click(signInBtn);
        return this;
    }
    public String getWelcomeMsg(){
        try {
            waits.waitForVisibility(successfulLoginMsg);
            return getText(successfulLoginMsg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getAuthError(){
        try {
            waits.waitForVisibility(authErrorPassword);
            return findElement(authErrorPassword).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean getVerifecationMsg(){
        try {
            waits.waitForVisibility(verifcatioMSg);
            return findElement(verifcatioMSg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public signInPage clickOnForgotPassword() throws Exception {
        click(forgotPassword);
        return this;
    }




}
