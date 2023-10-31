package web.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import web.common.DataGenerator;
import web.pages.HomePage;
import web.pages.LoginPage;
import web.pages.ShoppingCartPage;

public class PurchaseTest extends BaseTest{
    @Parameters({"username", "password"})
    @Test(testName = "Verify purchase can be completed.", priority = 1)
    public void purchaseTest(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(username, password);

        HomePage homePage = new HomePage(driver);
        homePage.verifyLogin("Products");

        String addedItem = homePage.addRandomItemToCart();
        homePage.navigateToShoppingCart()
                .verifySpecificItemIsInCart(addedItem);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.navigateToCheckout()
                .fillCheckoutDetailsAndContinue(DataGenerator.generateFirstName(),
                                                DataGenerator.generateLastName(), DataGenerator.generatePostalCode())
                .clickFinishCheckout().verifyCheckoutCompleted("Thank you for your order!");
    }
}
