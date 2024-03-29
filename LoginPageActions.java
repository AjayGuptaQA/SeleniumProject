package org.example.actions;


import org.example.locators.LoginPageLocators;
import org.example.utils.HelperClass;

import org.openqa.selenium.support.PageFactory;


import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;


public class LoginPageActions {

    LoginPageLocators loginPageLocators = null;

    public LoginPageActions() {

        this.loginPageLocators = new LoginPageLocators();

        PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
    }

    // Set user name in textbox
    public void setUserName(String strUserName) {
        System.out.println("Typing the value : " + strUserName);
        // loginPageLocators.userName.sendKeys(strUserName);
        loginPageLocators.userName1.sendKeys(strUserName);
        System.out.println("Typing completed for the value : " + strUserName);

    }

    // Set password in password textbox
    public void setPassword(String strPassword) {
        System.out.println("Typing the value : " + strPassword + " in method setPassword");
        loginPageLocators.password1.sendKeys(strPassword);
        System.out.println("Typing completed for value " + strPassword + ". Method setPassword ends");
    }

    // Click on login button
    public void clickLogin() {

        loginPageLocators.loginButton.click();
    }

    // Get the error message when username is blank
    public String getMissingUsernameText() {
        return loginPageLocators.missingUsernameErrorMessage.getText();
    }

    // Get the Error Message
    public String getErrorMessage() {

        return loginPageLocators.errorMessage.getText();
    }

    public void login(String strUserName, String strPassword) {

        // Fill user name
        this.setUserName(strUserName);

        // Fill password
        this.setPassword(strPassword);

        // Click Login button
        this.clickLogin();

    }

    public String ReadPropertiesFileTest(String requiredParam) throws IOException {
        String valueRequiredFromProp = "";
        final Properties prop = new Properties();

        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/cucumber.properties");
        prop.load(inputStream);
        String env = prop.getProperty("env");


        if (env.equalsIgnoreCase("QA")) {
            if (requiredParam.equalsIgnoreCase("username")) {
                valueRequiredFromProp = prop.getProperty("username");
            } else if (requiredParam.equalsIgnoreCase("password")) {
                valueRequiredFromProp = prop.getProperty("password");
            }
            System.out.println("Successfully Login using QA environment");
        }
        else if (env.equalsIgnoreCase("Dev")) {
            if (requiredParam.equalsIgnoreCase("username")) {
                valueRequiredFromProp = prop.getProperty("username1");
            } else if (requiredParam.equalsIgnoreCase("password")) {
                valueRequiredFromProp = prop.getProperty("password1");
            }
            System.out.println("Successfully Login using Dev environment");
        }
        else {
            System.out.println("Provided username and password are wrong");
        }


        System.out.println("valueRequiredFromProp : " + valueRequiredFromProp);
        return valueRequiredFromProp;

    }

    public void addedFromGitHubPortalAgain() {
        System.out.println("inside method addedFromGitHubPortalAgain");
    }
}
