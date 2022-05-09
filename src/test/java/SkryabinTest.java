import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SkryabinTest {
    String firstName = "Peter";
    String middleName = "O";
    String lastName = "Smith";

        @Test
        public void test2() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:/Users/Taras/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get("https://skryabin.com/market/quote.html");
            Dimension dim = new Dimension(1920, 1080);
            driver.manage().window().setSize(dim);
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date = new Date();
            String dateF = dateFormat.format(date);
            Assert.assertEquals(driver.findElement(By.id("currentDate")).getText(),dateF);

            driver.findElement(By.id("formSubmit")).click();
            Assert.assertEquals(driver.findElement(By.id("name-error")).getText(),"This field is required.");

            driver.findElement(By.name("name")).click();
            WebElement firstNameE = driver.findElement(By.name("firstName"));
            firstNameE.sendKeys(firstName);

            WebElement middleNameE = driver.findElement(By.name("middleName"));
            middleNameE.sendKeys(middleName);

            WebElement lastNameE = driver.findElement(By.name("lastName"));
            lastNameE.sendKeys(lastName);

            driver.findElement(By.xpath("//span[text() = 'Save']")).click();
            Thread.sleep(3000);

            /*String value = driver.findElement(By.name("name")).getAttribute("value");
            System.out.println(value);
            Assert.assertEquals(driver.findElement(By.xpath("//input[@value = '']").getText(),"Peter son");*/

            driver.findElement(By.name("username")).sendKeys("1");
            driver.findElement(By.id("formSubmit")).click();
            Assert.assertEquals(driver.findElement(By.id("username-error")).getText(), "Please enter at least 2 characters.");

            Thread.sleep(1500);
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("999999999");
            Thread.sleep(4500);


            driver.quit();
        }
    }
