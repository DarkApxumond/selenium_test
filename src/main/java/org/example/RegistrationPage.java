package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@class='ant-btn']")
    private WebElement rosbankButton;
    @FindBy(xpath = "//img[@src='/assets/images/logo.svg']")
    private WebElement backToPageAutorization;
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
    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement enterEmail;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement selectCheckboxAgreementOne;
    @FindBy(xpath = "//span[text()=' Продолжить ']/ancestor::button")
    private WebElement buttonNext;
    @FindBy(xpath = "//nz-form-control/div/div/input")
    private WebElement enterINN;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement documentINN;
    @FindBy(xpath = "(//span[@class='ant-checkbox'])[4]")
    private WebElement selectCheckboxAgreementTwo;
    @FindBy(xpath = "//button[@id='details-button']")
    private WebElement detailsButton;
    @FindBy(xpath = "//a[@id='proceed-link']")
    private WebElement proceedLink;
    @FindBy(xpath = "//div[@class='ant-progress-bg']")
    private WebElement uploadSucces;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmit;




    public AutorizationB2C clickAutorizationB2C(){
        backToPageAutorization.click();
        return new AutorizationB2C(driver);
    }

    public void clickRosbank(){
        rosbankButton.click();
    }

    public RegistrationPage StatePage(){
        detailsButton.click();
        proceedLink.click();
        return this;
    }

    public RegistrationPage rosbankPage(String phonenumberrosbank, String numbercode1, String numbercode2, String numbercode3, String numbercode4, String numbercode5, String numbercode6){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

    public RegistrationPage selectPassword(String newpassword, String confirmnewpassword){
        inputNewPassword.sendKeys(newpassword);
        inputConfirmNewPassword.sendKeys(confirmnewpassword);
        confirmPasswordButton.click();
        return this;
    }

    public RegistrationPage registrationAnketa(String email){
        enterEmail.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        enterEmail.sendKeys(email);
        selectCheckboxAgreementOne.click();
        buttonNext.click();
        return this;
    }

    public RegistrationPage registrationAdditionalInformation (String inn, String documentinn){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        enterINN.sendKeys(inn);
        documentINN.sendKeys(documentinn);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//nz-upload")));
        selectCheckboxAgreementTwo.click();
        buttonNext.click();
        return this;
    }

    public RegistrationPage registrationB2C(String phonenumberrosbank, String numbercode1, String numbercode2, String numbercode3, String numbercode4, String numbercode5, String numbercode6, String newpassword, String confirmnewpassword, String email, String inn, String documentinn){
        this.clickRosbank();
        this.StatePage();
        this.rosbankPage("+7 (977) 345-34-52", "1", "2","3","4","5","6");
        this.selectPassword("Qwerty_12345", "Qwerty_12345");
        this.registrationAnketa("79773453452@mail.ru");
        this.registrationAdditionalInformation("674656051695", "C:\\Users\\eldar\\Documents\\screen1.png");
        return new RegistrationPage(driver);
    }






}
