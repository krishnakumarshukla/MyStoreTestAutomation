package com.mystore.testCases;

import com.mystore.base.BaseClass;
import com.mystore.dataProvider.DataProvidersLib;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    //private static Logger logger = Logger.getLogger(LoginPageTest.class.getName());
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setUp(String browser){
        lauchApp(browser);
    }

    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(dataProvider = "credentials", dataProviderClass = DataProvidersLib.class, groups = {"Smoke", "Sanity"}, priority = 0)
    public void verifyLogin(String uName, String pswd) throws NumberFormatException{

        Log.startTestCases("LoginPageTest");
        indexPage = new IndexPage();
        Log.info("User is going for SignIn");
        loginPage = indexPage.clickOnSignIn();
        Log.info("User clicked on SignIn button");
        //homePage = loginPage.Login(prop.getProperty("userName"),prop.getProperty("password"));
        String pass1 = pswd.replaceAll("[^a-zA-Z0-9]+", "");
        String ltter = "0";
        String pass = pass1.replace(ltter, "");
        homePage = loginPage.Login(uName.trim(),pass.trim());
        Log.info("User entered username and Password and click om Login Button");
        String expectedHomePageURL = homePage.getCurrenyURL();
        String actualHomePageURL = "http://www.automationpractice.pl/index.php?controller=my-account";
        Log.info("Verify User Login successfully");
        Assert.assertEquals(actualHomePageURL, expectedHomePageURL, "Both ur ar not matching");
        Log.endTestCases("Verify LoginPageTest");

    }

    @Test(groups = {"Smoke", "Sanity"}, priority = 1)
    public void VerifyLoginTitle(){
        Log.startTestCases("User is going for SignIn and validate page Title");
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        Log.info("Long page Title validation");
        homePage = loginPage.Login(prop.getProperty("userName"),prop.getProperty("password"));
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals(actualTitle, "My account - My Shop", "Both are not macting");
        Log.endTestCases("Verify LoginPageTest End and Title validation are found expected");
    }

}
