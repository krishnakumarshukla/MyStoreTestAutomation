package com.mystore.testCases;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {

    IndexPage indexPage;
    SearchResultsPage searchResultsPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;
    LoginPage loginPage;
    AddreshPage addreshPage;
    ShipingPage shipingPage;
    PaymentPage paymentPage;
    OrderSummaryPage orderSummaryPage;
    OrderConfirmationPage orderConfirmationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setUp(String browser){
        lauchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        getDriver().quit();
    }


    @Test(groups = "Regression")
    public void endToEndTest() throws InterruptedException {
        indexPage = new IndexPage();
        searchResultsPage = indexPage.SearchProduct("Printed Summer Dress");
        addToCartPage = searchResultsPage.clickOnSearchProduct();
        //Orange
        boolean orangeColor = addToCartPage.clickOnOrangeColorBtn();
        //Black
        boolean blackColor = addToCartPage.clickOnBlackColorBtn();
        //Blue
        boolean blueColor = addToCartPage.clickOnBlueColorBtn();
        //Yellow
        boolean yellowColor = addToCartPage.clickOnYellowColorBtn();
        if (orangeColor) {
            addToCartPage.enterQuantity("2");
            addToCartPage.SelectProductSize("M");
            addToCartPage.clickOnAddToCart();
            boolean result = addToCartPage.ValidateAddToCart();
            //Assert.assertTrue(result);
            orderPage = addToCartPage.clickOnCheckOut();
            Double unitPrice = orderPage.getUnitPrice();
            Double totalPrice = orderPage.getTotalPrice();
            loginPage = orderPage.clickProceedToCheckOut();
            addreshPage = loginPage.Login1(prop.getProperty("userName"), prop.getProperty("password"));
            shipingPage = addreshPage.clickOnProceedToCheckOut();
            shipingPage.clickTermsOfService();
            paymentPage = shipingPage.clickOnChekOutProceedShip();
            orderSummaryPage = paymentPage.clickOnPayBuBank();
            orderConfirmationPage = orderSummaryPage.clickOnOrderToConfirm();
            String actualMsg = orderConfirmationPage.validateOrderConfirmMsg();
            Assert.assertEquals(actualMsg, "Your order on My Shop is complete.", "We did not get order confirmation message");

        } else if (blackColor) {
            addToCartPage.enterQuantity("2");
            addToCartPage.SelectProductSize("S");
            addToCartPage.clickOnAddToCart();
            boolean result = addToCartPage.ValidateAddToCart();
            //Assert.assertTrue(result);
            addToCartPage.clickOnCheckOut();
            orderPage = addToCartPage.clickOnCheckOut();
            Double unitPrice = orderPage.getUnitPrice();
            Double totalPrice = orderPage.getTotalPrice();
        }
    }
}
