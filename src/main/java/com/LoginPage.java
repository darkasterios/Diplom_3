package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    public static final String LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH,using = ".//h2[contains(text(),'Вход')]")
    private SelenideElement toСomеInText;

    @FindBy(how = How.NAME,using = "name")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = ".//input[@name=\"Пароль\"]")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = ".//button[contains(text(),'Войти')]")
    private SelenideElement logInButton;

    public void registerButtonClick(){
        registerButton.shouldBe(visible).scrollTo().click();
    }

    public boolean toComeInIsDispayed(){
        return toСomеInText.shouldBe(visible).isDisplayed();
    }

    public void setPassword(String password){
        passwordField.shouldBe(visible).setValue(password);
    }

    public void setEmail(String name){
        emailField.setValue(name);
    }

    public void logInButtonClick(){
        logInButton.shouldBe(visible).scrollTo().click();
    }

}
