package org.example.presonalprogecthabr.tests;

import org.example.presonalprogecthabr.Extension;
import org.example.presonalprogecthabr.pages.CommonPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    @DisplayName("By clicking on the 'English' element in the Login form - the language changes")
    public void titleLogin() {
        cp.clickLoginButton();
        cp.clickChangeEnglishButton();

        assertEquals("Log in", cp.checkTitleLogin(), "Incorrect title");
    }

}
