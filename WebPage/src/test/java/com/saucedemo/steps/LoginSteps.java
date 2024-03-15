package com.saucedemo.steps;

import com.saucedemo.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeUser(String user){
        System.out.printf("Nombre del usuario: " +user);
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
    }
    public void typePassword(String password){
        System.out.println(" Password: " +password);
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }
    public void login(){
        this.driver.findElement(LoginPage.loginButton).click();
    }

}
