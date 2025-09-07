package Tests;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver ;
import org.openqa.selenium.support.ui.Select;

import javax.sound.midi.Soundbank;
import java.util.Objects;

public class FirstTest {
    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        if (Objects.requireNonNull(driver.getTitle()).contains("google.com"))
            System.out.println(driver.getTitle());
        driver.quit();

    }
    @Test
   public void test2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebElement fName = driver.findElement(By.id("firstname"));
        fName.sendKeys("tovi");
        WebElement lName = driver.findElement(By.id("lastname"));
        lName.sendKeys("shmuelevits");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("t0556736389");
        WebElement btnNext = driver.findElement(By.id("next"));
        btnNext.click();
        WebElement error = driver.findElement(By.id("email-error"));
        if(error.isDisplayed())
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

        btnNext.click();

        WebElement streetName = driver.findElement(By.id("streetname"));
        streetName.sendKeys("haritva");

        WebElement streetNumber = driver.findElement(By.id("streetnumber"));
        streetNumber.sendKeys("14");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("mi");

        WebElement country = driver.findElement(By.id("country"));
        Select selectCountry = new Select(country);

        selectCountry.selectByIndex(2);

        WebElement finish = driver.findElement(By.id("finish"));
        finish.click();

        WebElement messageDiv = driver.findElement(By.id("messageDiv"));
        if(messageDiv.isDisplayed())
            System.out.println(driver.getTitle()+"\n"+"did it!!!!!");

        driver.quit();

    }
}