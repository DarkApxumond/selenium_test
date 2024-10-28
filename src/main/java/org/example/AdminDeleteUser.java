package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminDeleteUser {
    private WebDriver driver;
    public AdminDeleteUser(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@class='ant-btn']")
    private WebElement rosbankButton;


}
