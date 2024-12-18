package home;
import base.pageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends pageBase {
    String generatorPassword=generatePassword(9);

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    By accountList = By.id("nav-link-accountList");
    By signUpBtn=By.id("createAccountSubmit");
    By customerNameInput=By.id("ap_customer_name");
    By MobileInput = By.id("ap_phone_number");
    By passwordInput=By.id("ap_password");
    By confirmPasswordInput=By.id("ap_password_check");
    By continueBtn = By.id("continue");
    By capatchaHeader=By.id("aacb-captcha-header");
    By mobileNumError=By.xpath("//div[@id='auth-phoneNumber-invalid-phone-alert']//div//div");
    By confirmPasswordError=By.xpath("//div[@id='auth-password-mismatch-alert']//div//div");





    public void navigateToWebsiteHome(){
        driver.get("https://egypt.souq.com/eg-en/");
    }


    public SignUpPage accountLoginBtn() throws Exception {
        click(accountList);
        return this;
    }


    public SignUpPage clickOnSignUp() throws Exception {
        click(signUpBtn);
        return this;
    }
    public SignUpPage validName() throws Exception {
        setText(customerNameInput,generateRandomName());
        return this;
    }
    public SignUpPage validMobileNum() throws Exception {
        setText(MobileInput,generateRandomMobileNumber());
        return this;
    }
    public SignUpPage invalidMobileNum() throws Exception {
        setText(MobileInput,generateRandomName());
        return this;
    }
    public SignUpPage validPassword() throws Exception {
        setText(passwordInput,generatorPassword);
        return this;
    }
    public SignUpPage validConfirmPassword() throws Exception {
        setText(confirmPasswordInput,generatorPassword);
        return this;
    }
    public SignUpPage invalidConfirmPassword() throws Exception {
        setText(confirmPasswordInput,generatePassword(12));
        return this;
    }
    public SignUpPage register() throws Exception {
        click(continueBtn);
        return this;
    }
    public boolean captchaPageHeader()  {
        try{
            waits.waitForVisibility(capatchaHeader);
            findElement(capatchaHeader).isDisplayed();
            return true;

        }catch (Exception e){
            return false;
        }


    }
    public boolean mobileNumErrorMessage()  {
        try{
            waits.waitForVisibility(mobileNumError);
            findElement(mobileNumError).isDisplayed();
            return true;

        }catch (Exception e){
            return false;
        }


    }
    public boolean confirmPasswordErrorMessage()  {
        try{
            waits.waitForVisibility(confirmPasswordError);
            findElement(confirmPasswordError).isDisplayed();
            return true;

        }catch (Exception e){
            return false;
        }


    }


}





