import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HelloWorldMultiTab {
    private WebDriver driver;

    @Test
    public void helloChrome() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String googleWindow = driver.getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://softserveinc.com')");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("fullpage")));

//        System.out.println(driver.getTitle());

        driver.switchTo().window(googleWindow);

        driver.quit();
    }

    @Test
    public void helloFirefox() {
        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        String googleWindow = driver.getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.softserveinc.com')");

        driver.switchTo().window(googleWindow);

        driver.quit();
    }

    @Test
    public void helloEdge() {
        driver = new EdgeDriver();
        driver.get("http://www.google.com");
        String googleWindow = driver.getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.softserveinc.com')");

        driver.switchTo().window(googleWindow);

        driver.quit();
    }
}
