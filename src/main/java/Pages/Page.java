package Pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Data
public class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#firstname")
    private WebElement firstName;
    @FindBy(id = "lastname")
    private WebElement lastName;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "next")
    private WebElement btnNext;
    @FindBy(id = "email-error")
    private WebElement emailError;
    @FindBy(xpath = "//*[@id=\"wizard-picture\"]")
    private WebElement image;
    @FindBy(id = "Beginner")
    private WebElement beginner;
    @FindBy(id = "streetname")
    private WebElement streetName;
    @FindBy(id = "streetnumber")
    private WebElement streetNumber;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "country")
    private WebElement selectCountry;
    @FindBy(id = "finish")
    private WebElement finishBtn;
    @FindBy(id = "messageDiv")
    private WebElement messageDiv;
    @FindBy(id = "firstname-error")
    private WebElement firstNameError;
    @FindBy(id = "lastname-error")
    private WebElement lastNameError;


}
