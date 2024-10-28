package org.example;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminDeleteUser {
    private WebDriver driver;
    public AdminDeleteUser(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//span[text()=' Войти в систему ']/ancestor::button")
    private WebElement submitButton;
    @FindBy(xpath = "//a[@href='/user-management']")
    private WebElement userManagement;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputSearch;
    @FindBy(xpath = "//tbody/tr[1]")
    private WebElement clickUser;
    @FindBy(xpath = "//span[text()=' Удалить ']/ancestor::button")
    private WebElement buttonDelete;
    @FindBy(xpath = "//span[text()=' Подтвердить ']/ancestor::button")
    private WebElement buttonDeleteAccept;


    public AdminDeleteUser autorizationAdmin (String email, String password){
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        submitButton.click();
        return this;
    }

    public AdminDeleteUser deleteUserAdmin (String searchuser){
        userManagement.click();
        inputSearch.sendKeys(searchuser);
        inputSearch.sendKeys(Keys.ENTER);
        clickUser.click();
        buttonDelete.click();
        buttonDeleteAccept.click();
        return this;
    }

    public AdminDeleteUser deleteUser (){
        this.autorizationAdmin("test@admin.local", "atomyze@admin");
        this.deleteUserAdmin("79999971000");
        return new AdminDeleteUser(driver);
    }







}
