import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Set;

public class CookieTest {
    private WebDriver driver;

    @Test
    public void helloWorld() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.cookie = 'username=John Doe'");


        Set<Cookie> cookies = driver.manage().getCookies();
        Cookie cookie = driver.manage().getCookieNamed("username");

        driver.manage().addCookie(new Cookie("username", "Tom Smith", "/", null));

        Assert.assertEquals(cookie.getValue(), "John Doe", "Cookie is not valid");


        driver.quit();
    }
}
