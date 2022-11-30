package pageObject.pages;

import common.wdm.WdManager;
import org.openqa.selenium.support.PageFactory;
import pageObject.pages.forgotPassword.ForgotPasswordPage;

public class Page {
    private static <TPage extends BasePage> TPage GetInstance(Class<TPage> pageClass) {
        try {
            TPage t = pageClass.getDeclaredConstructor().newInstance();
            PageFactory.initElements(WdManager.getAjaxEle(), t);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ForgotPasswordPage forgotPassword(){
        return GetInstance(ForgotPasswordPage.class);
    }
}


