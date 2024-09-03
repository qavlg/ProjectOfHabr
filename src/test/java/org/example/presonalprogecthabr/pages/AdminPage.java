package org.example.presonalprogecthabr.pages;

import org.example.presonalprogecthabr.AllureLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.presonalprogecthabr.Wait.myWait;

public class AdminPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));

    WebDriver driver;

    @FindBy(css = "a[href='/en/flows/admin/hubs/']")
    private WebElement hubsElement;

    @FindBy(css = "input[class='tm-input-text-decorated__input']")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(text(),'Title ')]")
    private WebElement titleElement;

    @FindBy(xpath = "//h1[contains(text(),'Admin')]")
    private WebElement titleAdmin;

    @FindBy(css = "span > a[href='/en/flows/admin/authors/']")
    private WebElement authorElement;

    @FindBy(css = "span > a[href='/en/flows/admin/news/']")
    private WebElement newsElement;

    @FindBy(css = "span > a[href='/en/flows/admin/posts/']")
    private WebElement postElement;

    @FindBy(css = "span > a[href='/en/flows/admin/']")
    private WebElement articlesElement;

    @FindBy(css = "button[class*='tm-navigation-filters-spoiler__button']")
    private WebElement dropDownListButton;

    @FindBy(xpath = "//button[contains(text(),'≥100')]")
    private WebElement moreOrEqual100Button;

    @FindBy(css = "button[class='btn btn_solid btn_small tm-navigation-filters__apply']")
    private WebElement applyButton;

    @FindBy(xpath = "//button[contains(text(),'New with rating ≥100')]")
    private WebElement nameOfElementNewWithRatingMoreOrEqual100;

    @FindBy(xpath = "//div[contains(text(),'Rating ')]")
    private WebElement ratingElement;

    @FindBy(xpath = "//div[contains(text(),'Subscribers ')]")
    private WebElement subscribersElement;


    public void clickHubsElement() {
        hubsElement.click();
        LOG.info("Click on the Hubs element");
    }

    public void inputTextIntoSearchField(String text) {
        searchField.sendKeys(text);
        LOG.info("Enter text into the Search field");
    }

    public void clickTitleElement() {
        myWait(5).clickable(titleElement);
        titleElement.click();
        driver.navigate().refresh();
        LOG.info("Click on the Title element");
    }

    public String getSearchFieldText() {
        return searchField.getAttribute("value");
    }

    public String checkTitleAdmin() {
        myWait(5).visible(titleAdmin);
        LOG.infoWithScreenshot("Check if the title 'Admin' is correct");
        return titleAdmin.getText();
    }

    public Boolean checkAuthorElement() {
        LOG.infoWithScreenshot("Check if the Author element is active");
        return authorElement.isEnabled();
    }

    public Boolean checkHubsElement() {
        LOG.infoWithScreenshot("Check if the Hubs element is active");
        return hubsElement.isEnabled();
    }

    public Boolean checkNewsElement() {
        LOG.infoWithScreenshot("Check if the News element is active");
        return newsElement.isEnabled();
    }

    public Boolean checkPostElement() {
        LOG.infoWithScreenshot("Check if the Post element is active");
        return postElement.isEnabled();
    }

    public Boolean checkArticlesElement() {
        LOG.infoWithScreenshot("Check if the Articles element is active");
        return articlesElement.isEnabled();
    }

    public void clickDropDownListButton() {
        myWait(5).clickable(dropDownListButton);
        dropDownListButton.click();
        LOG.info("Click on the Drop-down list button");
    }

    public void clickMoreOrEqual100Button() {
        moreOrEqual100Button.click();
        LOG.info("Click on the '≥100' button");
    }

    public void clickApplyButton() {
        applyButton.click();
        driver.navigate().refresh();
        LOG.info("Click on the Apply button");
    }

    public String checkTitleNewWithRatingMoreOrEqual100() {
        myWait(5).visible(nameOfElementNewWithRatingMoreOrEqual100);
        LOG.infoWithScreenshot("Check if the name of the 'New with rating ≥100' element is correct");
        return nameOfElementNewWithRatingMoreOrEqual100.getText();
    }

    public Boolean checkTitleElement() {
        LOG.infoWithScreenshot("Check if the Title element is active");
        return titleElement.isEnabled();
    }

    public Boolean checkRatingElement() {
        LOG.infoWithScreenshot("Check if the Rating element is active");
        return ratingElement.isEnabled();
    }

    public Boolean checkSubscribersElement() {
        LOG.infoWithScreenshot("Check if the Subscribers element is active");
        return subscribersElement.isEnabled();
    }

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
