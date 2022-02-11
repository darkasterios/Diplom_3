import com.MainPage;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;


import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class ConstructorTests {

    @DisplayName("Переход в раздел Начинки")
    @Description("Проверка перехода в раздел Начинки")
    @Test
    public void isTransitionFillingSectionWorksTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.fillingsButtonClick();
        assertTrue("Эллемент раздела Начинки не виден при переходе в раздел Начинки",
                mainPage.isBeefMeteoriteChopVisible());
    }

    @DisplayName("Переход в раздел Булки")
    @Description("Проверка перехода в раздел Булки")
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
    @Test
    public void isTransitionToSauceSectionWorksTest() {
        MainPage mainPage = open(MainPage.BASE_URL, MainPage.class);
        mainPage.saucesButtonClick();
        assertTrue("Эллемент раздела Соусы не виден при переходе в раздел Соусы",
                mainPage.isSauceSpicyXVisible());
    }
}
