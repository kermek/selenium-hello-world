import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileUploadTest {
    private WebDriver driver;

    @Test
    public void helloWorld() {
        driver = new ChromeDriver();
        driver.get("юфю");

        driver.findElement(By.linkText("File Upload")).click();

        driver.findElement(By.id("file-upload")).sendKeys("F:/Temp/cat.jpg");
        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),
                "cat.jpg", "File Upload Failed");
    }

    @Test
    public void UploadFileUsingAutoIt() throws IOException, InterruptedException {
        String workingDir = System.getProperty("user.dir");
        String autoItScriptPath = workingDir + "\\File_upload_selenium_webdriver.au3";
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/upload/");

        new Actions(driver).click(driver.findElement(By.id("uploadfile_0"))).build().perform();

        Runtime.getRuntime().exec( " cmd.exe /c Start \"C:\\Program Files (x86)\\AutoIt3.exe\" "
                + autoItScriptPath
                + " F:\\Temp\\cat.jpg");

        new WebDriverWait(driver, 60)
                .until((ExpectedCondition<Boolean>) driver ->
                        driver.findElement(By.id("uploadfile_0"))
                        .getAttribute("value").contains("cat.jpg"));

        driver.findElement(By.id("submitbutton")).click();

        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("res")));

        Assert.assertTrue(driver.findElement(By.id("res")).getText()
                        .contains("successfully uploaded"),
                "File Upload Failed");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
