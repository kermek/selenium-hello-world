import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid4StandAlone2Test {
    private WebDriver driver;

    @Test
    public void helloWorld() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();

        driver = new RemoteWebDriver(new URL("http://localhost:4444"),
                options);

        driver.get("https://www.google.com");

        driver.quit();
    }
}
