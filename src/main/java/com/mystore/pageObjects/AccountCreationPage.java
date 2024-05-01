package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {

    @FindBy(xpath = "//h1[text()='Create an account']")
    WebElement AccountCreationTile;

    public AccountCreationPage(){

        PageFactory.initElements(getDriver(), this);
    }

    public boolean validateAccountCreationTitle(){
        return action.isDisplayed(getDriver(), AccountCreationTile);
    }

}
