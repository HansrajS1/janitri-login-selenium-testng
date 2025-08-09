package com.janitri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[text()='User ID']/following-sibling::div/input")
    private WebElement userIdInput;

    @FindBy(xpath = "//label[text()='Password']/following-sibling::div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Log In')]")
    private WebElement loginButton;

    @FindBy(xpath = "//img[contains(@src,'Unhide.svg') or contains(@src,'Hide.svg')]")
    private WebElement passwordToggleIcon;


    public void enterUserId(String userId) {
        wait.until(ExpectedConditions.visibilityOf(userIdInput)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
    }

    public String getPasswordFieldType() {
        return passwordInput.getAttribute("type");
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void togglePasswordVisibility() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//img[contains(@src,'Unhide.svg') or contains(@src,'Hide.svg')]")
        ));
        wait.until(ExpectedConditions.elementToBeClickable(passwordToggleIcon)).click();
    }

}
