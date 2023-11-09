package com.juaracoding;
import com.juaracoding.Driver.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constans;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.juaracoding.pages.Shop;

import java.sql.SQLOutput;

public class ShopTest {
    private WebDriver driver;
    private LoginPage loginPage = new LoginPage();
    private Shop shop = new Shop();

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance(Constans.CHROME);
        driver = DriverSingleton.getDriver();
//        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(Constans.URL);

        //step
        loginPage = new LoginPage();
        shop = new Shop();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);        //close
        DriverSingleton.classObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        loginPage.loginForm("Adam Denta Ramadhan","Adamdenta18");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Hello Adam Denta Ramadhan (not Adam Denta Ramadhan? Log out)");
        System.out.println("berhasil login");
//        shop.recruitment();
//        Assert.assertEquals(shop.getTxtBaju(),"TOKYO TALKIES");
    }
    @Test(priority = 2)
    public void testCari(){
        shop.recruitment();
        Assert.assertEquals(shop.getTxtBaju(),"TOKYO TALKIES");
        System.out.println("ketemu");
    }
    @Test(priority = 3)
    public void testAdd(){
        shop.add();
        Assert.assertEquals(shop.getTxtContain(),"TOKYO TALKIES");
    }
    @Test(priority = 4)
    public void testKeluar(){
        DriverSingleton.delay(20);
        loginPage.logOutAcount();
        System.out.println("keluar");
    }
}
