import com.AccountProfile;
import com.LoginPage;
import com.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class GoToPersonalAccoutTest {

    @Step("Выход из аккаунта после теста")
    @After
    public void tearDown(){
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.exitButtonClick();
    }

    @DisplayName("Переход в личный кабинет после авторизации")
    @Description("Проверка просмотра личного кабинета после авторизации")
    @Test
    public void goToPersonalAreaAfterAuthorizationTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.logInButtonClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.setEmail("Router@yandex.ru");
        loginPage.setPassword("Router");
        loginPage.logInButtonClick();
        mainPage.modalWindowExitButtonClick();
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        assertTrue("Переход в личный кабиент с авторизаций не выполняется ",accountProfile.isProfileFieldTextVisible());
    }

}
