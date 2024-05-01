package com.mystore.testCases;

import com.mystore.base.BaseClass;
import com.mystore.pageObjects.AccountCreationPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountCreationTest extends BaseClass {

    IndexPage indexPage;
    LoginPage loginPage;
    AccountCreationPage acountCreationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setUp(String browser){
        lauchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Sanity")
    public void VerifyAccountCreationTest(){
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        acountCreationPage = loginPage.CreateNewAccount("axyz@email.com");
        boolean accountCreationTitle = acountCreationPage.validateAccountCreationTitle();
        Assert.assertTrue(accountCreationTitle);


    }
}
