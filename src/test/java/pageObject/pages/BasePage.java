package pageObject.pages;

import common.wdm.WdManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class BasePage extends Page{
    public BasePage() {
        PageFactory.initElements(WdManager.getAjaxEle(), this);
    }


    //*********Region Useful actions*********
    protected <T> void click (T elementAttr) {
        if(elementAttr.getClass().getName().contains("By")) {
            WdManager.get().findElement((By) elementAttr).click();
        } else {
            ((WebElement) elementAttr).click();
        }
        waitUntilProgressbarLoaded();;
    }

    protected <T> void enterValue (T elementAttr, String text) {
        if(elementAttr.getClass().getName().contains("By")) {
            WdManager.get().findElement((By) elementAttr).sendKeys(text);
        } else {
            ((WebElement) elementAttr).sendKeys(text);
        }
        waitUntilProgressbarLoaded();
    }

    protected <T> String getText (T elementAttr) {
        if(elementAttr.getClass().getName().contains("By")) {
            return WdManager.get().findElement((By) elementAttr).getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    protected <T> boolean isDisplayed(T elementAtt) {
        try {
            if(elementAtt.getClass().getName().contains("By")) {
                return WdManager.get().findElement((By) elementAtt).isDisplayed();
            } else {
                return ((WebElement) elementAtt).isDisplayed();
            }
        } catch (Throwable ex) {
            return false;
        }
    }

    protected void waitUntilProgressbarLoaded() {
        int i = 1000;
        try {
            Thread.sleep(1000);
            //Base on the element of process bar
            while (isDisplayed(WdManager.get().findElement(By.xpath("//div[contains(@class,'q-inner-loading')]"))) && isDisplayed(WdManager.get().findElement(By.cssSelector("svg.q-spinner")))) {
                Thread.sleep(2000);
                if (i++ > 30000) {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    protected void waitUntilElementDisplay(WebElement elm) {
        int i = 1000;
        try {
            while (isDisplayed(elm)) {
                Thread.sleep(2000);
                if (i++ > 20000) {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    ////*********End Region*********
}
