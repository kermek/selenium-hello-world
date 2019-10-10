import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @Test
    public void helloWorld() {
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com");

        driver.findElement(By.linkText("Form Authentication")).click();

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("button")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),
                "Secure Area", "Login Failed");

        driver.findElement(By.linkText("Logout")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
