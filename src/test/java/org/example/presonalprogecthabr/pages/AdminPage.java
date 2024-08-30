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

    @FindBy(css = "a[data-test-id='main-menu-item']:nth-child(4)")
    private WebElement adminElement;

    @FindBy(css = "a[href='/en/flows/admin/hubs/']")
    private WebElement hubsElement;

    @FindBy(css = "input[class='tm-input-text-decorated__input']")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(text(),'Title ')]")
    private WebElement titleElement;

    public void clickAdminElement() {
        adminElement.click();
        LOG.info("Click on the Admin element");
    }

    public void clickHubsElement() {
        hubsElement.click();
        LOG.info("Click on the Hubs element");
    }

    public void inputTextIntoSearchField(String text) {
        searchField.sendKeys(text);
        LOG.info("Enter text into the Search field");
    }

    public void clickTitleElement() {
        titleElement.click();
        LOG.info("Click on the Title element");
    }

    public String getSearchFieldText() {
        return searchField.getAttribute("value");
    }

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
