import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Based on articles:
 * https://github.com/aerokube/selenoid
 * https://github.com/aerokube/selenoid-ui
 */
public class SelenoidTest {
    private WebDriver driver;

    @Test
    public void helloWorld() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("enableVNC", true);

        driver = new RemoteWebDriver(new URL("http://34.221.163.165:4444/wd/hub"),
                new ImmutableCapabilities(options));

        driver.get("https://www.google.com");

        driver.quit();
    }
}
