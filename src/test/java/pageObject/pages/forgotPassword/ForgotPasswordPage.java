package pageObject.pages.forgotPassword;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.pages.BasePage;

public class ForgotPasswordPage extends BasePage {
    @FindBy(id = "txtEmail")
    WebElement txtEmail;

    @FindBy(id = "lblEmailErr")
    WebElement lblEmailErr;

    @FindBy(id = "btnSend")
    WebElement btnSend;

    //*********Page Methods*********
    public void inputEmail(String value){
        waitUntilElementDisplay(txtEmail);
        enterValue(txtEmail, value);
    }

    public String getErrorMessage(){
        waitUntilElementDisplay(lblEmailErr);
        return getText(lblEmailErr);
    }

    public void clickSendBtn(){
        waitUntilElementDisplay(btnSend);
        click(btnSend);
    }
}
