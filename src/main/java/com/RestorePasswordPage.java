package com;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class RestorePasswordPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.CLASS_NAME,using = "Auth_link__1fOlj")
    private SelenideElement logInButton;

    @Step("Нажать на кнопку Войти")
    public void logInButtonClick(){
        logInButton.shouldBe(visible).click();
    }
}
