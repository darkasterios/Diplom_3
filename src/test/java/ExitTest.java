import com.AccountProfile;
import com.LoginPage;
import com.MainPage;
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

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class ExitTest {
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

    @DisplayName("Выход из личного кабинета")
    @Description("Выход из личного кабинета авторизовавшегося пользователя")
    @Step("Проверка возможности выхода из личного кабинета после авторизации пользователя")
    @Test
    public void logInWithMainPageSignInButtonTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        assertTrue(mainPage.isMakeOrderButtonDispayed());
        mainPage.modalWindowExitButtonClick();
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.exitButtonClick();
        assertTrue("Выход из личного кабинета не выпоняется",loginPage.toComeInIsDispayed());
        sleep(10);
    }
}
