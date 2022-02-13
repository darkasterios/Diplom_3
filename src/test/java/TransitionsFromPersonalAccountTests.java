import com.AccountProfile;
import com.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class TransitionsFromPersonalAccountTests {


    @DisplayName("Проверка перехода из личного кабинета на главную страницу через логотип")
    @Description("Проверка перехода из личного кабинета на главную страницу через логотип stellar burger")
    @Test
    public void goToStellarBurgersLogoFromPersonalAreaTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.stellarBurgersLogoClick();
        assertTrue("Переход на главную страницу по логотипу сайта после авторизации не выполняется",
                mainPage.isCreateBurgerTextVisible());
    }

    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    @Description("Проверка перехода из личного кабинета в конструктор")
    @Test
    public void goToConstructorFromPersonalAreaTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.personalAreaClick();
        AccountProfile accountProfile = open(AccountProfile.PROFILE_URL, AccountProfile.class);
        accountProfile.constructorButtonClick();
        assertTrue("Переход в раздел констор из личного кабинета после авторизации не выполняется",
                mainPage.isCreateBurgerTextVisible());
    }
}
