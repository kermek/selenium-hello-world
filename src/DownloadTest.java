import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class DownloadTest {

    @Test
    public void downloadWget() {
        String baseUrl = "http://demo.guru99.com/test/yahoo.html";
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(baseUrl);
        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P F:\\Temp --no-check-certificate " + sourceLocation;
        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
        driver.close();
    }

    @Test
    public void download() throws InterruptedException {
//        File folder = new File(UUID.randomUUID().toString());
//        folder.mkdir();

        String baseUrl = "http://the-internet.herokuapp.com/download";
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("browser.download.dir", System.getProperty("user.dir"));
//        profile.setPreference("browser.download.folderList", 2);
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "images/jpeg,application/pdf,application/octet-stream,application/x-msdownload");
//        profile.setPreference("pdfjs.disabled", true);
//        FirefoxOptions options = new FirefoxOptions().setProfile(profile);
//        WebDriver driver = new FirefoxDriver(options);

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(baseUrl);
        driver.findElement(By.linkText("test.jpg")).click();

        Thread.sleep(2000);

        driver.close();
    }
}
