import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SearchHelloWorld {
    private WebDriver driver;

    @Test
    public void helloWorld() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Hello World" + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("Hello World"), "Search failed");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
