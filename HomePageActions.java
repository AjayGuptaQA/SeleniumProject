package org.example.actions;

import org.example.locators.HomePageLocators;
import org.example.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePageActions {

    HomePageLocators homePageLocators = new HomePageLocators();

    //LoginPageActions objLogin = new LoginPageActions();


    public HomePageActions() {

        this.homePageLocators = new HomePageLocators();

        PageFactory.initElements(HelperClass.getDriver(), homePageLocators);


    }


    // Get the User name from Home Page
    public String getHomePageText() {
        System.out.println("Inside method getHomePageText");
        //return homePageLocators.homePageUserName.getText();
        return homePageLocators.homePageUserName1.getText();

    }

    public String getSauce_Labs_Fleece_Jacket()  {
        System.out.println("Inside method getItemNameText");
        //return homePageLocators.homePageUserName.getText();
        return homePageLocators.Sauce_Labs_Fleece_Jacket.getText();

    }

    public String getSauce_Labs_Backpack() {
        System.out.println("Inside method getItemNameText");
        //return homePageLocators.homePageUserName.getText();
        return homePageLocators.Sauce_Labs_Backpack.getText();

    }

    public String getSauce_Labs_Bike_Light() {
        System.out.println("Inside method getItemNameText");
        return homePageLocators.Sauce_Labs_Bike_Light.getText();

    }

    public String getSauce_Labs_Bolt_TShirt() {
        System.out.println("Inside method getItemNameText");
        return homePageLocators.Sauce_Labs_Bolt_TShirt.getText();

    }

    public String getSauce_Labs_Onesie() {
        System.out.println("Inside method getItemNameText");
        return homePageLocators.Sauce_Labs_Onesie.getText();

    }

    public String getTestAllTheThingsTShirtRed() {
        System.out.println("Inside method getItemNameText");
        return homePageLocators.TestAllTheThingsTShirtRed.getText();

    }

    public WebElement getClickOnBtn() {
        System.out.println("Inside method getClickOnBtn");
        //return homePageLocators.homePageUserName.getText();
        return homePageLocators.addToCartButton;


    }

    public String getRemoveChecked() {
        System.out.println("Inside method getRemoveChecked");
        return homePageLocators.remove.getText();

    }

    public WebElement getClickOnCartBtn() {
        System.out.println("Inside method getClickOnCartBtn");

        return homePageLocators.clickOnCartBtn;

    }

    public WebElement getCartPageWebElement() {
        System.out.println("Inside method getCartPageWebElement");

        return homePageLocators.cartPageWebElement;

    }

    public WebElement getClickOnCheckoutBtn() {
        System.out.println("Inside method getClickOnCheckoutBtn");

        return homePageLocators.getClickOnCheckoutBtn;

    }

    public WebElement getCheckoutPageWebElement() {
        System.out.println("Inside method getClickOnCheckoutBtn");

        return homePageLocators.checkoutPageWebElement;

    }

    public WebElement getFirstName() {
        System.out.println("Inside method getfirstName");

        return homePageLocators.firstName;

    }

    public WebElement getLastName() {
        System.out.println("Inside method getLastName");

        return homePageLocators.lastName;

    }

    public WebElement getPostalCode() {
        System.out.println("Inside method getPostalCode");

        return homePageLocators.postalCode;

    }

    public WebElement getClickOnContinueBtn() {
        System.out.println("Inside method getClickOnContinueBtn");

        return homePageLocators.clickOnContinueBtn;

    }

    public WebElement getClickOnFinish() {
        System.out.println("Inside method getClickOnContinueBtn");

        return homePageLocators.clickOnFinish;

    }

    public WebElement getOrderCompleted() {
        System.out.println("Inside method getOrderCompleted");

        return homePageLocators.orderCompleted;

    }

    public String getSearchedItemOnCartPage() {
        System.out.println("Inside method getSearchedItemOnCartPage");

        return homePageLocators.searchedItemOnCartPage.getText();

    }


}
