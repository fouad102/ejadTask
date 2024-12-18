package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Waits;

import java.security.SecureRandom;
import java.util.Random;

public class pageBase {
    public WebDriver driver;
    JavascriptExecutor jse;
    protected Waits waits;

    public pageBase(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver);
    }
    public void scrollToElement(By locator) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", findElement(locator));

    }


    public WebElement findElement(By locator) {
        return waits.waitForElementToBePresent(locator);
    }
    public void scrollAndClickByJSE(By locator) throws Exception {
        if (locator != null) {
            scrollToElement(locator);
            clickJSE(locator);
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }
    public void clear(By locator) throws Exception {
        if (locator != null) {
            waits.waitForVisibility(locator);
            findElement(locator).clear();
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");

    }
    public void loseFocusFromField() {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("if (document.activeElement) document.activeElement.blur();");
    }


    public void click(By locator) throws Exception {
        if (locator != null) {
            waits.waitForElementToBeClickable(locator).click();
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }

    public void clickJSE(By locator) throws Exception {
        if (locator != null) {
            jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", waits.waitForElementToBeClickable(locator));
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }
    public void setText(By locator, String text) throws Exception {
        if (locator != null) {
            scrollAndClickByJSE(locator);
            clear(locator);
            findElement(locator).sendKeys(text);
            loseFocusFromField();
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }

    public void setText(By locator, Object text) throws Exception {
        if (locator != null) {
            scrollAndClickByJSE(locator);
            clear(locator);
            if (text != null) {
                findElement(locator).sendKeys(text.toString());
            } else {
                throw new Exception("Provided text is null");
            }
            loseFocusFromField();
        } else {
            throw new Exception("Web element 'locator' is null .. it could not be located");
        }
    }
    public String generateRandomName() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    public String generateRandomMobileNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String[] prefixes = {"010", "011", "012", "015"};
        String randomPrefix = prefixes[random.nextInt(prefixes.length)];
        sb.append(randomPrefix);
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    public String generateRandomInValidMobileNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String[] prefixes = {"013", "014", "016", "017", "018", "019"};
        String randomPrefix = prefixes[random.nextInt(prefixes.length)];
        sb.append(randomPrefix);
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }


    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        // Generate a password by appending random digits
        for (int i = 0; i < length; i++) {
            password.append(random.nextInt(10));  // Appends a random digit (0-9)
        }

        return password.toString();
    }
    public String generateLongID() {
        Random random = new Random();
        long upperBound = 99999999999999L;
        long lowerBound = 10000000000000L;
        long number = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound));
        return String.valueOf(number);
    }
    public String getText(By locator) throws Exception {
        if (locator != null) {
            waits.waitForVisibility(locator);
            waits.waitForTextToChange(locator, "");
            return findElement(locator).getText();
        } else
            throw new Exception("Web element 'locator' is null .. it could not be located");
    }



//    public void click(WebElement element) throws Exception {
//        if (element != null) {
//                waits.waitForElementToBeClickable(element).click();
//        } else
//            throw new Exception("Web element 'locator' is null .. it could not be located");
//    }
}
