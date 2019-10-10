import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Based on article:
 * https://medium.com/@abhidp/deploy-a-selenium-grid-on-google-cloud-platform-using-kubernetes-4ea49747392f
 */
public class Zalenium2Test {
    private WebDriver driver;

//    kubectl create namespace zalenium
//    helm init --client-only
//    helm template --name zalenium \
//            --set hub.serviceType=LoadBalancer \
//    charts/zalenium | kubectl -n zalenium apply -f -
    @Test
    public void helloWorld() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        driver = new RemoteWebDriver(new URL("http://34.70.69.76/wd/hub"),
                new ImmutableCapabilities(options));

        driver.get("https://www.google.com");

        driver.quit();
    }
}
