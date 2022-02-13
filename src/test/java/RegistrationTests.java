import com.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTests {
    String email;
    String password;
    String token;

    @After
    public void deleteUser(){
        UserCredentials user = new UserCredentials(email, password);
        UserOperations userOperations = new UserOperations();
        token = userOperations.loginUser(user).extract().path("accessToken");
        if (token != null)
        userOperations.deleteUser(token.substring(7));
    }

    @DisplayName("Регистрация пользователя с валидными значения")
    @Description("Регистрация пользователя.Позитивная проверка")
    @Test
    public void registrationTest(){
        MainPage mainPage = open(MainPage.BASE_URL,MainPage.class);
        mainPage.personalAreaClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.registerButtonClick();
        RegisterPage registerPage = open(RegisterPage.REGISTER_URL, RegisterPage.class);
        registerPage.setName(UserDataCreating.getName());
        email = UserDataCreating.getEmail();
        password = UserDataCreating.getPassword();
        registerPage.setEmailField(email);
        registerPage.setPassword(password);
        registerPage.registerButtonClick();
        assertTrue("Регистрация пользователя с валидными значениями не производится",
                loginPage.toComeInIsDispayed());
    }

    @DisplayName("Регистрация пользователя с невалидным паролем (5 символов)(согл. требованиям мин. 6)")
    @Description("Регистрация пользователя.Негативная проверка")
    @Test
    public void registrationWithInvalidPasswordTest(){
        MainPage mainPage = open(MainPage.BASE_URL,MainPage.class);
        mainPage.personalAreaClick();
        LoginPage loginPage = open(LoginPage.LOGIN_PAGE, LoginPage.class);
        loginPage.registerButtonClick();
        RegisterPage registerPage = open(RegisterPage.REGISTER_URL, RegisterPage.class);
        registerPage.setName(UserDataCreating.getName());
        registerPage.setEmailField(UserDataCreating.getEmail());
        registerPage.setPassword(UserDataCreating.getInvalidPassword());
        registerPage.registerButtonClick();
        assertTrue("Регистрация пользователя с невалидным паролем успешно выполняется",
                registerPage.invalidPasswordMessageIsVisible());
    }
}
