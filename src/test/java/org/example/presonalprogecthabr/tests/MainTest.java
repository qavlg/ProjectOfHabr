package org.example.presonalprogecthabr.tests;

import org.example.presonalprogecthabr.Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(Extension.class)

public class MainTest extends BaseTest {

    org.example.presonalprogecthabr.pages.MainPage cp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://habr.com/ru/feed/");
        cp = new org.example.presonalprogecthabr.pages.MainPage(getDriver());

        cp.clickSettingsButton();
        cp.clickEnglishCheckBox();
        cp.clickSaveSettingsButton();
    }

    @Test
    @DisplayName("#1. By clicking on the 'English' element in the Login form - the language changes")
    public void titleLogin() {
        cp.clickLoginButton();
        cp.clickChangeEnglishButton();

        assertEquals("Log in", cp.checkTitleLogin(),
                "Incorrect title");
    }

    @Test
    @DisplayName("#2. In the Publications section the element of 'Sort by rating' is active")
    public void sortingByRating() {

        String text = "QA Automation";
        cp.clickSearchButtonOnMainPage();
        cp.inputTextIntoSearchField(text);
        cp.clickDropDownList();

        assertTrue(cp.checkSortByRatingButton(),
                "The 'Sort by rating' button is inactive");
    }

    @Test
    @DisplayName("#3. In the Publications section the element copy RRS link is active")
    public void copyRrsLink() {

        String text = "QA Manual";
        cp.clickSearchButtonOnMainPage();
        cp.inputTextIntoSearchField(text);

        assertTrue(cp.checkRrsCopyLick(),
                "The element copy RRS link is inactive");
    }

    @Test
    @DisplayName("#4. By clicking 'Read more' element under the first post opens the article")
    public void readMoreIsAvailable() {

        String text = "SimbirSoft";
        cp.clickSearchButtonOnMainPage();
        cp.inputTextIntoSearchField(text);
        cp.clickReadMoreButton(0);

        LOG.infoWithScreenshot("Check if the link in the article is active");
        String currentUrl = getDriver().getCurrentUrl();
        assertEquals("https://habr.com/en/companies/simbirsoft/news/537118/",
                currentUrl, "Current url is wrong");
    }

    @Test
    @DisplayName("#5. In the information there is the title 'Sandox'")
    public void titleSandbox() {
        cp.clickHowBecomeAuthorButton();
        cp.clickWaitingForInvitationElement();
        cp.clickSandboxElement();

        assertEquals("Sandox", cp.checkTitleSandbox(),
                "Incorrect title");
    }
}
