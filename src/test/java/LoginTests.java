import com.*;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;

import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginTests {

   @Step("Выход из аккаунта после теста")
    @After
    public void tearDown() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.modalWindowExitButtonClick();
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.exitButtonClick();
    }
    
    @DisplayName("Авторизация пользователя по кнопке Личный кабинет")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Test
    public void logInWithPersonalAreaButtonTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        boolean actual = mainPage.isMakeOrderButtonDispayed();
        assertTrue("Авторизация по кнопке Личный кабинет не произодится", actual);
    }

    @DisplayName("Авторизация пользователя по кнопке Войти в аккаунт на главной странице")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Test
    public void logInWithMainPageSignInButtonTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        boolean actual = mainPage.isMakeOrderButtonDispayed();
        assertTrue("Авторизация по кнопке Войти в аккаунт не производится", actual);
    }

    @DisplayName("Авторизация пользователя по кнопке Войти на странице регистрации")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Test
    public void logInWithButtonInRegistrationPage() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        RegisterPage registerPage = open(RegisterPage.REGISTER_URL, RegisterPage.class);
        registerPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        boolean actual =  mainPage.isMakeOrderButtonDispayed();
        assertTrue("Авторизация по кнопке Войти на странице регистрации не производится",
                actual);
    }

    @DisplayName("Авторизация пользователя по кнопке Войти на странице восстановления пароля")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Test
    public void logInWithRestorePasswordPageTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        RestorePasswordPage restorePasswordPage = open(RestorePasswordPage.URL, RestorePasswordPage.class);
        restorePasswordPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        boolean actual = mainPage.isMakeOrderButtonDispayed();
        assertTrue("Авторизация по кнопке Войти на странице восстановления пароля не производится",
                actual);
    }

}


