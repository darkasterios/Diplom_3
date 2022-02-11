import com.AccountProfile;
import com.LoginPage;
import com.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.open;


public class ExitTest {

    @DisplayName("Выход из личного кабинета")
    @Description("Выход из личного кабинета авторизовавшегося пользователя")
    @Test
    public void logInWithMainPageSignInButtonTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        mainPage.modalWindowExitButtonClick();
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.exitButtonClick();
        assertTrue("Выход из личного кабинета не выполняется",loginPage.toComeInIsDispayed());
    }
}
