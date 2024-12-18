package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Objects;

public class Waits {
    WebDriver driver;
    public Waits(WebDriver driver) {
        this.driver = driver;
    }
    private static final Duration waitTime = Duration.ofSeconds(30);
    private static final Duration pollingTime = Duration.ofMillis(500);
    public WebElement waitForElementToBeClickable(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    public WebElement waitForElementToBePresent(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public WebElement waitForVisibility(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForVisibility(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(waitTime)
                .pollingEvery(pollingTime)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(org.openqa.selenium.StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

//    public void waitForElementToBeInViewport(By locator) {
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(waitTime)
//                .pollingEvery(pollingTime)
//                .ignoring(WebDriverException.class)
//                .ignoring(org.openqa.selenium.StaleElementReferenceException.class)
//                .ignoring(Exception.class);
//        wait.until(customExpectedConditions.elementIsWithinViewport(locator));
//    }
public String waitForTextToChange(By locator, String textShouldChange) throws Exception {
    int retries = 0;
    while (retries < 20) {
        if (Objects.equals(driver.findElement(locator).getText(), textShouldChange)) {
            Thread.sleep(1500);
            retries++;
        } else {
            return driver.findElement(locator).getText();
        }
    }
    throw new Exception("Max retries exceeded. The text is still " + textShouldChange);
}
}
