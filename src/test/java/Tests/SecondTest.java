package Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SecondTest {
    @Test
    @DisplayName("בדיקת תהליך מקצה לקצה")
    public void e2eScenario() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //Scenario
        WebElement fName = driver.findElement(By.cssSelector("#firstname"));
        fName.sendKeys("tovi");
        WebElement lName = driver.findElement(By.id("lastname"));
        lName.sendKeys("shmuelevits");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("t0556736389");
        WebElement btnNext = driver.findElement(By.id("next"));
        btnNext.click();
        WebElement error = driver.findElement(By.id("email-error"));
        if (error.isDisplayed())
            System.out.println(error.getText());

        WebElement image = driver.findElement(By.xpath("//*[@id=\"wizard-picture\"]"));
        String filePath = "Z:\\B\\שמואלביץ טובי\\בדיקות\\SeleniumProject\\IMG_3409.jpg";
        image.sendKeys(filePath);

        Thread.sleep(5000);

        email.clear();
        email.sendKeys("t0556736389@gmail.com");
        btnNext.click();

        WebElement beginner = driver.findElement(By.id("Beginner"));
        beginner.click();
        Thread.sleep(5000);
        btnNext.click();

        WebElement streetName = driver.findElement(By.id("streetname"));
        streetName.sendKeys("haritva");

        WebElement streetNumber = driver.findElement(By.id("streetnumber"));
        streetNumber.sendKeys("14");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("mi");

        WebElement country = driver.findElement(By.id("country"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("Argentina");
        selectCountry.selectByValue("Italy");
        selectCountry.selectByIndex(2);

        WebElement finish = driver.findElement(By.id("finish"));
        finish.click();

        //Assertion
        WebElement messageDiv = driver.findElement(By.id("messageDiv"));
        Assertions.assertTrue(messageDiv.isDisplayed(), "בדיקה שהגענו לעמוד Congratulations");

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //End
        driver.quit();
    }

    @Test
    @DisplayName("בדיקת שדות נדרשים")
    public void required() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");

        //Scenario
        WebElement fName = driver.findElement(By.cssSelector("#firstname"));
        fName.sendKeys("");
        WebElement lName = driver.findElement(By.id("lastname"));
        lName.sendKeys("");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("");
        WebElement btnNext = driver.findElement(By.id("next"));
        btnNext.click();
        btnNext.click();

        //Assertion
        WebElement firstNameError = driver.findElement(By.id("firstname-error"));
        Assertions.assertTrue(firstNameError.isDisplayed(),"בדיקת קבלת שגיאה משדה firstname");
        System.out.println(firstNameError.getText());

        WebElement lastNameError = driver.findElement(By.id("lastname-error"));
        Assertions.assertTrue(lastNameError.isDisplayed(),"בדיקת קבלת שגיאה משדה lastname");
        System.out.println(lastNameError.getText());

        WebElement error = driver.findElement(By.id("email-error"));
        Assertions.assertTrue(error.isDisplayed(), "בדיקת קבלת שגיאה משדה email");
        System.out.println(error.getText());
        Thread.sleep(1000);

        //End
        driver.quit();
    }

    @Test
    @DisplayName("בדיקת תקינות מייל")
    public void mailVerification() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
        //Scenario
        WebElement fName = driver.findElement(By.cssSelector("#firstname"));
        fName.sendKeys("tovi");
        WebElement lName = driver.findElement(By.id("lastname"));
        lName.sendKeys("shmuelevits");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("t0556736389");
        WebElement btnNext = driver.findElement(By.id("next"));
        btnNext.click();

        //Assertion
        WebElement error = driver.findElement(By.id("email-error"));
        Assertions.assertEquals(error.getText(), "Please enter a valid email address.", "בדיקת תקינות מייל");
        System.out.println(error.getText());

        Thread.sleep(1000);


        //End
        driver.quit();
    }
}
