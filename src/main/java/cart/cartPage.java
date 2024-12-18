package cart;

import base.pageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartPage extends pageBase {
    By allCategory=By.xpath("//a[@id='nav-hamburger-menu']");

    By firstCategory=By.xpath("//a[@class='hmenu-item hmenu-compressed-btn']");
    By toysItem=By.xpath("//a[@data-ref-tag='nav_em_1_1_1_18']");
    By headerCategory = By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']//li[2]//div");
    By addProductToCart = By.id("a-autoid-1-announce");
    By cartItems=By.xpath("//div[@id='n-title']//h1");



    public cartPage(WebDriver driver) {
        super(driver);
    }
    public cartPage navigateToToysCategory(){
        driver.get("https://egypt.souq.com/eg-en/");
        return this;
    }

    public cartPage clickOnFirstCategory() throws Exception {
        waits.waitForVisibility(firstCategory);
        click(firstCategory);
        return this;
    }
    public cartPage openAllCategory() throws Exception {
        waits.waitForVisibility(allCategory);
        click(allCategory);
        return this;
    }
    public cartPage chooseToys() throws Exception {
        waits.waitForVisibility(toysItem);
        click(toysItem);
        return this;
    }
    public String getCategoryHeader(){
        try {
            return getText(headerCategory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
