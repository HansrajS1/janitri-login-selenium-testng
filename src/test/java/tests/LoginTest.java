package tests;

import com.janitri.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://dev-dash.janitri.in/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testPasswordMaskedbutton() {
        loginPage.enterPassword("randompass");
        String typeBefore = loginPage.getPasswordFieldType();
        loginPage.togglePasswordVisibility();
        String typeAfter = loginPage.getPasswordFieldType();
        assertNotEquals(typeBefore, typeAfter);
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        loginPage.enterUserId("invalid@example.com");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();
    }

    @Test
    public void testLoginButtonDisabledWhenFieldAreEmpty() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("button[type='submit'], .login-button-class")
        ));

        loginBtn.click();

        boolean isErrorDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".invalid-credential-div")
        )).isDisplayed();

        Assert.assertTrue(isErrorDisplayed, "Expected 'Invalid Credentials' message when fields are empty");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
