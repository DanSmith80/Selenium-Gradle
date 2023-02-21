package basics;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RegistrationFormTest {
    @Test
    public void openBing(){
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://mytestingthoughts.com/Sample/home.html");

        WebElement firstName = driver.findElement(By.name("first_name"));
        firstName.sendKeys("Mike");

        WebElement lastName = driver.findElement(By.name("last_name"));
        lastName.sendKeys("Dobrzycki");

        List<WebElement> genderRadioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        genderRadioButtons.get(1).click(); // this will select first element on gender radio button
        // genderRadioButtons.get(1).click(); // this will select second element on gender radio button

        String firstUserName = driver.findElement(By.xpath("//*[@id=\"mytable\"]/tbody/tr/td[1]")).getText();
        System.out.println(firstUserName);

        // because it's input we need to read text in a different way
        System.out.println(firstName.getAttribute("value"));

        WebElement departmentDropdown = driver.findElement(By.xpath("//select[@name='department']"));
        Select departmentSelect = new Select(departmentDropdown);

        departmentSelect.selectByVisibleText("MCR");

        WebElement hobbiesElement = driver.findElement(By.id("exampleFormControlSelect2"));
        Select hobbiesSelect = new Select(hobbiesElement);

        Random ran = new Random();
        int x = ran.nextInt(5);
        System.out.println(x);

        hobbiesSelect.selectByIndex(x);

    }
}
