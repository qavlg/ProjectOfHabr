package org.example.presonalprogecthabr.pages;

import org.example.presonalprogecthabr.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.presonalprogecthabr.Wait.myWait;

public class SignUpPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));

    WebDriver driver;

    @FindBy(css = "a[class='form-additional-message__link']")
    private WebElement signUpButton;

    @FindBy(css = "span[class='checkbox__label checkbox__label_top']")
    private WebElement checkBoxUserAgreement;

    @FindBy(xpath = "//div[contains(text(),'You need to accept the User Agreement')]")
    private WebElement errorOfCheckBox;

    @FindBy(css = "input[id='email_field']")
    private WebElement emailField;

    @FindBy(css = "input[id='nickname_field']")
    private WebElement usernameField;

    @FindBy(css = "input[id='password_field']")
    private WebElement passwordField;

    @FindBy(css = "input[id='password_repeat']")
    private WebElement repeatPasswordField;

    @FindBy(css = "button[id='registration_button']")
    private WebElement sighUpButton;




    public void clickSignUpButton() {
        signUpButton.click();
        LOG.info("Click on the Sign Up button");
    }

    public void clickCheckBoxUserAgreement() {
        checkBoxUserAgreement.click();
        LOG.info("Click on the check box 'User agreement'");
    }

    public String checkErrorOfCheckBox() {
        myWait(5).visible(errorOfCheckBox);
        LOG.infoWithScreenshot("Check if the error 'You need to accept the User Agreement' under the check box is correct");
        return errorOfCheckBox.getText();
    }

    public void inputTextIntoEmailField(String email) {
        emailField.sendKeys(email);
        LOG.info("Enter text into the search field");
    }

    public void inputTextIntoUsernameField(String username) {
        usernameField.sendKeys(username);
        LOG.info("Enter text into the search field");
    }

    public void inputTextIntoPasswordField(String password) {
        passwordField.sendKeys(password);
        LOG.info("Enter text into the search field");
    }

    public void inputTextIntoRepeatPasswordField(String repeatPassword) {
        repeatPasswordField.sendKeys(repeatPassword);
        LOG.info("Enter text into the search field");
    }

    public Boolean checkSighUpButton() {
        LOG.infoWithScreenshot("Check if the RRS Copy Lick element is active");
        return sighUpButton.isEnabled();
    }

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
