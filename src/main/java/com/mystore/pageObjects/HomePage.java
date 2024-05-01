package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//a[@title='Add my first address']//span")
    WebElement AddmyFirstAddress;

    @FindBy(xpath = "//a[@title='Orders']//span")
    WebElement OrdersHistoryDetails;


    public HomePage(){
        PageFactory.initElements(getDriver(), this);
    }

    public boolean validateOrderHistory(){

        return action.isDisplayed(getDriver(),OrdersHistoryDetails);

    }

    public String getCurrenyURL(){
        String homePageURL = getDriver().getCurrentUrl();
        return homePageURL;
    }


}
