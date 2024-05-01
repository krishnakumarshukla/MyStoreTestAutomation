package com.mystore.testCases;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseClass {

    IndexPage indexPage;
    SearchResultsPage searchResultPage;
    AddToCartPage addToCartPage;

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

    @Test(groups = {"Regression", "Sanity"})
    public void addToCartTest() throws InterruptedException {
        indexPage = new IndexPage();
        searchResultPage = indexPage.SearchProduct("Printed Summer Dress");
        boolean searchResults = searchResultPage.isProductAvailable();
        boolean addTocartBtnEnable;
        if(searchResults)
        {
            addToCartPage = searchResultPage.clickOnSearchProduct();
            addTocartBtnEnable = addToCartPage.verifyAddToCartBtnEnable();
            //Orange
            boolean orangeColor = addToCartPage.clickOnOrangeColorBtn();
            //Black
            boolean blackColor = addToCartPage.clickOnBlackColorBtn();
            //Blue
            boolean blueColor = addToCartPage.clickOnBlueColorBtn();
            //Yellow
            boolean yellowColor = addToCartPage.clickOnYellowColorBtn();
            if(addTocartBtnEnable){
                System.out.println("addTocartBtnEnable: "+ addTocartBtnEnable);
                addToCartPage.enterQuantity("2");
                addToCartPage.SelectProductSize("M");
                addToCartPage.clickOnAddToCart();
                boolean result = addToCartPage.ValidateAddToCart();
                //Assert.assertTrue(result);
            } else if (orangeColor) {
                addToCartPage.enterQuantity("2");
                addToCartPage.SelectProductSize("M");
                addToCartPage.clickOnAddToCart();
                boolean result = addToCartPage.ValidateAddToCart();
                Assert.assertTrue(result);
                System.out.println("Orange color dress are available");
            } else if (blackColor) {
                addToCartPage.enterQuantity("2");
                addToCartPage.SelectProductSize("S");
                addToCartPage.clickOnAddToCart();
                boolean result = addToCartPage.ValidateAddToCart();
                Assert.assertTrue(result);
            } else if (blueColor) {
                addToCartPage.enterQuantity("2");
                addToCartPage.SelectProductSize("L");
                addToCartPage.clickOnAddToCart();
                boolean result = addToCartPage.ValidateAddToCart();
                Assert.assertTrue(result);
            } else if (yellowColor) {
                addToCartPage.enterQuantity("3");
                addToCartPage.SelectProductSize("L");
                addToCartPage.clickOnAddToCart();
                boolean result = addToCartPage.ValidateAddToCart();
                Assert.assertTrue(result);
            }


        }

    }
}
