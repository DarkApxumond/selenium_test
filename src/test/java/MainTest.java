import org.example.AutorizationB2C;
import org.example.ForgotPasswordPage;
import org.junit.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MainTest {
    private WebDriver driver;
    private AutorizationB2C autorizationB2C;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1980, 1020));
        driver.get("https://atm-front.demo.atomyze.ru/login/b2c");
        autorizationB2C = new AutorizationB2C(driver);
    }

    @Test
    public void pagePassword(){
        ForgotPasswordPage forgotPasswordPage = autorizationB2C.clickForgotPassword();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
