import com.MainPage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

public class ConstructorTests {

    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("D:\\Yandex\\YandexBrowser\\Application\\browser.exe");
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
    }

    @AfterClass
    public static void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }

    @DisplayName("Переход в раздел Начинки")
    @Description("Проверка перехода в раздел Начинки")
    @Step("Проверка на предмет скролла страницы к эллементам начинки при нажатии на раздел Начинки")
    @Test
    public void isTransitionFillingSectionWorksTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.fillingsButtonClick();
        assertTrue("Эллемент раздела Начинки не виден при переходе в раздел Начинки",
                mainPage.isBeefMeteoriteChopVisible());
    }

    @DisplayName("Переход в раздел Булки")
    @Description("Проверка перехода в раздел Булки")
    @Step("Проверка на предмет скролла страницы к эллементам Булок при нажатии на раздел Булки")
    @Test
    public void isTransitionToBunSectionWorksTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.fillingsButtonClick();
        mainPage.bunsButtonClick();
        assertTrue("Эллемент раздела Булки не виден при переходе в раздел Булки",
                mainPage.isFluorescentBunVisible());
    }

    @DisplayName("Переход в раздел Соусы")
    @Description("Проверка перехода в раздел Соусы")
    @Step("Проверка на предмет скролла страницы к эллементам соусов при нажатии на раздел Соусы")
    @Test
    public void isTransitionToSauceSectionWorksTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.saucesButtonClick();
        assertTrue("Эллемент раздела Соусы не виден при переходе в раздел Соусы",
                mainPage.isSauceSpicyXVisible());
    }
}
