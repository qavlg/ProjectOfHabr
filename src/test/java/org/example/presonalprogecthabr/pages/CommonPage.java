package org.example.presonalprogecthabr.pages;

import org.example.presonalprogecthabr.tests.CommonTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.example.presonalprogecthabr.AllureLogger;

import java.util.ArrayList;
import java.util.List;

import static org.example.presonalprogecthabr.Wait.myWait;

public class CommonPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(CommonPage.class));

    WebDriver driver;

    @FindBy(css = "svg[class*='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_dark'] use")
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



    @FindBy(css = "svg[class*='counter-link__icon'] use")
    private List<WebElement> commentButtonUnderPosts;



    public void clickSettingsButton() {
        settingsButton.click();

        LOG.info("Clicking on the 'Settings' button");
    }

    public void clickEnglishCheckBox() {
        englishCheckBox.click();

        LOG.info("Clicking on the 'English' check box");
    }

    public void clickLoginButton() {
        loginButton.click();

        LOG.info("Clicking on the 'Login' button");
    }

    public void clickSaveSettingsButton() {
        saveSettingsButton.click();

        LOG.info("Clicking on the 'Save preferences' button");
    }

    public void clickChangeEnglishButton() {
        changeEnglishButton.click();

        LOG.info("Clicking on the 'English' button");
    }

    public String checkTitleLogin() {
        myWait(20).visible(titleLogin);

        LOG.infoWithScreenshot("Checking if the title 'Log in' is correct");
        return titleLogin.getText();
    }




    public void clickSearchButtonOnMainPage() {
        searchButtonOnMainPage.click();

        LOG.info("Clicking on the 'Search' button on the main page");
    }

    public void inputTextIntoSearchField(String text) {
        myWait(20).visible(inputSearchField);
        inputSearchField.sendKeys(text);

        myWait(20).clickable(secondarySearchButton);
        secondarySearchButton.click();

        LOG.info("Entering text into the search field");
        LOG.info("Clicking on the secondary search button");
    }

    public void clickDropDownList() {
        dropDownList.click();

        LOG.info("Clicking on the drop-down list");
    }

    public Boolean checkSortByRatingButton() {
        myWait(20).clickable(sortByRatingButton);

        LOG.infoWithScreenshot("Checking if the sort by rating button is active");
        return sortByRatingButton.isEnabled();
    }



    public Boolean checkRrsCopyLick() {
        myWait(20).clickable(rrsCopyLick);

        LOG.infoWithScreenshot("Checking if the RRS Copy Lick element is active");
        return rrsCopyLick.isEnabled();
    }


    public void clickCommentButtonUnderPost(int num) {
        commentButtonUnderPosts.get(num).click();

        LOG.info("Clicking on the element on the page under number: " + num);
    }



    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
