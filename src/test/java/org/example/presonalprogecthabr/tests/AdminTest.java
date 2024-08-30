package org.example.presonalprogecthabr.tests;


import org.example.presonalprogecthabr.Extension;
import org.example.presonalprogecthabr.pages.AdminPage;
import org.example.presonalprogecthabr.pages.MainPage;
import org.example.presonalprogecthabr.pages.PopSciPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(Extension.class)

public class AdminTest extends BaseTest {

    AdminPage ap;
    MainPage cp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://habr.com/ru/feed/");
        cp = new MainPage(getDriver());
        ap = new AdminPage(getDriver());

        cp.clickSettingsButton();
        cp.clickEnglishCheckBox();
        cp.clickSaveSettingsButton();
        ap.clickAdminElement();

    }
    @Test
    @DisplayName("#11. The entered text will disappear after clicking the 'Title' element")
    public void searchFieldText() {
        String text = "SQL";

        ap.clickHubsElement();
        ap.inputTextIntoSearchField(text);
        ap.clickTitleElement();

        LOG.infoWithScreenshot("Check if the text has been deleted after clicking the 'Title' element");
        assertEquals("", ap.getSearchFieldText(),"The text has not been deleted");
    }
}
