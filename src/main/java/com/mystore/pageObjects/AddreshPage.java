package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddreshPage extends BaseClass {

    @FindBy(xpath = "//*[@name='message']")
    WebElement AddressMsgBox;

    @FindBy(xpath = "//*[@id='center_column']/form/p/button/span")
    WebElement proceedToCheckOutAddress;

    public AddreshPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public ShipingPage clickOnProceedToCheckOut(){
        action.click(getDriver(), proceedToCheckOutAddress);
        return new ShipingPage();
    }
}
