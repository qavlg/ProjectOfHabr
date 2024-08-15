package org.example.presonalprogecthabr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.example.presonalprogecthabr.AllureLogger;
import static org.example.presonalprogecthabr.Wait.myWait;

public class CommonPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(CommonPage.class));

    WebDriver driver;

    @FindBy(css = "button[class='tm-header-user-menu__toggle']")
    private WebElement settingsButton;

    @FindBy(xpath = "(//div[@data-test-id='checkbox-labeled-input_ui'])[2]")
    private WebElement englishCheckBox;

    @FindBy(css = "button[class='btn btn_solid btn_large tm-page-settings-form__submit']")
    private WebElement saveSettingsButton;

    @FindBy(css = "button[class='btn btn_solid btn_small tm-header-user-menu__login']")
    private WebElement loginButton;

    @FindBy(css = "[class='footer-links__link']:first-child")
    private WebElement changeEnglishButton;

    @FindBy(xpath = "//div[contains(text(),'Log in')]")
    private WebElement titleLogin;

    public void clickSettingsButton() {
        myWait(20).visible(settingsButton);
        settingsButton.click();

        LOG.info("Clicking on the 'Settings' button");
    }

    public void clickEnglishCheckBox() {
        myWait(20).visible(englishCheckBox);
        englishCheckBox.click();

        LOG.info("Clicking on the 'English' check box");
    }

    public void clickLoginButton() {
        myWait(20).visible(loginButton);
        loginButton.click();

        LOG.info("Clicking on the 'Login' button");
    }

    public void clickSaveSettingsButton() {
        myWait(20).visible(saveSettingsButton);
        saveSettingsButton.click();

        LOG.info("Clicking on the 'Save preferences' button");
    }

    public void clickChangeEnglishButton() {
        myWait(20).visible(changeEnglishButton);
        changeEnglishButton.click();

        LOG.info("Clicking on the 'English' button");
    }

    public String checkTitleLogin() {
        myWait(20).visible(titleLogin);

        return titleLogin.getText();
    }

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
