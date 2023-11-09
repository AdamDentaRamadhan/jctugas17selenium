package com.juaracoding.pages;

import com.juaracoding.Driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shop {
    private WebDriver driver;
    //    @FindBy(xpath = ("//*[@id=\"noo-site\"]/header/div[2]/div/div/div/a"))
//    private WebElement menuRecruitment;
    @FindBy(xpath = ("//*[@id=\"noo-site\"]/section/div/div/div/span[1]/a"))
    private WebElement menuSearch;

    @FindBy(xpath = ("//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div"))
    private WebElement pilihBaju;

    @FindBy(xpath = ("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/h1"))
    private WebElement txtbaju;
    //*[@id="product-704"]/div[1]/div[2]/h1

    @FindBy(xpath = ("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/div/div[2]/button"))
    private WebElement addToCart;

    @FindBy(xpath = ("/html/body/div[2]/header/div[2]/div/div/div/ul/li/a/span/span[2]"))
    private WebElement openCart;

    @FindBy(xpath = ("/html/body/div[1]/div[2]/main/article/div/div/form/table/tbody/tr[1]/td[2]/a"))
    private WebElement containOfcart;

    @FindBy(xpath = ("/html/body/p/a"))
    private WebElement dismis;
//    /html/body/p/a


    //Locator

    public Shop() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void recruitment() {
//        menuRecruitment.click();
        menuSearch.click();
        pilihBaju.click();
    }
    public String getTxtBaju(){
        return txtbaju.getText();
    }
    public  String getTxtContain(){
        return containOfcart.getText();
    }

    public void add(){
        dismis.click();
        addToCart.click();
        openCart.click();
    }


}
