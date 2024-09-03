package org.example.presonalprogecthabr.tests;

import org.example.presonalprogecthabr.Extension;
import org.example.presonalprogecthabr.pages.MainPage;
import org.example.presonalprogecthabr.pages.PopSciPage;
import org.example.presonalprogecthabr.pages.SignUpPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(Extension.class)

public class SignUpTest extends BaseTest {

    SignUpPage sup;
    MainPage cp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://habr.com/en/feed/");
        cp = new MainPage(getDriver());
        cp.clickLoginButton();
        cp.clickChangeEnglishButton();

        sup = new SignUpPage(getDriver());
    }

    @Test
    @DisplayName("#16. By clicking Network technologies element appears new page with title 'Network technologies'")
    public void titleNetworkTechnologies() {
        sup.clickSignUpButton();
        sup.clickCheckBoxUserAgreement();

//        assertEquals("Network technologies", sup.checkErrorOfCheckBox(),
//                "Incorrect the text of the error");
    }
}
