package org.example.presonalprogecthabr.tests;

import org.example.presonalprogecthabr.Extension;
import org.example.presonalprogecthabr.pages.CommonPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(Extension.class)

public class CommonTest extends BaseTest {

    CommonPage cp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://habr.com/ru/feed/");
        cp = new CommonPage(getDriver());

        cp.clickSettingsButton();
        cp.clickEnglishCheckBox();
        cp.clickSaveSettingsButton();

    }


    @Test
    @DisplayName("#1. By clicking on the 'English' element in the Login form - the language changes")
    public void titleLogin() {
        cp.clickLoginButton();
        cp.clickChangeEnglishButton();

        assertEquals("Log in", cp.checkTitleLogin(), "Incorrect title");
    }


    @Test
    @DisplayName("#2. In the Publications section the element of 'Sort by rating' is active")
    public void SortingByRating() {

        String text = "QA Automation";
        cp.clickSearchButtonOnMainPage();
        cp.inputTextIntoSearchField(text);
        cp.clickDropDownList();

        assertTrue(cp.checkSortByRatingButton(),"The 'Sort by rating' button is inactive");
    }

}
