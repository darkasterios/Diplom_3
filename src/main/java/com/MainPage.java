package com;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.LINK_TEXT,using = "Личный Кабинет")
    private SelenideElement personalArea;

    @FindBy(how = How.XPATH,using = ".//button[@class=\"button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg\"]")
    private SelenideElement logInButton;

    @FindBy(how = How.XPATH,using = ".//button[contains(text(),'Оформить заказ')]")
    private SelenideElement makeOrderButton;

    @FindBy(how = How.XPATH,using = ".//button[@class=\"Modal_modal__close_modified__3V5XS Modal_modal__close__TnseK\"]")
    private SelenideElement modalWindowExitButton;

    @FindBy(how = How.XPATH,using = ".//h1[contains(text(),'Соберите бургер')]")
    private SelenideElement createBurderText;

    @FindBy(how = How.XPATH,using = ".//span[contains(text(),'Булки')]")
    private SelenideElement bunsButton;

    @FindBy(how = How.XPATH,using = ".//span[contains(text(),'Соусы')]")
    private SelenideElement saucesButton;

    @FindBy(how = How.XPATH,using = ".//span[contains(text(),'Начинки')]")
    private SelenideElement fillingsButton;

    @FindBy(how = How.XPATH,using = ".//p[contains(text(),'Говяжий метеорит (отбивная)')]")
    private SelenideElement beefMeteoriteChop;

    @FindBy(how = How.CSS,using = "[alt='Флюоресцентная булка R2-D3']")
    private SelenideElement fluorescentBun;

    @FindBy(how = How.XPATH,using = ".//p[contains(text(),'Соус Spicy-X')]")
    private SelenideElement sauceSpicyX;

    @Step("Нажать на кнопку Личный кабинет")
    public void personalAreaClick(){
        personalArea.shouldBe(visible).scrollTo().click();
    }

    @Step("Нажать на кнопку Войти")
    public void logInButtonClick(){
        logInButton.shouldBe(visible).click();
    }

    @Step("Кнопка Оформить заказа успешно отображается")
    public boolean isMakeOrderButtonDisplayed(){
        return makeOrderButton.shouldBe(visible).isDisplayed();
    }

    @Step("Закрыть модальное окно заказа, в случае если оно всплывает")
    public void modalWindowExitButtonClick(){
        if(modalWindowExitButton.isDisplayed())
            modalWindowExitButton.click();
        personalArea.shouldBe(visible).scrollTo();
    }

    @Step("Текст Собери бургер успешно отображается")
    public boolean isCreateBurgerTextVisible(){
        return createBurderText.shouldBe(visible).isDisplayed();
    }

    @Step("Нажать на кнопку Булки")
    public void bunsButtonClick(){
        bunsButton.shouldBe(visible).click();
    }

    @Step("Нажать на кнопку Соусы")
    public void saucesButtonClick(){
        saucesButton.shouldBe(visible).click();
    }

    @Step("Нажать на кнопку Начинки")
    public void fillingsButtonClick(){
        fillingsButton.shouldBe(visible).click();
    }

    @Step("Эллемент Говяжий метеорит (отбивная) успешно отображается")
    public boolean isBeefMeteoriteChopVisible(){
        return beefMeteoriteChop.is(visible);
    }

    @Step("Эллемент Spicy-X успешно отображается")
    public boolean isSauceSpicyXVisible(){
        return sauceSpicyX.is(visible);
    }

    @Step("Эллемент Флюоресцентная булка R2-D3 успешно отображается")
    public boolean isFluorescentBunVisible(){
        return fluorescentBun.is(visible);
    }

}
