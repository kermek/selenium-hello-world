import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HelloWorld {
    private WebDriver driver;

    @Test
    public void helloWorld() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
        options.setHeadless(true);

        driver = new ChromeDriver(options);

        driver.get("http://www.google.com");

        driver.quit();
    }
}
