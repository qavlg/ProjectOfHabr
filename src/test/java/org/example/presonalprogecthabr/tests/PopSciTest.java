package org.example.presonalprogecthabr.tests;


import org.example.presonalprogecthabr.Extension;
import org.example.presonalprogecthabr.pages.MainPage;
import org.example.presonalprogecthabr.pages.PopSciPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(Extension.class)

public class  PopSciTest extends BaseTest {

    PopSciPage psp;
    MainPage cp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://habr.com/ru/feed/");
        cp = new MainPage(getDriver());
        psp = new PopSciPage(getDriver());

        cp.clickSettingsButton();
        cp.clickEnglishCheckBox();
        cp.clickSaveSettingsButton();
        psp.clickPopSciElement();
    }

    @Test
    @DisplayName("#6. By clicking Network technologies element appears new page with title 'Network technologies'")
    public void titleNetworkTechnologies() {
        psp.clickNetworkTechnologiesElement();

        assertEquals("Network technologies", psp.checkTitleNetworkTechnologies(),
                "Incorrect title");
    }

    @Test
    @DisplayName("#7. By clicking Programming element appears new page with title 'Programming'")
    public void titleProgramming() {
        psp.clickProgrammingElement();

        assertEquals("Programming", psp.checkTitleProgramming(),
                "Incorrect title");
    }

    @Test
    @DisplayName("#8. By clicking Programming element appears new page with title 'Programming' and the right link")
    public void titleInformationSecurity() {
        psp.clickInformationSecurityElement();

        LOG.infoWithScreenshot("Check if the link in the 'Information Security' is correct");
        String currentUrl = getDriver().getCurrentUrl();

        assertAll("Check two conditions",
                () -> assertEquals("Information Security", psp.checkTitleInformationSecurity(),
                "Incorrect title"),
                () -> assertEquals("https://habr.com/en/hubs/infosecurity/articles/",
                currentUrl, "Current url is wrong")
                );
    }

    @Test
    @DisplayName("#9. ")
    public void changePagesInAuthorSection() {
        psp.clickAuthorElement();
        psp.clickChangeSecondPageElement();
        psp.clickChangeThirdPageElement();
        psp.clickChangeFourthPageElement();
        psp.clickChangeFifthPageElement();

        LOG.infoWithScreenshot("Check if the link in the 'Information Security' is correct");
        String currentUrl = getDriver().getCurrentUrl();

        assertAll("Check two conditions",
                () -> assertEquals("https://habr.com/en/hubs/infosecurity/articles/",
                        currentUrl, "Current url is wrong"),
                () -> assertEquals("https://habr.com/en/hubs/infosecurity/articles/",
                        currentUrl, "Current url is wrong"),
                () -> assertEquals("https://habr.com/en/hubs/infosecurity/articles/",
                        currentUrl, "Current url is wrong"),
                () -> assertEquals("https://habr.com/en/hubs/infosecurity/articles/",
                        currentUrl, "Current url is wrong")
        );
    }

    @Test
    @DisplayName("#10. ")
    public void nameOfDropDownList() {
        psp.clickDropDownListButton();
        psp.clickTopButton();
        psp.clickAllTimeButton();
        psp.clickApplyButton();

        assertEquals("All time", psp.checkTitleBestOfAllTimeButton(),
                "Incorrect title");
    }
}
