package com.mystore.testCases;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {
    IndexPage indexPage;
    SearchResultsPage searchResultsPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;

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
    public void verifyTotalPrice() throws InterruptedException {
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
        } else if (blueColor) {
            addToCartPage.enterQuantity("2");
            addToCartPage.SelectProductSize("L");
            addToCartPage.clickOnAddToCart();
            boolean result = addToCartPage.ValidateAddToCart();
            //Assert.assertTrue(result);
            addToCartPage.clickOnCheckOut();
        } else if (yellowColor) {
            addToCartPage.enterQuantity("3");
            addToCartPage.SelectProductSize("L");
            addToCartPage.clickOnAddToCart();
            boolean result = addToCartPage.ValidateAddToCart();
            Assert.assertTrue(result);
        }

    }

}
