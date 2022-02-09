import com.LoginPage;
import com.MainPage;
import com.RegisterPage;
import com.UserDataCreating;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

public class RegistrationTests {

    @BeforeClass
    public static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setBinary("D:\\Yandex\\YandexBrowser\\Application\\browser.exe");
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
    }

    @AfterClass
    public static void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @DisplayName("Регистрация пользователя с валидными значения")
    @Description("Регистрация пользователя.Позитивная проверка")
    @Step("Проверка возможности зарегистроровать пользователя с валидными значениями согласно требованиям")
    @Test
    public void registrationTest(){
        MainPage mainPage = open(MainPage.BASE_URL,MainPage.class);
        mainPage.personalAreaClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.registerButtonClick();
        RegisterPage registerPage = open(RegisterPage.REGISTER_URL, RegisterPage.class);
        registerPage.setName(UserDataCreating.getName());
        registerPage.setEmailField(UserDataCreating.getEmail());
        registerPage.setPassword(UserDataCreating.getPassword());
        registerPage.registerButtonClick();
        assertTrue("Регистрация пользователя с валидными значениями не производится",
                loginPage.toComeInIsDispayed());
    }

    @DisplayName("Регистрация пользователя с невалидным паролем")
    @Description("Регистрация пользователя.Негативная проверка")
    @Step("Проверка невозможности зарегистроровать пользователя с невалидным паролем (5 символов)(согл. требованиям мин. 6)")
    @Test
    public void registrationWithInvalidPasswordTest(){
        MainPage mainPage = open(MainPage.BASE_URL,MainPage.class);
        mainPage.personalAreaClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.registerButtonClick();
        RegisterPage registerPage = open(RegisterPage.REGISTER_URL, RegisterPage.class);
        registerPage.setName(UserDataCreating.getName());
        registerPage.setEmailField(UserDataCreating.getEmail());
        registerPage.setPassword(UserDataCreating.getInvalidPassword());
        registerPage.registerButtonClick();
        assertTrue("Регистрация пользователя с невалидным паролем успешно выполняется",
                registerPage.invalidPasswordMessageIsVisible());
    }

}
