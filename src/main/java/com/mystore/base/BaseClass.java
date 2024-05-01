package com.mystore.base;

import com.mystore.actionInterface.ActionInterface;
import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public  static Properties prop;
    public static ActionInterface action;
    //public static WebDriver driver;

    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return  driver.get();
    }

    @BeforeSuite(groups = {"Smoke", "Sanity", "Regrssion"})
    public  void  loadConfig(){
        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");
        try {

            prop = new Properties();
            System.out.println("Super Constructer Invoked");
            String filePath = System.getProperty("user.dir")+"/configuration/Config.properties";
            File file = new File(filePath);
            FileInputStream FIS = new FileInputStream(file);
            prop.load(FIS);
            System.out.println("driver : " + driver);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static  void lauchApp(String browserName){

        action = new Action();

        //String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();
            driver.set(new ChromeDriver());
        }
        else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            //driver = new FirefoxDriver();
            driver.set(new FirefoxDriver());
        } else if ( browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.edgedriver().setup();
            //driver = new EdgeDriver();
            driver.set(new EdgeDriver());
        }

//        driver.manage().window().maximize();z
//        action.implicitWait(driver, 10);
//        action.pageLoadTimeOut(driver, 20);
//        driver.get(prop.getProperty("url"));

        getDriver().manage().window().maximize();
        action.implicitWait(getDriver(), 10);
        action.pageLoadTimeOut(getDriver(), 20);
        getDriver().get(prop.getProperty("url"));

    }

    @AfterSuite(groups = {"Smoke", "Sanity", "Regrssion"})
    public void afterSuite(){
        ExtentManager.endReport();
    }

}
