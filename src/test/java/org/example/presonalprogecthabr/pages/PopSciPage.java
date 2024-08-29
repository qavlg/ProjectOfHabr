package org.example.presonalprogecthabr.pages;

import org.example.presonalprogecthabr.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.presonalprogecthabr.Wait.myWait;

public class PopSciPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));

    WebDriver driver;

    @FindBy(css = "a[href='/en/flows/popsci/']")
    private WebElement popSciElement;

    @FindBy(xpath = "(//span[contains(text(),'Network technologies')])[1]")
    private WebElement networkTechnologiesElement;

    @FindBy(xpath = "//h1//span[contains(text(),'Network technologies')]")
    private WebElement titleNetworkTechnologies;

    @FindBy(xpath = "(//span[contains(text(),'Programming')])[3]")
    private WebElement programmingElement;

    @FindBy(xpath = "//h1//span[contains(text(),'Programming')]")
    private WebElement titleProgramming;

    @FindBy(css = "div > a[href='/en/hubs/infosecurity/']:nth-child(1)")
    private WebElement informationSecurityElement;

    @FindBy(xpath = "//h1//span[contains(text(),'Information Security')]")
    private WebElement titleInformationSecurity;

    @FindBy(css = "a[href='/en/flows/popsci/authors/']")
    private WebElement authorElement;

    @FindBy(css = "a[href='/en/flows/popsci/authors/page2/']:first-child")
    private WebElement changeSecondPageElement;

    @FindBy(css = "a[href='/en/flows/popsci/authors/page3/']:first-child")
    private WebElement changeThirdPageElement;

    @FindBy(css = "a[href='/en/flows/popsci/authors/page4/']:first-child")
    private WebElement changeFourthPageElement;

    @FindBy(css = "a[href='/en/flows/popsci/authors/page5/']:first-child")
    private WebElement changeFifthPageElement;

    @FindBy(css = "button[data-test-id='nav-filters-button']")
    private WebElement dropDownListButton;

    @FindBy(xpath = "//button[contains(text(),'Top')]")
    private WebElement topButton;

    @FindBy(xpath = "//button[contains(text(),'All time')]")
    private WebElement allTimeButton;

    @FindBy(css = "button[class='btn btn_solid btn_small tm-navigation-filters__apply']")
    private WebElement applyButton;

    @FindBy(xpath = "//button[contains(text(),'Best of all time')]")
    private WebElement nameOfElementBestOfAllTime;

    public void clickPopSciElement() {
        popSciElement.click();
        LOG.info("Click on the PopSci element");
    }

    public void clickNetworkTechnologiesElement() {
        networkTechnologiesElement.click();
        LOG.info("Click on the Network technologies element");
    }

    public String checkTitleNetworkTechnologies() {
        myWait(5).visible(titleNetworkTechnologies);
        LOG.infoWithScreenshot("Check if the title 'Network technologies' is correct");
        return titleNetworkTechnologies.getText();
    }

    public void clickProgrammingElement() {
        programmingElement.click();
        LOG.info("Click on the Programming element");
    }

    public String checkTitleProgramming() {
        myWait(5).visible(titleProgramming);
        LOG.infoWithScreenshot("Check if the title 'Programming' is correct");
        return titleProgramming.getText();
    }

    public void clickInformationSecurityElement() {
        informationSecurityElement.click();
        LOG.info("Click on the Information security element");
    }

    public String checkTitleInformationSecurity() {
        myWait(5).visible(titleInformationSecurity);
        LOG.infoWithScreenshot("Check if the title 'Information Security' is correct");
        return titleInformationSecurity.getText();
    }

    public void clickAuthorElement() {
        authorElement.click();
        LOG.info("Click on the Author element");
    }

    public void clickChangeSecondPageElement() {
        changeSecondPageElement.click();
        LOG.info("Flip the second page");
    }
    public void clickChangeThirdPageElement() {
        changeThirdPageElement.click();
        LOG.info("Flip the third page");
    }

    public void clickChangeFourthPageElement() {
        changeFourthPageElement.click();
        LOG.info("Flip the fourth page");
    }

    public void clickChangeFifthPageElement() {
        changeFifthPageElement.click();
        LOG.info("Flip the fifth page");
    }

    public void clickDropDownListButton() {
        dropDownListButton.click();
        LOG.info("Click on the Drop-down list button");
    }

    public void clickTopButton() {
        topButton.click();
        LOG.info("Click on the Top button");
    }

    public void clickAllTimeButton() {
        allTimeButton.click();
        LOG.info("Click on the All time button");
    }

    public void clickApplyButton() {
        applyButton.click();
        driver.navigate().refresh();
        LOG.info("Click on the Apply button");
    }

    public String checkTitleBestOfAllTimeButton() {
        myWait(5).visible(nameOfElementBestOfAllTime);
        LOG.infoWithScreenshot("Check if the name of the 'Best of all time' element is correct");
        return nameOfElementBestOfAllTime.getText();
    }

    public PopSciPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}