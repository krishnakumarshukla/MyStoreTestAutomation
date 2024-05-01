package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {

    @FindBy(xpath = "//a[contains(text(), 'Pay by bank wire')]")
    WebElement PaybyBankMethod;

    @FindBy(xpath = "//a[contains(text(), 'Pay by check')]")
    WebElement Paybycheck;

    public PaymentPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public OrderSummaryPage clickOnPayBuBank(){
        action.click(getDriver(), PaybyBankMethod);
        return new OrderSummaryPage();
    }
}
