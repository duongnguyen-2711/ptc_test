package pageObject.pages.forgotPassword;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.BasePage;

public class ThankYouPage extends BasePage {
    @FindBy(id = "lblRequestPasswordAccepted")
    WebElement lblRequestPasswordAccepted;

    public boolean isRequestedAccepted(){
        return isDisplayed(lblRequestPasswordAccepted);
    }
}
