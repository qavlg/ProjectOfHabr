package org.example.presonalprogecthabr.tests;


import org.example.presonalprogecthabr.Extension;
import org.example.presonalprogecthabr.pages.CommonPage;
import org.example.presonalprogecthabr.pages.PopSciPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(Extension.class)

public class  PopSciTest extends BaseTest {

    PopSciPage psp;
    CommonPage cp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://habr.com/ru/feed/");
        cp = new CommonPage(getDriver());
        psp = new PopSciPage(getDriver());


        cp.clickSettingsButton();
        cp.clickEnglishCheckBox();
        cp.clickSaveSettingsButton();
        psp.clickPopSciElement();


    }

    @Test
    @DisplayName("#1. By clicking 'Read more' element under the first post opens the article")
    public void tabCommentsIsAvailable() {
        psp.clickNetworkTechnologiesElement();

        assertEquals("Network technologies", psp.checkTitleNetworkTechnologies(),
                "Incorrect title");
    }



}
