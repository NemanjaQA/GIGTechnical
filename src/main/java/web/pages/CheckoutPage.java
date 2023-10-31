package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    By firstNameFieldBy = By.id("first-name");
    By lastNameFieldBy = By.id("last-name");
    By postalCodeFieldBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
    By finishButtonBy = By.id("finish");
    By thankYouMessageBy = By.className("complete-header");

    public CheckoutPage fillCheckoutDetailsAndContinue(String firstName, String lastName, String postalCode){
        writeText(firstNameFieldBy, firstName);
        writeText(lastNameFieldBy, lastName);
        writeText(postalCodeFieldBy, postalCode);
        clickElement(continueButtonBy);
        return this;
    }
    public CheckoutPage clickFinishCheckout(){
        clickElement(finishButtonBy);
        return this;
    }
    public void verifyCheckoutCompleted(String expectedText){
        Assert.assertEquals(readTextFromElement(thankYouMessageBy), expectedText);
    }
}