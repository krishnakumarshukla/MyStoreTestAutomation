package com.mystore.testCases;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AccountCreationPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultsTest extends BaseClass {

    IndexPage indexPage;
    SearchResultsPage searchResultPage;
    AccountCreationPage acountCreationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setUp(String browser){
        lauchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        getDriver().quit();
    }

    @Test(groups = "Smoke")
    public void productAvailablebilityTest(){

        indexPage = new IndexPage();
        searchResultPage = indexPage.SearchProduct("Printed Summer Dress");
        searchResultPage.CountOfSearchResult();
        searchResultPage.isProductAvailable();
        searchResultPage.clickOnSearchProduct();

    }
}
