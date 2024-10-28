package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonForgotPassword;
    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement backToPageAutorization;
    @FindBy(xpath = "//div[text()='Телефон введен некорректно, либо такого пользователя не существует']")
    private WebElement alertText;
    @FindBy(xpath = "//button[@id='details-button']")
    private WebElement detailsButton;
    @FindBy(xpath = "//a[@id='proceed-link']")
    private WebElement proceedLink;
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement inputPhone;
    @FindBy(xpath = "//label[@class='checkbox']")
    private WebElement checkBox;
    @FindBy(xpath = "//span[text()='Далее']")
    private WebElement nextPage;
    @FindBy(xpath = "//input[@name='code1']")
    private WebElement inputcode1;
    @FindBy(xpath = "//input[@name='code2']")
    private WebElement inputcode2;
    @FindBy(xpath = "//input[@name='code3']")
    private WebElement inputcode3;
    @FindBy(xpath = "//input[@name='code4']")
    private WebElement inputcode4;
    @FindBy(xpath = "//input[@name='code5']")
    private WebElement inputcode5;
    @FindBy(xpath = "//input[@name='code6']")
    private WebElement inputcode6;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement inputNewPassword;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement inputConfirmNewPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement confirmPasswordButton;
    @FindBy(xpath = "//span[text()=' Выйти ']/ancestor::button")
    private WebElement buttonExit;


    public AutorizationB2C clickAutorizationB2C(){
        backToPageAutorization.click();
        return new AutorizationB2C(driver);
    }

    public ForgotPasswordPage typePhoneNumber(String phonenumber){
        phoneNumber.sendKeys(phonenumber);
        return this;
    }

    public void clickButtonForgotPassword(){
        buttonForgotPassword.click();
    }

    public ForgotPasswordPage StatePage(){
        detailsButton.click();
        proceedLink.click();
        return this;
    }

    public ForgotPasswordPage rosbankPage(String phonenumberrosbank, String numbercode1, String numbercode2, String numbercode3, String numbercode4, String numbercode5, String numbercode6){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        inputPhone.sendKeys(phonenumberrosbank);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Вход через Росбанк']")));
        checkBox.click();
        nextPage.click();
        inputcode1.sendKeys(numbercode1);
        inputcode2.sendKeys(numbercode2);
        inputcode3.sendKeys(numbercode3);
        inputcode4.sendKeys(numbercode4);
        inputcode5.sendKeys(numbercode5);
        inputcode6.sendKeys(numbercode6);
        return this;
    }

    public ForgotPasswordPage newPassword(String newpassword, String confirmnewpassword){
        inputNewPassword.sendKeys(newpassword);
        inputConfirmNewPassword.sendKeys(confirmnewpassword);
        confirmPasswordButton.click();
        return this;
    }

    public ForgotPasswordPage exit(){
        buttonExit.click();
        return this;
    }


    public ForgotPasswordPage clickForgotPassword(String phonenumber){
        this.typePhoneNumber(phonenumber);
        this.clickButtonForgotPassword();
        this.StatePage();
        this.rosbankPage("+7 (999) 997-10-00", "1", "2", "3", "4", "5", "6");
        this.newPassword("Qwerty_12345", "Qwerty_12345");
        this.exit();
        return new ForgotPasswordPage(driver);
    }

    public String getAlertText(){
        System.out.println("Телефон введен некорректно, либо такого пользователя не существует");
        return alertText.getText();
    }





}
