package common.wdm;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.URL;

/**
 * Generate WD
 */
public class WDFactory {


    /**
     * initialize a browser
     *
     * @param browserType
     * @return
     */
    public static WebDriver initBrowser(final Browser browserType) {
        return initBrowser(browserType, null);
    }

    public static WebDriver initBrowser(final String browserName) {
        return initBrowser(Browser.getBrowserByName(browserName), null);
    }

    /**
     * initialize browser with options
     *
     * @param browserType
     * @param options
     * @param <T>
     * @return
     */
    public static <T extends MutableCapabilities> WebDriver initBrowser(final Browser browserType, final T options) {
        WebDriver webDriver;
        switch (browserType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = options instanceof FirefoxOptions ? new FirefoxDriver((FirefoxOptions) options) : new FirefoxDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                webDriver = options instanceof InternetExplorerOptions ? new InternetExplorerDriver((InternetExplorerOptions) options) : new InternetExplorerDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = options instanceof ChromeOptions ? new ChromeDriver((ChromeOptions) options) : new ChromeDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                webDriver = options instanceof SafariOptions ? new SafariDriver((SafariOptions) options) : new SafariDriver();
                break;
            default:
                webDriver = null;
                break;
        }
        return webDriver;
    }

    public static <T extends MutableCapabilities> WebDriver initBrowser(final String browserName, final T options) {
        return initBrowser(Browser.getBrowserByName(browserName), options);
    }

    /**
     * create remote WD
     *
     * @param remoteAddress
     * @param cap
     * @return RemoteWebDriver
     */
    public static RemoteWebDriver remote(final URL remoteAddress, final Capabilities cap) {
        return new RemoteWebDriver(remoteAddress, cap);
    }

    /**
     * get Config class for setting
     *
     * @return Config
     */
    public static Config getConfig() {
        return WebDriverManager.getInstance().config();
    }
}
