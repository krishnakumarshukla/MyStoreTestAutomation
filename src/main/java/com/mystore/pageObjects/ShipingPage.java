package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipingPage extends BaseClass {

    @FindBy(name = "cgv")
    WebElement TermsOfService;

    @FindBy(xpath = "//*[@id='form']//button/span")
    WebElement proceedToCheckOutShiping;

    public ShipingPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void clickTermsOfService(){

        action.click(getDriver(), TermsOfService);
    }

    public PaymentPage clickOnChekOutProceedShip(){
        action.click(getDriver(), proceedToCheckOutShiping);
        return new PaymentPage();
    }

}
