package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement ProductQuantity;

    @FindBy(xpath = "//*[@id='our_price_display']")
    WebElement ProductPrice;

    @FindBy(xpath = "//*[@id='center_column']/div/div/div[3]/h1")
    WebElement ProductName;

    @FindBy(xpath = "//*[@name='Submit']/span")
    WebElement AddToCartBtn;
    @FindBy(xpath = "//*[@id='group_1']")
    WebElement productSizeDropdown;

    @FindBy(id="color_11")
    public WebElement ColorBlack;

    @FindBy(xpath = "//*[@id='color_13']")
    WebElement ColorOrange;

    @FindBy(xpath = "//*[@id='color_14']")
    WebElement ColorBlue;

    @FindBy(id="color_16")
    WebElement ColorYellow;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2/text()")
    WebElement ProductAddedSuccessMsg;

    @FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
    WebElement ProceedToCheckOutBtn;
    public AddToCartPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void enterQuantity(String quantity){
        action.type(ProductQuantity, quantity);

    }
    public  void SelectProductSize(String size){

        action.selectByVisibleText(size, productSizeDropdown);
    }

    public void clickOnAddToCart(){
        action.click(getDriver(), AddToCartBtn);

    }

    public boolean verifyAddToCartBtnEnable(){
        boolean addToCartBtnEnable = action.isDisplayed(getDriver(), AddToCartBtn);
        return addToCartBtnEnable;
    }

    public boolean ValidateAddToCart(){
        action.fluentWait(getDriver(), ProductAddedSuccessMsg, 10);
        return action.isDisplayed(getDriver(), ProductAddedSuccessMsg);
    }

    public OrderPage clickOnCheckOut(){

        action.JSClick(getDriver(), ProceedToCheckOutBtn);
        return new OrderPage();
    }

    public boolean clickOnOrangeColorBtn() throws InterruptedException {
        action.click(getDriver(), ColorOrange);
        boolean addToCartBtnEnable = action.isEnabled(getDriver(), AddToCartBtn);
        Thread.sleep(3000);
        return addToCartBtnEnable;
    }
    public boolean clickOnBlackColorBtn() throws InterruptedException {
        action.click(getDriver(), ColorBlack);
        boolean addToCartBtnEnable = action.isEnabled(getDriver(), AddToCartBtn);
        Thread.sleep(3000);
        return addToCartBtnEnable;
    }
    public boolean clickOnYellowColorBtn() throws InterruptedException {
        action.click(getDriver(), ColorYellow);
        boolean addToCartBtnEnable = action.isEnabled(getDriver(), AddToCartBtn);
        Thread.sleep(3000);
        return addToCartBtnEnable;
    }
    public boolean clickOnBlueColorBtn() throws InterruptedException {
        action.click(getDriver(), ColorBlue);
        boolean addToCartBtnEnable = action.isEnabled(getDriver(), AddToCartBtn);
        Thread.sleep(3000);
        return addToCartBtnEnable;
    }


}
