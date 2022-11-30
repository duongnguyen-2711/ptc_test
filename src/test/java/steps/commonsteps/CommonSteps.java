package steps.commonsteps;

import common.wdm.WdManager;
import net.thucydides.core.annotations.Step;
import pageObject.utils.Environment;

public class CommonSteps {
    @Step("Open the Forgot Password Page")
    public void openForgotPasswordPage() {
        WdManager.get().get(Environment.getEnvironmentConfigs().getProperty("url"));

    }
}
