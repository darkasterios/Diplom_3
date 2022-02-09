package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountProfile {
    public static final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account";

    @FindBy(how = How.XPATH,using = ".//button[contains(text(),'Выход')]")
    private SelenideElement exitButton;

    @FindBy(how = How.XPATH,using = ".//a[contains(text(),'Профиль')]")
    private SelenideElement profileFieldText;

    @FindBy(how = How.XPATH,using = ".//p[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;

    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgersLogo;

    public void constructorButtonClick(){
        constructorButton.click();
    }

    public void exitButtonClick(){
        exitButton.click();
    }

    public boolean isProfileFieldTextVisible(){
        return profileFieldText.shouldBe(Condition.visible).isDisplayed();
    }

    public void stellarBurgersLogoClick(){
        stellarBurgersLogo.click();
    }
}
