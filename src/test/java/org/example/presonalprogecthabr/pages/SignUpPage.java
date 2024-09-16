package org.example.presonalprogecthabr.pages;

import org.example.presonalprogecthabr.AllureLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.presonalprogecthabr.Wait.myWait;
import static org.example.presonalprogecthabr.tests.BaseTest.getDriver;

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

    @FindBy(css = "a[class*='socials-buttons__button_facebook']")
    private WebElement facebookButton;

    @FindBy(css = "a[class*='socials-buttons__button_vkontakte']")
    private WebElement vkontakteButton;

    @FindBy(css = "a[class*='socials-buttons__button_twitter']")
    private WebElement twitterButton;

    @FindBy(css = "a[class*='socials-buttons__button_github']")
    private WebElement gitHubButton;

    @FindBy(css = "a[class*='socials-buttons__button_liveid']")
    private WebElement liveIidButton;

    @FindBy(css = "a[class*='socials-buttons__button_google']")
    private WebElement googleButton;

    @FindBy(xpath = "//strong[contains(text(),'GitHub')]")
    private WebElement titleOfGitHub;

    @FindBy(xpath = "//div[contains(text(),'You need to fill in this field')]")
    private WebElement textWithError;

    @FindBy(css= "fieldset[class='form__fields']")
    private WebElement outsideOfField;

    @FindBy(xpath = "//div[contains(text(),'Registration')]")
    private WebElement titleOfRegistration;

    public void clickSignUpButton() {
        signUpButton.click();
        LOG.info("Click on the Sign Up button");
    }

    public void clickCheckBoxUserAgreement() throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", checkBoxUserAgreement);
            Thread.sleep(15000);

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
        LOG.infoWithScreenshot("Check if the Sign Up button is active");
        return sighUpButton.isEnabled();
    }

    public Boolean checkFacebookButton() {
        LOG.infoWithScreenshot("Check if the Facebook button is active");
        return facebookButton.isEnabled();
    }

    public Boolean checkVkontakteButton() {
        LOG.infoWithScreenshot("Check if the Vkontakte button is active");
        return vkontakteButton.isEnabled();
    }

    public Boolean checkTwitterButton() {
        LOG.infoWithScreenshot("Check if the Twitter button is active");
        return twitterButton.isEnabled();
    }

    public Boolean checkGitHubButton() {
        LOG.infoWithScreenshot("Check if the GitHub button is active");
        return gitHubButton.isEnabled();
    }

    public Boolean checkLiveIidButton() {
        LOG.infoWithScreenshot("Check if the LiveIid button is active");
        return liveIidButton.isEnabled();
    }

    public Boolean checkGoogleButton() {
        LOG.infoWithScreenshot("Check if the Google button is active");
        return googleButton.isEnabled();
    }

    public void clickGitHubButton() {
        gitHubButton.click();
        LOG.info("Click on the gitHub Button");
    }

    public String checkTitleOfGitHub() {
        myWait(5).visible(titleOfGitHub);
        LOG.infoWithScreenshot("Check if the title of GitHub is correct");
        return titleOfGitHub.getText();
    }

    public void clearEmailField() {
        emailField.clear();
        LOG.info("Clear text from the email field.");
    }

    public void clearUsernameField() {
        usernameField.clear();
        LOG.info("Clear text from the username field.");
    }

    public void clearPasswordField() {
        passwordField.clear();
        LOG.info("Clear text from the password field.");
    }

    public void clickOutsideOfField() {
        outsideOfField.click();
        LOG.info("Click on outside Of the field");
    }

    public String checkTextWithError() {
        myWait(5).visible(textWithError);
        LOG.infoWithScreenshot("Check if the text with error is correct");
        return textWithError.getText();
    }

    public String checkTitleOfRegistration() {
        myWait(5).visible(titleOfRegistration);
        LOG.infoWithScreenshot("Check if the title of registration is correct");
        return titleOfRegistration.getText();
    }

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
