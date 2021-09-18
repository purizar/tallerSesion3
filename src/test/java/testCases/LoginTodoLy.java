package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.junit.jupiter.api.*;
import pages.Home;
import pages.LoginModal;
import pages.MainPage;
import singletonSession.Session;

public class LoginTodoLy {
    MainPage mainPage= new MainPage();
    LoginModal loginModal = new LoginModal();
    Home home =new Home();

    @BeforeEach
    public void before(){
        Session.getSession().getDriver().get("https://todoist.com/");
    }

    @AfterEach
    public void after(){
        Session.getSession().closeSession();
    }

    @Test
    @DisplayName("Verify the login using correct user and password")
    @Description("this test case si to verify the login")
    @Link("ww.jira.com/TC09990")
    @Issue("BUG8888")
    public void verifyTheLogin(){

        /*mainPage.loginButton.click();
        loginModal.emailTxt.fillText("jbowasp57@jbowasp57.com");
        loginModal.passwordTxt.fillText("12345");
        loginModal.loginButon.click();*/

        // Assertion.assertFalse(loginModal.loginButon.i
        //Assertions.assertFalse(loginModal.loginButon.isControlDisplayed(), "Error");

        mainPage.linkLogin.click();

        loginModal.emailTxt.fillText("ing.melindacastro@gmail.com");
        loginModal.passwordTxt.fillText("merliss1707");
        loginModal.loginButon.click();

        //Assertions.assertTrue(home.listMenu.isControlDisplayed(), "Satisfactorio");
        Assertions.assertFalse(loginModal.loginButon.isControlDisplayed(), "Error");;

    }
}
