package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BaseClass {

    @FindBy(xpath = "//*[@id='center_column']//img")
    WebElement productResult_outOfStock;

    @FindBy(xpath = "//*[@id='center_column']/h1/span[2]")
    WebElement Total_ResultFound;

    public SearchResultsPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public String CountOfSearchResult()
    {
        String ResultCount = Total_ResultFound.getText();
        return ResultCount;
    }

    public boolean isProductAvailable(){
        return action.isDisplayed(getDriver(),productResult_outOfStock);
    }

    public AddToCartPage clickOnSearchProduct(){

        action.click(getDriver(), productResult_outOfStock);
        return new AddToCartPage();
    }

}
