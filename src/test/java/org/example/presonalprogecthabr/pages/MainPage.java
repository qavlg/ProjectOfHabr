package org.example.presonalprogecthabr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.example.presonalprogecthabr.AllureLogger;

import java.util.ArrayList;
import java.util.List;

import static org.example.presonalprogecthabr.Wait.myWait;

public class MainPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));

    WebDriver driver;

    @FindBy(css = "button > svg[class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_dark']")
    private WebElement settingsButton;

    @FindBy(xpath = "(//div[@data-test-id='checkbox-labeled-input_ui'])[2]")
    private WebElement englishCheckBox;

    @FindBy(css = "button[type='submit']")
    private WebElement saveSettingsButton;

    @FindBy(css = "button[class*='tm-header-user-menu__login']")
    private WebElement loginButton;

    @FindBy(css = "[class='footer-links__link']:first-child")
    private WebElement changeEnglishButton;

    @FindBy(xpath = "//div[contains(text(),'Log in')]")
    private WebElement titleLogin;

    @FindBy(css = "a[href='/en/search/']")
    private WebElement searchButtonOnMainPage;

    @FindBy(css = "input[placeholder='Search']")
    private WebElement inputSearchField;

    @FindBy(css = ".tm-svg-img.tm-svg-icon[height='16']")
    private WebElement secondarySearchButton;

    @FindBy(css = "button[class='tm-navigation-dropdown__button tm-navigation-dropdown__button']")
    private WebElement dropDownList;

    @FindBy(xpath = "(//button[@class='tm-navigation-dropdown__option-button'])[3]")
    private WebElement sortByRatingButton;

    @FindBy(css = "button.tm-rss-button.tm-rss-button_default > span > svg > use")
    private WebElement rrsCopyLick;

    @FindBy(css = "a[class='tm-article-snippet__readmore']")
    private List<WebElement> readMoreButton;

    @FindBy(css = "a[href='/en/sandbox/start/']")
    private WebElement howBecomeAuthorButton;

    @FindBy(xpath = "//a[contains(text(),'Waiting for invitation ')]")
    private WebElement waitingForInvitationElement;

    @FindBy(css = "a[href='/docs/help/sandbox/']")
    private WebElement sandboxElement;

    @FindBy(xpath = "//h2[contains(text(),'Sandox')]")
    private WebElement titleSandbox;

    public void clickSettingsButton() {
        settingsButton.click();
        LOG.info("Click on the Settings button");
    }

    public void clickEnglishCheckBox() {
        englishCheckBox.click();
        LOG.info("Click on the English check box");
    }

    public void clickLoginButton() {
        loginButton.click();
        LOG.info("Click on the Login button");
    }

    public void clickSaveSettingsButton() {
        saveSettingsButton.click();
        LOG.info("Click on the Save preferences button");
    }

    public void clickChangeEnglishButton() {
        changeEnglishButton.click();
        LOG.info("Click on the English button");
    }

    public String checkTitleLogin() {
        myWait(5).visible(titleLogin);
        LOG.infoWithScreenshot("Check if the title 'Log in' is correct");
        return titleLogin.getText();
    }

    public void clickSearchButtonOnMainPage() {
        searchButtonOnMainPage.click();
        LOG.info("Click on the Search button on the main page");
    }

    public void inputTextIntoSearchField(String text) {
        inputSearchField.sendKeys(text);
        secondarySearchButton.click();
        LOG.info("Enter text into the search field");
        LOG.info("Click on the secondary search button");
    }

    public void clickDropDownList() {
        dropDownList.click();
        LOG.info("Click on the Drop-down list");
    }

    public Boolean checkSortByRatingButton() {
        LOG.infoWithScreenshot("Check if the sort by rating button is active");
        return sortByRatingButton.isEnabled();
    }

    public Boolean checkRrsCopyLick() {
        LOG.infoWithScreenshot("Check if the RRS Copy Lick element is active");
        return rrsCopyLick.isEnabled();
    }

    public void clickReadMoreButton(int num) {
        readMoreButton.get(num).click();
        LOG.info("Click on the element on the page under number: " + num);
    }


    public void clickHowBecomeAuthorButton() {
        howBecomeAuthorButton.click();
        LOG.info("Click on the How to become an author button");
    }

    public void clickWaitingForInvitationElement() {
        waitingForInvitationElement.click();
        LOG.info("Click on the Waiting for invitation element");
    }

    public void clickSandboxElement() {
        sandboxElement.click();
        LOG.info("Click on the Sandbox element");
    }

    public String checkTitleSandbox() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); // когда открывается новая страница
        driver.switchTo().window(tabs.get(1));
        myWait(5).visible(titleSandbox);
        LOG.infoWithScreenshot("Check if the title 'Sandbox' is correct");
        return titleSandbox.getText();
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
