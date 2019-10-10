import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid4StandAlone3Test {
    private WebDriver driver;

    @Test
    public void helloWorld() throws MalformedURLException {
        InternetExplorerOptions options = new InternetExplorerOptions();

        driver = new RemoteWebDriver(new URL("http://localhost:4444"),
                new ImmutableCapabilities(options));

        driver.get("https://www.google.com");

        driver.quit();
    }
}
