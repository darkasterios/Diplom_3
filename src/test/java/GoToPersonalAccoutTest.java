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

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

public class GoToPersonalAccoutTest {
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

    @DisplayName("Переход в личный кабинет после авторизации")
    @Description("Проверка просмотра личного кабинета после авторизации")
    @Step("Проверка возможности вхождения в личный кабинет после авторизации")
    @Test
    public void goToPersonalAreaAfterAuthorizationTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        sleep(55);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        mainPage.modalWindowExitButtonClick();
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        assertTrue("Переход в личный кабиент с авторизаций не выполняется ",accountProfile.isProfileFieldTextVisible());
        mainPage.personalAreaClick();
        accountProfile.exitButtonClick();
        sleep(10);
    }

}
