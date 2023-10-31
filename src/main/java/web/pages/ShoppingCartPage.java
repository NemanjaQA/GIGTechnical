package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    By shoppingCartItemNameBy = By.className("inventory_item_name");
    By checkoutButtonBy = By.id("checkout");

    public void verifySpecificItemIsInCart(String expectedText){
        Assert.assertEquals(readTextFromElement(shoppingCartItemNameBy), expectedText);
    }

    public CheckoutPage navigateToCheckout(){
        clickElement(checkoutButtonBy);
        return new CheckoutPage(driver);
    }
}