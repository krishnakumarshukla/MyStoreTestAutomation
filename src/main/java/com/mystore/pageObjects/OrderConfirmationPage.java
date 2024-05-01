package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BaseClass {

    @FindBy(xpath = "//*[text()='Your order on My Shop is complete.']")
    WebElement MyOrderIsCompletMsg;


    public OrderConfirmationPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String validateOrderConfirmMsg(){

        action.isDisplayed(getDriver(), MyOrderIsCompletMsg);
        String confirmMsg = MyOrderIsCompletMsg.getText();
        return confirmMsg;
    }
}
