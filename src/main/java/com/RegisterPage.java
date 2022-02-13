package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {
    public static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH,using = "(.//input[@class=\"text input__textfield text_type_main-default\"])[1]")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH,using = "(.//input[@class=\"text input__textfield text_type_main-default\"])[2]")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = ".//input[@class=\"text input__textfield text_type_main-default\"][@type=\"password\"]")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = ".//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH,using = ".//p[@class=\"input__error text_type_main-default\"]")
    private SelenideElement invalidPasswordMessage;

    @FindBy(how = How.XPATH,using = ".//a[contains(text(),'Войти')]")
    private SelenideElement logInButton;

    @Step("Ввод значения в поле Имя")
    public void setName(String name){
       nameField.shouldBe(visible).setValue(name);
    }

    @Step("Ввод значения в поле email")
    public void setEmailField(String email){
        emailField.shouldBe(visible).setValue(email);
    }

    @Step("Ввод значения в поле пароль")
    public void setPassword(String pass){
        passwordField.shouldBe(visible).setValue(pass);
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void registerButtonClick(){
        registerButton.shouldBe(visible).scrollTo().click();
    }

    @Step("Сообщение о невалидном введенном пароле успешно отображается")
    public boolean invalidPasswordMessageIsVisible(){
       return invalidPasswordMessage.shouldBe(visible).isDisplayed();
    }

    @Step("Нажать на кнопку войти")
    public void logInButtonClick(){
        logInButton.click();
    }

}
