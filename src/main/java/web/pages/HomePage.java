package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By productsTitleBy = By.className("title");
    By shoppingCartButtonBy = By.className("shopping_cart_link");
    By allItemsElementsBy = By.className("inventory_item");
    By inventoryItemNameBy = By.className("inventory_item_name");

    public void verifyLogin(String expectedText){
        Assert.assertEquals(readTextFromElement(productsTitleBy), expectedText);
    }

    public ShoppingCartPage navigateToShoppingCart(){
        clickElement(shoppingCartButtonBy);
        return new ShoppingCartPage(driver);
    }

    public String addRandomItemToCart(){
        WebElement itemInList = selectRandomWebElement(allItemsElementsBy);
        String itemName = itemInList.findElement(inventoryItemNameBy).getText();
        itemInList.findElement(By.tagName("button")).click();
        return itemName;
    }
}