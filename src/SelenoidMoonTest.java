import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Based on article:
 * https://github.com/aerokube/moon
 */
public class SelenoidMoonTest {
    private WebDriver driver;

//    git clone https://github.com/aerokube/moon-deploy.git && cd moon-deploy && kubectl apply -f moon.yaml
    @Test
    public void helloWorld() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("enableVNC", true);

        driver = new RemoteWebDriver(new URL("http://35.225.157.159:4444/wd/hub"),
                new ImmutableCapabilities(options));

        driver.get("https://www.google.com");

        driver.quit();
    }
}
