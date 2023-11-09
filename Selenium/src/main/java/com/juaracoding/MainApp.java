package com.juaracoding;
import com.juaracoding.Driver.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.Shop;
import com.juaracoding.utils.Constans;
import org.openqa.selenium.WebDriver;

public class MainApp {
    private static WebDriver driver;

    public static void main(String[] args){
        DriverSingleton.getInstance(Constans.CHROME);
        driver = DriverSingleton.getDriver();
//        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(Constans.URL);

        //step
        LoginPage loginPage = new LoginPage();
        Shop shop = new Shop();

        loginPage.loginForm("feryokta16","#Amala1908");
        shop.recruitment();
        shop.add();
        System.out.println("login sukses");
//        loginPage.logOutAcount();

        //delay
        DriverSingleton.delay(3);        //close
        DriverSingleton.classObjectInstance();

    }
}