import com.AccountProfile;
import com.LoginPage;
import com.MainPage;
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

public class TransitionsFromPersonalAccountTests {

    @BeforeClass
    public static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setBinary("D:\\Yandex\\YandexBrowser\\Application\\browser.exe");
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
    }

    @AfterClass
    public static void quitBrowser() {
        WebDriverRunner.getWebDriver().quit();
    }
    @After
    public void tearDown() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.exitButtonClick();
        sleep(10);
    }

    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    @Description("Проверка перехода из личного кабинета в конструктор")
    @Step("Проверка возможности перейти из личного кабинета в раздел конструктор")
    @Test
    public void goToConstructorFromPersonalAreaTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        mainPage.modalWindowExitButtonClick();
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.constructorButtonClick();
        assertTrue("Переход в раздел констор из личного кабинета после авторизации не выполняется",
                mainPage.isCreateBurgerTextVisible());
    }

    @DisplayName("Проверка перехода из личного кабинета на главную страницу через логотип")
    @Description("Проверка перехода из личного кабинета на главную страницу через логотип stellar burger")
    @Step("Проверка возможности перейти из личного кабинета на главную страницу по нажитию на логотип stellar burger")
    @Test
    public void goToStellarBurgersLogoFromPersonalAreaTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        mainPage.modalWindowExitButtonClick();
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.stellarBurgersLogoClick();
        assertTrue("Переход на главную страницу по логотипу сайта после авторизации не выполняется",
                mainPage.isCreateBurgerTextVisible());
    }
}
