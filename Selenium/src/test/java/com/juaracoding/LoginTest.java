package com.juaracoding;
import com.juaracoding.Driver.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constans;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;


public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance(Constans.CHROME);
        driver = DriverSingleton.getDriver();
//        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(Constans.URL);

        //step
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);        //close
        DriverSingleton.classObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        loginPage.loginForm("Adam Denta Ramadhan","#Adamdenta18");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Hello Adam Denta Ramadhan (not Adam Denta Ramadhan? Log out)");
        System.out.println("berhasil login");
//        DriverSingleton.delay(20);
        loginPage.logOut();
        System.out.println("berhasil keluar");
    }
    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.loginForm("Adminn","admin123");
        Assert.assertEquals(loginPage.getTxtInvalid(),"ERROR");
        System.out.println("Login Gagal");
    }
    @Test(priority = 3)
    public void password(){
        loginPage.loginForm("Adam Denta Ramadhan","");
        Assert.assertEquals(loginPage.getrequiredPassword(),"Error: The password field is empty.");
        System.out.println("Password kosong");
    }
    @Test(priority = 4)
    public void username(){
        loginPage.ClearUsername();
        loginPage.loginForm("","123");
        Assert.assertEquals(loginPage.getrequiredUsername(),"Error: Username is required.");
        System.out.println("username kosong");
    }
}
