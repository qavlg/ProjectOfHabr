package org.example.presonalprogecthabr.tests;


import org.example.presonalprogecthabr.Extension;
import org.example.presonalprogecthabr.pages.AdminPage;
import org.example.presonalprogecthabr.pages.MainPage;
import org.example.presonalprogecthabr.pages.PopSciPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Extension.class)

public class AdminTest extends BaseTest {

    AdminPage ap;
    MainPage cp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://habr.com/en/feed/");
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
        assertEquals("", ap.getSearchFieldText(),
                "The text has not been deleted");
    }

    @Test
    @DisplayName("#12. By clicking Admin page appears the title 'Admin'")
    public void titleAdmin() {

        assertEquals("Admin", ap.checkTitleAdmin(),
                "Incorrect title");
    }

    @Test
    @DisplayName("#13. In the Admin page 'Articles', 'Posts', 'News', 'Hubs', 'Authors' elements are clickable")
    public void CheckAdminSection() {

        assertAll("Check five conditions",
                () -> assertTrue(ap.checkAuthorElement(),
                        "The 'Authors' element is not clickable"),
                () -> assertTrue(ap.checkHubsElement(),
                        "The 'Hubs' element is not clickable"),
                () -> assertTrue(ap.checkNewsElement(),
                        "The 'News' element is not clickable"),
                () -> assertTrue(ap.checkPostElement(),
                        "The 'Posts' element is not clickable"),
                () -> assertTrue(ap.checkArticlesElement(),
                        "The 'Articles' element is not clickable")
        );
    }

    @Test
    @DisplayName("#14. It is possible to show News with rating ≥100")
    public void nameOfDropDownList() {
        ap.clickDropDownListButton();
        ap.clickMoreOrEqual100Button();
        ap.clickApplyButton();

        assertEquals("New with rating ≥100", ap.checkTitleNewWithRatingMoreOrEqual100(),
                "Incorrect title");
    }

    @Test
    @DisplayName("#15. In the Hubs section 'Title', 'Rating', 'Subscribers' elements are clickable")
    public void checkHubsSection() {
        ap.clickHubsElement();

        assertAll("Check three conditions",
                () -> assertTrue(ap.checkTitleElement(),
                        "The 'Title' element is not clickable"),
                () -> assertTrue(ap.checkRatingElement(),
                        "The 'Rating' element is not clickable"),
                () -> assertTrue(ap.checkSubscribersElement(),
                        "The 'Subscribers' element is not clickable")
        );
    }
}
