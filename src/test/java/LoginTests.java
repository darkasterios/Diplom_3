import com.*;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

public class LoginTests {
    @BeforeClass
    public static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setBinary("D:\\Yandex\\YandexBrowser\\Application\\browser.exe");
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
    }
    @AfterClass
    public static void quitBrouser() {
        WebDriverRunner.getWebDriver().quit();
    }
   @After
    public void tearDown() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.exitButtonClick();
        sleep(80);
    }

    @DisplayName("Авторизация пользователя по кнопке Личный кабинет")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Step("Проверка авторизации пользователя с существующей парой email/password по кнопке Личный кабинет")
    @Test
    public void logInWithPersonalAreaButtonTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        assertTrue("Авторизация по кнопке Личный кабинет не произодится",mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
    }

    @DisplayName("Авторизация пользователя по кнопке Войти в аккаунт на главной странице")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Step("Проверка авторизации пользователя с существующей парой email/password по кнопке Войти в аккаунт")
    @Test
    public void logInWithMainPageSignInButtonTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        assertTrue("Авторизация по кнопке Войти в аккаунт не производится",mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
    }

    @DisplayName("Авторизация пользователя по кнопке Войти на странице регистрации")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Step("Проверка авторизации пользователя с существующей парой email/password по кнопке Войти на странице регистрации")
    @Test
    public void logInWithButtonInRegistrationPage(){
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        RegisterPage registerPage = open(RegisterPage.REGISTER_URL,RegisterPage.class);
        registerPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        assertTrue("Авторизация по кнопке Войти на странице регистрации не производится",
                mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
    }

    @DisplayName("Авторизация пользователя по кнопке Войти на странице восстановления пароля")
    @Description("Авторизация пользователя.Позитивная проверка")
    @Step("Проверка авторизации пользователя с существующей парой email/password " +
            "по кнопке Войти на странице восстановления пароля")
    @Test
    public void logInWithRestorePasswordPageTest(){
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        RestorePasswordPage restorePasswordPage = open(RestorePasswordPage.URL, RestorePasswordPage.class);
        restorePasswordPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        assertTrue("Авторизация по кнопке Войти на странице восстановления пароля не производится",
                mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
    }
}


