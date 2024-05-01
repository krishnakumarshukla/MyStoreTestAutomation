package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BaseClass {
    @FindBy(xpath = "//button[@type='submit']/span[text()='I confirm my order']")
    WebElement IConfirmMyOrder;

    public  OrderSummaryPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public OrderConfirmationPage clickOnOrderToConfirm(){

        action.click(getDriver(), IConfirmMyOrder);
        return new OrderConfirmationPage();
    }
}
