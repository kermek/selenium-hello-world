import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DragAndDropTest {
    private WebDriver driver;

    @Test
    public void helloWorld() {
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/resources/demos/sortable/connect-lists.html");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.xpath("//ul[@id='sortable1']/li[text() = 'Item 1']"));
        WebElement target = driver.findElement(By.xpath("//ul[@id='sortable2']/li[text() = 'Item 1']"));

        actions
                .dragAndDrop(source, target)
                .build()
                .perform();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
