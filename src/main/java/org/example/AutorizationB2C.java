package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Expression;
import java.time.Duration;

public class AutorizationB2C {
    private WebDriver driver;

    public AutorizationB2C(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement numberPhoneB2C;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordB2C;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//a[text()='Зарегистрироваться']")
    private WebElement registration;
    @FindBy(xpath = "//a[@href='/login/b2c/reset']")
    private WebElement forgotPassword;
    @FindBy(xpath = "//span[text()=' Для юридических лиц ']")
    private WebElement pageB2B;
    @FindBy(xpath = "//h2[text()='Вход в личный кабинет Atomyze']")
    private WebElement textB2C;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement confirmCode;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement confirmCodeButton;

    public RegistrationPage clickRegistration(){
        registration.click();
        return new RegistrationPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword(){
        if (forgotPassword != null) {
            forgotPassword.click();
        } else {
            System.out.println("Element forgotPassword is null");
        }
            forgotPassword.click();
            return new ForgotPasswordPage(driver);
    }

    public void buttonSubmit(){
        buttonSubmit.click();
    }

    public AutorizationB2C typeNumberPhone (String numberphone){
        numberPhoneB2C.sendKeys(numberphone);
        return this;
    }

    public AutorizationB2C typePassword (String password){
        passwordB2C.sendKeys(password);
        return this;
    }

    public AutorizationB2C confirmCode (String numberCode){
        confirmCode.sendKeys("000000");
        confirmCodeButton.click();
        return this;
    }

    public AutorizationB2C autorization (String numberphone, String password){
        this.typeNumberPhone(numberphone);
        this.typePassword(password);
        this.buttonSubmit();
        this.confirmCode("000000");
        return new AutorizationB2C(driver);
    }

    public String getText(){
        return textB2C.getText();
    }





}
