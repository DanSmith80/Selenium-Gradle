package advanced;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class AdvTests {

    @Test
    void uploadFile(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        WebElement fileInput = driver.findElement(By.id("fileinput"));
        String pathToFile = "C:\\downloads\\cat.jpg";
        fileInput.sendKeys(pathToFile);

        WebElement imageCheckbox = driver.findElement(By.id("itsanimage"));
        imageCheckbox.click();
        WebElement uploadButton = driver.findElement(By.name("upload"));
        uploadButton.click();
    }

    @Test
    void downloadFile() throws InterruptedException {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", "C:\\downloads\\");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://testpages.herokuapp.com/styled/download/download.html");
        WebElement directDownloadButton = driver.findElement(By.id("direct-download"));
        directDownloadButton.click();
        Thread.sleep(2000);

    }
}
