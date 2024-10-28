package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1980, 1020));
        driver.get("https://atm-front.demo.atomyze.ru/login/b2c");

        //AutorizationB2C autorization = new AutorizationB2C(driver);
        //AutorizationB2C autorizationB2C = PageFactory.initElements(driver,AutorizationB2C.class);
        //autorizationB2C.clickRegistration();
        //RegistrationPage registrationB2C  = PageFactory.initElements(driver,RegistrationPage.class);
        //registrationB2C.registrationB2C("+7 (977) 345-34-52", "1", "2","3","4","5","6", "Qwerty_12345", "Qwerty_12345", "79773453452@mail.ru", "674656051695", "C:\\Users\\eldar\\Documents\\screen1.png");

        AdminDeleteUser deleteUserNow = PageFactory.initElements(driver, AdminDeleteUser.class);
        deleteUserNow.deleteUser();






    }

}