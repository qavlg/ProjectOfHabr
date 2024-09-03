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
        getDriver().get("https://habr.com/en/feed/");
        cp = new MainPage(getDriver());
        cp.clickPopSciElement();

        psp = new PopSciPage(getDriver());
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
    @DisplayName("#8. By clicking Information Security element appears new page with title 'Information Security' and the accurate link")
    public void titleInformationSecurity() {
        psp.clickInformationSecurityElement();

        LOG.infoWithScreenshot("Check if the link in the 'Information Security' page is correct");
        String currentUrl = getDriver().getCurrentUrl();

        assertAll("Check two conditions",
                () -> assertEquals("Information Security", psp.checkTitleInformationSecurity(),
                "Incorrect title"),
                () -> assertEquals("https://habr.com/en/hubs/infosecurity/articles/",
                currentUrl, "Current url is wrong")
                );
    }

    @Test
    @DisplayName("#9. In the section Author all five pages are clickable")
    public void changePagesInAuthorSection() {
        psp.clickAuthorElement();

        psp.clickChangeSecondPageElement();
        LOG.infoWithScreenshot("Check if the link in the second page is correct");
        assertEquals("https://habr.com/en/flows/popsci/authors/page2/",
                getDriver().getCurrentUrl(),
                "Url on the second page is wrong");

        psp.clickChangeThirdPageElement();
        LOG.infoWithScreenshot("Check if the link in the third page is correct");
        assertEquals("https://habr.com/en/flows/popsci/authors/page3/",
                getDriver().getCurrentUrl(),
                "Url on the third page is wrong");

        psp.clickChangeFourthPageElement();
        LOG.infoWithScreenshot("Check if the link in the fourth page is correct");
        assertEquals("https://habr.com/en/flows/popsci/authors/page4/",
                getDriver().getCurrentUrl(),
                "Url on the fourth page is wrong");

        psp.clickChangeFifthPageElement();
        LOG.infoWithScreenshot("Check if the link in the fifth page is correct");
        assertEquals("https://habr.com/en/flows/popsci/authors/page5/",
                getDriver().getCurrentUrl(),
                "Url on the fifth page is wrong");
    }

    @Test
    @DisplayName("#10. It is possible to sort the articles by Best of all time")
    public void nameOfDropDownList() {
        psp.clickDropDownListButton();
        psp.clickTopButton();
        psp.clickAllTimeButton();
        psp.clickApplyButton();

        assertEquals("Best of all time", psp.checkTitleBestOfAllTimeButton(),
                "Incorrect title");
    }
}
