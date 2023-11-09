package com.juaracoding.pages;

import com.juaracoding.Driver.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //Locator

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement username;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")
    private WebElement buttonLogin;



    @FindBy(xpath = "/html/body/div[1]/header/div[1]/div/ul[2]/li[2]/a")
    private WebElement profile;

    @FindBy(xpath = "/html/body/div[1]/div[2]/main/article/div/div/div/p[1]/a")
    private WebElement logOut;

    @FindBy(xpath = "/html/body/div[1]/div[2]/main/article/div/div/div/p[1]")
    private WebElement txtDashboard;

    @FindBy(xpath = ("/html/body/div[1]/div[2]/main/article/div/div/div[1]/ul/li/strong"))
    private WebElement txtInvalid;

    @FindBy(xpath = ("//*[@id=\"post-8\"]/div/div/div[1]/ul/li"))
    private WebElement requiredPassword;
    //
    @FindBy(xpath = ("/html/body/div[1]/div[2]/main/article/div/div/div[1]/ul/li"))
    private WebElement requiredUsername;

    @FindBy(xpath = ("/html/body/p/a"))
    private WebElement dismis;


    public void login() {
        username.sendKeys("Adam Denta Ramadhan");
        password.sendKeys("#Adamdenta18");
        buttonLogin.click();
    }

    public void loginForm(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        buttonLogin.click();
    }

    public void inputUsername(String username) {
        this.username.sendKeys(username);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickbuttonLogin() {
        buttonLogin.click();
    }

    public void logOutAcount() {
//        dismis.click();
        profile.click();
        logOut.click();
    }
    public void profile(){
        profile.click();
    }

    public void logOut() {
        logOut.click();
    }

    public String getTxtDashboard() {
        return txtDashboard.getText();
    }

    public String getTxtInvalid() {
        return txtInvalid.getText();
    }

    //
    public String getrequiredPassword() {
        return requiredPassword.getText();
    }

    //
    public String getrequiredUsername() {
        return requiredUsername.getText();
    }

    public void ClearUsername() {
        username.sendKeys(Keys.CONTROL + "a");
        username.sendKeys(Keys.DELETE);

    }

    public void ClearPassword() {
        password.sendKeys(Keys.CONTROL + "a");
        password.sendKeys(Keys.DELETE);
    }
}
