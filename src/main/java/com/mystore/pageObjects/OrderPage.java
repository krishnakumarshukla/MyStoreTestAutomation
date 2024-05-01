package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

    @FindBy(xpath = "//td[@class='cart_unit']//li")
    WebElement unitPrice;

    @FindBy(xpath = "//td[@class='cart_total']/span")
    WebElement UnitTotalPrice;

    @FindBy(xpath = "//input[contains(@name,'quantity')]")
    WebElement unitQuantity;

    @FindBy(id = "total_product")
    WebElement totalProductPrice;

    @FindBy(id = "total_shipping")
    WebElement totalShipingPrice;

    @FindBy(id= "total_price_container")
    WebElement totalFinalPrice;

    @FindBy(xpath = "//*[@id='center_column']/p[2]/a/span")
    WebElement proceedToCheckout;


    public OrderPage(){

        PageFactory.initElements(getDriver(), this);
    }

    public Double getUnitPrice() throws InterruptedException {
        Thread.sleep(5000);
        String unitPrice1 = unitPrice.getText();
        String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]+", "");
        Double finalPrice = Double.parseDouble(unit);
        return finalPrice;
    }

    public Double getTotalPrice(){
        String totalPrice = UnitTotalPrice.getText();
        String totalPric = totalPrice.replaceAll("[^a-zA-Z0-9]+", "");
        Double totalPric1 = Double.parseDouble(totalPric);
        return totalPric1;
    }

    public LoginPage clickProceedToCheckOut(){
        action.click(getDriver(), proceedToCheckout);
        return new LoginPage();

    }

}
