package com.mystore.pageObjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class IndexPage extends BaseClass {

     @FindBy(xpath = "//a[@class='login']")
      WebElement SignIn;

     @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement myStoreLogo;

    @FindBy(id="search_query_top")
    WebElement SearchProductText;

    @FindBy(name = "submit_search")
    WebElement SearchProuctBtn;

    public IndexPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickOnSignIn(){
        action.click(getDriver(), SignIn);
        return new LoginPage();
    }

    public boolean validateLogo(){
        return action.isDisplayed(getDriver(), myStoreLogo);
    }

    public String getStoreTitle(){
        String storeTitle = getDriver().getTitle();
        return  storeTitle;
    }

    public  SearchResultsPage SearchProduct(String Searchtxt){
        action.type(SearchProductText, Searchtxt);
        action.click(getDriver(), SearchProuctBtn);
        return new SearchResultsPage();
    }

}
