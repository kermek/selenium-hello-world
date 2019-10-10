import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumDockerTest {
    private WebDriver driver;

    @Test
    public void helloWorld() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                new ImmutableCapabilities(options));

        driver.get("https://www.google.com");

        driver.quit();
    }
}
