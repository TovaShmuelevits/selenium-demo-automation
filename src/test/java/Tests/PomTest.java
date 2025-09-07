package Tests;

import Pages.Page;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PomTest {
    static WebDriver driver;
    static Pages.Page page;

    @BeforeEach
    public void beforeEach() {
        driver.navigate().refresh();
    }

    @BeforeAll
    public static void before() {
        driver = new ChromeDriver();
        driver.get("https://automation.co.il/tutorials/selenium/demo1/indexID.html");
        page = new Page(driver);
    }

    @Test
    @DisplayName("בדיקת תהליך מקצה לקצה")
    public void e2eScenario() throws InterruptedException {
        page.getFirstName().sendKeys("tovi");
        page.getLastName().sendKeys("shmuelevits");
        page.getEmail().sendKeys("t0556736389");
        page.getBtnNext().click();

        if (page.getEmailError().isDisplayed())
            System.out.println(page.getEmailError().getText());
        page.getEmail().clear();
        page.getEmail().sendKeys("t0556736389@gmail.com");
        String filePath = "Z:\\B\\שמואלביץ טובי\\בדיקות\\SeleniumProject\\IMG_3409.jpg";
        page.getImage().sendKeys(filePath);
        Thread.sleep(5000);
        page.getBtnNext().click();
        page.getBeginner().click();
        Thread.sleep(5000);
        page.getBtnNext().click();
        page.getStreetName().sendKeys("haritva");
        page.getStreetNumber().sendKeys("14");
        page.getCity().sendKeys("mi");


        Select selectCountry = new Select(page.getSelectCountry());
        selectCountry.selectByVisibleText("Argentina");
        selectCountry.selectByValue("Italy");
        selectCountry.selectByIndex(2);
        page.getFinishBtn().click();
        //Assertion
        Assertions.assertTrue(page.getMessageDiv().isDisplayed(), "בדיקה שהגענו לעמוד Congratulations");
    }


    @Test
    @DisplayName("בדיקת שדות נדרשים")
    public void required() throws InterruptedException {
        page.getFirstName().sendKeys("");
        page.getLastName().sendKeys("");
        page.getEmail().sendKeys("");
        page.getBtnNext().click();
        page.getBtnNext().click();
        //Assertion
        Assertions.assertTrue(page.getFirstNameError().isDisplayed(), "בדיקת קבלת שגיאה משדה firstname");
        System.out.println(page.getFirstNameError().getText());

        Assertions.assertTrue(page.getLastNameError().isDisplayed(), "בדיקת קבלת שגיאה משדה lastname");
        System.out.println(page.getLastNameError().getText());

        Assertions.assertTrue(page.getEmailError().isDisplayed(), "בדיקת קבלת שגיאה משדה email");
        System.out.println(page.getEmailError().getText());
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("בדיקת תקינות מייל")
    public void mailVerification() throws InterruptedException {
        page.getFirstName().sendKeys("tovi");
        page.getLastName().sendKeys("shmuelevit");
        page.getEmail().sendKeys("t0556736389");
        page.getBtnNext().click();

        //Assertion
        Assertions.assertEquals(page.getEmailError().getText(), "Please enter a valid email address.", "בדיקת תקינות מייל");

        System.out.println(page.getEmailError().getText());

        Thread.sleep(1000);
    }

    //End
    @AfterAll
    public static void after() {
        driver.quit();
    }


}
