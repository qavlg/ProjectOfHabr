package org.example.presonalprogecthabr.tests;

import org.example.presonalprogecthabr.Extension;
import org.example.presonalprogecthabr.pages.MainPage;
import org.example.presonalprogecthabr.pages.PopSciPage;
import org.example.presonalprogecthabr.pages.SignUpPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

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
        sup.clickSignUpButton();
    }

    @Test
    @DisplayName("#16. By deleting the 'I accept the User agreement' check-box appears the text 'You need to accept the User Agreement' ")
    public void titleNetworkTechnologies() throws InterruptedException {
        sup.clickCheckBoxUserAgreement();

        assertEquals("You need to accept the User Agreement", sup.checkErrorOfCheckBox(),
                "Incorrect the text of the error");
    }

    @Test
    @DisplayName("#17. The Sign Up button will be active after entering the valid data into fields")
    public void sortingByRating() {

        String email = "test@test.com";
        String username = "test1";
        String password = "test_test";
        String repeatedPassword = "test_test";

        sup.inputTextIntoEmailField(email);
        sup.inputTextIntoUsernameField(username);
        sup.inputTextIntoPasswordField(password);
        sup.inputTextIntoRepeatPasswordField(repeatedPassword);

        assertTrue(sup.checkSighUpButton(),
                "The Sign Up button is inactive");
    }

    @Test
    @DisplayName("#18. All the 'sign up with' elements are active and by clicking the 'Login with GitHub' will be opened the page with GitHub")
    public void titleInformationSecurity() {

        assertAll("Check six conditions",
                () ->  assertTrue(sup.checkFacebookButton(),
                        "The facebook button is inactive"),
                () ->  assertTrue(sup.checkVkontakteButton(),
                        "The vkontakte button is inactive"),
                () ->  assertTrue(sup.checkTwitterButton(),
                        "The twitter button is inactive"),
                () ->  assertTrue(sup.checkGitHubButton(),
                        "The gitHub button is inactive"),
                () ->  assertTrue(sup.checkLiveIidButton(),
                        "The liveIid button is inactive"),
                () ->  assertTrue(sup.checkGoogleButton(),
                        "The google button is inactive")
        );

        sup.clickGitHubButton();
        assertEquals("GitHub", sup.checkTitleOfGitHub(),
                "Incorrect title");
    }

    @Test
    @DisplayName("#19. The text 'You need to fill in this field' will appear below 'Email', 'Username', 'Password' fields after deleting the data from the fields")
    public void errorsUnderFields()  {
        String email = "test@test.com";
        String username = "test1";
        String password = "test_test";

        sup.inputTextIntoEmailField(email);
        sup.inputTextIntoUsernameField(username);
        sup.inputTextIntoPasswordField(password);

        sup.clearEmailField();
        sup.clickOutsideOfField();
        assertEquals("You need to fill in this field", sup.checkTextWithError(),
                "Incorrect the text of the error in Email field");

        sup.inputTextIntoEmailField(email);
        sup.clearUsernameField();
        sup.clickOutsideOfField();
        assertEquals("You need to fill in this field", sup.checkTextWithError(),
                "Incorrect the text of the error in Username field");

        sup.inputTextIntoUsernameField(username);
        sup.clearPasswordField();
        sup.clickOutsideOfField();
        assertEquals("You need to fill in this field", sup.checkTextWithError(),
                "Incorrect the text of the error Password field");
    }

    @Test
    @DisplayName("#20. The title 'Registration' is displayed correctly")
    public void titleOfRegistration() {

        assertEquals("Registration", sup.checkTitleOfRegistration(),
                "Incorrect the title");
    }

}
