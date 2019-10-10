import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AlertTest {
    private WebDriver driver;

    @Test
    public void helloWorld() {
        driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Hi')");

        driver.switchTo().alert().accept();
        js.executeScript("console.log(prompt('How old are you?', 100))");

        driver.switchTo().alert().sendKeys("42");
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.quit();
    }
}
