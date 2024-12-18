package tests.cartTests;

import cart.cartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.TestBase;

public class addToCart extends TestBase {
    public SoftAssert softAssert;
    public cartPage cartpage;

    @BeforeMethod(alwaysRun = true)
    public void methodSetup() {
        softAssert = new SoftAssert();
        cartpage = new cartPage(driver);


    }
    @Test
    public void VerifyAddItemToCartSuccessfully() throws Exception {
        cartpage.navigateToToysCategory()
                .openAllCategory()
                .clickOnFirstCategory()
                .chooseToys();
        softAssert.assertNotEquals(cartpage.getCategoryHeader(),"Toys");
        softAssert.assertAll();
    }
}
