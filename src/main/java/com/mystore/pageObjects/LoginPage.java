package com.mystore.pageObjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(id = "email")
    WebElement UserName;

    @FindBy(id = "passwd")
    WebElement Password;

    @FindBy(name = "SubmitLogin")
    WebElement LoginBtn;

    @FindBy(id = "email_create")
    WebElement EmailToCreateAccount;

    @FindBy(id = "SubmitCreate")
    WebElement CreateAccountBtn;

    public LoginPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public HomePage Login(String username, String pass){
        action.type(UserName, username);
        action.type(Password, pass);
        action.click(getDriver(), LoginBtn);
        return new HomePage();
    }

    public AccountCreationPage CreateNewAccount(String EmailID){

        action.type(EmailToCreateAccount, EmailID);
        action.click(getDriver(), CreateAccountBtn);

        return new AccountCreationPage();
    }

    public AddreshPage Login1(String username, String pass){
        action.type(UserName, username);
        action.type(Password, pass);
        action.click(getDriver(), LoginBtn);
        return new AddreshPage();
    }

}
