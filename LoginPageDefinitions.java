package com.example.definitions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.HomePageActions;
import org.example.actions.LoginPageActions;
import org.example.utils.*;
import org.junit.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginPageDefinitions {

    LoginPageActions objLogin = new LoginPageActions();
    HomePageActions objHomePage = new HomePageActions();
   // ExcelFileOperationUsingHashMap excelFileOperation = new ExcelFileOperationUsingHashMap();

    TimeStamp timeStamp = new TimeStamp();

    ScreenshotOperation screenshotOperation = new ScreenshotOperation();

    ExcelFileOperationUsingHashMap excelFileOperation= new ExcelFileOperationUsingHashMap();

    ExtentTest loginTest;

    @Given("User is on HRMLogin page {string}")
    public void loginTest(String url) {
        System.out.println("Inside loginTest");
        HelperClass.openPage(url);
        loginTest = ExtentReport.ReportSetup().createTest("User is on HRMLogin page", "Provided url is working or not");
        loginTest.log(Status.INFO, "provided url is opened successfully");
        loginTest.pass("Login page displayed successfully");

    }

    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {
        System.out.println("Inside goToHomePage - userName : " + userName + ", passWord : " + passWord);
        // login to application
        objLogin.login(userName, passWord);
        // go the next page

    }

    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {
        System.out.println("Inside verifyLogin");
        // Verify home page
        Assert.assertTrue(objHomePage.getHomePageText().contains("Products"));
        loginTest = ExtentReport.ReportSetup().createTest("User should be able to login successfully and new page open", "This is the test to validate the login functionality");
        loginTest.log(Status.INFO, "verified login successfully and landed in dashboard successfully");
        loginTest.pass("Landed successfully into dashboard page");
        System.out.println("verified login successfully and landed in dashboard successfully");
    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {

        System.out.println("Inside method verifyErrorMessage. expectedErrorMessage : " + expectedErrorMessage);
        // Verify home page
        Assert.assertEquals(objLogin.getErrorMessage(), expectedErrorMessage);

        loginTest = ExtentReport.ReportSetup().createTest("Inside method verifyErrorMessage", "This is the test to validate the login functionality");
        loginTest.log(Status.INFO, "verify login page error message");
        loginTest.fail("provided username and password is wrong");
    }

    @Then("User should be able to see a message {string} below Username")
    public void verifyMissingUsernameMessage(String message) {
        Assert.assertEquals(objLogin.getMissingUsernameText(), message);
    }

    @When("User enters username and password")
    public void userEntersUsernameAndPassword() throws IOException {
        System.out.println("inside userEntersUsernameAndPassword() ");
        String usernameFromPropFile = objLogin.ReadPropertiesFileTest("Username");
        System.out.println("usernameFromPropFile : " + usernameFromPropFile);
        String passwordFromPropFile = objLogin.ReadPropertiesFileTest("password");
        System.out.println("passwordFromPropFile : " + passwordFromPropFile);
        objLogin.login(usernameFromPropFile, passwordFromPropFile);
        loginTest = ExtentReport.ReportSetup().createTest("User enters username and password", "Provided the username and password and click on login btn");
        loginTest.log(Status.INFO, "Login page displayed successfully and landed into dashboard page" /*+" userName "+userName +" passWord "+passWord*/);
        loginTest.pass("Login successfully");
    }

    @Then("I search {string} and add item into the cart")
    public void i_search_and_add_item_into_the_cart(String searchedItem) throws InterruptedException {
        System.out.println("inside i_search_and_add_item_into_the_cart");

        //Assert.assertTrue(objHomePage.getItemNameText().contains(searchedItem));
        System.out.println("searchedItem " + searchedItem);
        if (objHomePage.getSauce_Labs_Fleece_Jacket().equals(searchedItem)) {
            objHomePage.getClickOnBtn().click();
            System.out.println("Item Sauce_Labs_Fleece_Jacket added into Cart");
        } else if (objHomePage.getSauce_Labs_Backpack().equals(searchedItem)) {
            objHomePage.getClickOnBtn().click();
            System.out.println("Item Sauce_Labs_Backpack added into Cart");
        } else if (objHomePage.getSauce_Labs_Bike_Light().equals(searchedItem)) {
            objHomePage.getClickOnBtn().click();
            System.out.println("Item Sauce_Labs_Bike_Light added into Cart");
        } else if (objHomePage.getSauce_Labs_Bolt_TShirt().equals(searchedItem)) {

            objHomePage.getClickOnBtn().click();
            System.out.println("Item Sauce_Labs_Bolt_TShirt added into Cart");
        } else if (objHomePage.getSauce_Labs_Onesie().equals(searchedItem)) {

            objHomePage.getClickOnBtn().click();
            System.out.println("Item Sauce_Labs_Bolt_TShirt added into Cart");
        } else if (objHomePage.getTestAllTheThingsTShirtRed().equals(searchedItem)) {

            objHomePage.getClickOnBtn().click();
            System.out.println("Item TestAllTheThingsTShirtRed added into Cart");
        }
        System.out.println("Finally item added into cart successfully");

        loginTest = ExtentReport.ReportSetup().createTest("I search and add item into the cart", "Selected item should display in cart page");
        loginTest.log(Status.INFO, "Searched item is : " + searchedItem);
        loginTest.pass("item added into cart successfully");
    }

    @When("User add the below example product {string}")
    public void user_add_the_below_example_product(String SelectedProductFromExample) {
        System.out.println("inside user_add_the_below_example_product");

        System.out.println("searchedItem " + SelectedProductFromExample);
        if (objHomePage.getSauce_Labs_Backpack().equals(SelectedProductFromExample)) {
            objHomePage.getClickOnBtn().click();
            System.out.println("Item Sauce_Labs_Backpack added into Cart");
        }
        System.out.println("Finally item added into cart successfully");
        loginTest = ExtentReport.ReportSetup().createTest("I search and add item into the cart", "Selected item should display in cart page");
        loginTest.log(Status.INFO, "Searched item is : " + SelectedProductFromExample);
        loginTest.pass("Item Sauce_Labs_Backpack added into cart successfully");


    }

    @Then("Verify {string} is appearing for that item.")
    public void verify_is_appearing_for_that_item(String string) {
        System.out.println("inside verify_is_appearing_for_that_item");
        if (objHomePage.getRemoveChecked().equals(string)) {
            System.out.println("removed text appear");
        } else {
            System.out.println("removed text not appear");
        }
        loginTest = ExtentReport.ReportSetup().createTest("Verify Remove is appearing for that item.", "Remove btn should display after clicking on add to cart btn");
        loginTest.log(Status.INFO, "Remove is appearing for that item");
        loginTest.pass("Remove btn has been displayed");
    }

    @Then("Click on the cart")
    public void click_on_the_cart() {
        System.out.println("inside click_on_the_cart");
        objHomePage.getClickOnCartBtn().click();
        String CartPageWebElement = objHomePage.getCartPageWebElement().getText();
        System.out.println("CartPageWebElement" + CartPageWebElement);
        if (CartPageWebElement.equals("Sauce Labs Fleece Jacket")) {
            System.out.println("Cart page display correctly");
        } else {
            System.out.println("wrong cart page displayed");
        }
        loginTest = ExtentReport.ReportSetup().createTest("Click on the cart", "Cart page display correctly");
        loginTest.log(Status.INFO, "Cart page display successfully");
        loginTest.pass("Cart page displayed");
    }

    @Then("Click on checkout")
    public void Click_on_checkout() throws IOException, ParseException {
        objHomePage.getClickOnCheckoutBtn().click();
        System.out.println("clicked on checkout btn");
        String checkoutPageWebElement = objHomePage.getCheckoutPageWebElement().getText();
        System.out.println("CartPageWebElement" + checkoutPageWebElement);
        if (checkoutPageWebElement.equals("Checkout: Your Information1")) {
            System.out.println("Checkout page display correctly");
        } else {
            System.out.println("wrong Checkout page displayed");
        }
        HashMap<String,String> customerDetail = excelFileOperation.customerDetailsUsingExcel();

        System.out.println("first name from map : "+customerDetail.get("firstName"));
        System.out.println("last name from map : "+customerDetail.get("lastName"));
        System.out.println("postal Code from map : "+customerDetail.get("postalCode"));



        objHomePage.getFirstName().sendKeys(customerDetail.get("firstName"));
        objHomePage.getLastName().sendKeys(customerDetail.get("lastName"));
        objHomePage.getPostalCode().sendKeys(customerDetail.get("postalCode"));
        //customerDetail

//       for (Map.Entry<String, String> custDetails : customerDetail.entrySet())
//         {
//             String retrievedValue = custDetails.getValue();
//             System.out.println("retrievedValue "+retrievedValue);//
//
//             objHomePage.getFirstName().sendKeys(retrievedValue);
//             objHomePage.getLastName().sendKeys(retrievedValue);
//             objHomePage.getPostalCode().sendKeys(retrievedValue);
//
//         }
       //objHomePage.getFirstName().sendKeys(customerDetail.get(0));
//        objHomePage.getLastName().sendKeys(customerDetail.get(1));
//        objHomePage.getPostalCode().sendKeys(customerDetail.get(2));
        /*for (int i = 0; i < customerDetail.size(); i++) {

            if (i == 0) {
                objHomePage.getFirstName().sendKeys(customerDetail.get(i));
            } else if (i == 1) {

                objHomePage.getLastName().sendKeys(customerDetail.get(i));
            } else
                objHomePage.getPostalCode().sendKeys(customerDetail.get(i));
        }*/
        objHomePage.getClickOnContinueBtn().click();
        loginTest = ExtentReport.ReportSetup().createTest("Click on checkout", "Cart page display correctly");
        loginTest.log(Status.INFO, "checkout page display successfully and provided the customer details");

        loginTest.pass("checkout page displayed");
        loginTest.fail("wrong Checkout page displayed and took the screenshot");
        String screenshotTakenPath = screenshotOperation.getScreenshot();
        System.out.println("screenshot is stored at path : " + screenshotTakenPath);
//        TakesScreenshot ts = ((TakesScreenshot) HelperClass.getDriver());
//        File src = ts.getScreenshotAs(OutputType.FILE);
//        String projectPath = System.getProperty("user.dir");
//        String screenshotFolderPath = projectPath + "\\src\\test\\resources\\screenshots";
//        String CurrentTimeStamp = timeStamp.getTimeStamp();
//        FileHandler.copy(src, new File(screenshotFolderPath + "\\checkoutFail " + CurrentTimeStamp + ".png"));
        loginTest.fail("Checkout error", MediaEntityBuilder.createScreenCaptureFromPath(screenshotTakenPath).build());
    }

    @Then("Verify the description of the item")
    public void verify_the_description_of_the_item() {
        System.out.println("inside Then Verify the description of the item");
        String CartPageWebElement = objHomePage.getCartPageWebElement().getText();
        if (CartPageWebElement.equals("Sauce Labs Fleece Jacket")) {
            System.out.println("Checkout Overview display correctly");
        } else {
            System.out.println("wrong Checkout Overview displayed");
        }

        loginTest = ExtentReport.ReportSetup().createTest("Verify the description of the item.", "Verify the description of the item which customer has been selected.");
        loginTest.log(Status.INFO, "Verify the item of the description");
        loginTest.pass("correct item has been displayed");

    }

    @Then("Verify Thank you for your order")
    public void verify_Thank_you_for_your_order() {
        System.out.println("inside Verify Thank you for your order");
        objHomePage.getClickOnFinish().click();
        String orderCompleteMessage = objHomePage.getOrderCompleted().getText();
        if (orderCompleteMessage.equals("Thank you for your order!")) {
            System.out.println("Your order has been completed");
        } else {
            System.out.println("Order not completed ");
        }
        loginTest = ExtentReport.ReportSetup().createTest("Verify Thank you for your order", "Verify the order confirmation");
        loginTest.log(Status.INFO, "order has been successfully placed");
        loginTest.pass("order confirmed");
    }
}
