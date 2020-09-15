package com.Zain;

import com.framework.init.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ZainVerification extends AbstractPage {
    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public ZainVerification(WebDriver driver) {
        super(driver);
    }

    //--------------------------------Locators Definition---------------------------------------------------------

    @FindBy(xpath = "//div[@class='col-sm-8 col-md-8 text-center']//a[@class='dropdown-toggle'][contains(text(),'VOICE PLANS')]")
    private WebElement voicePlanTab;

    @FindBy(xpath = "//div[@class='col-sm-8 col-md-8 text-center']//a[@class='dropdown-toggle'][contains(text(),'INTERNET')]")
    private WebElement internetPlanTab;

    @FindBy(xpath = "//div[@class='col-sm-8 col-md-8 text-center']//a[@class='dropdown-toggle'][contains(text(),'DEVICES')]")
    private WebElement devicesPlanTab;

    @FindBy(xpath = "//div[@class='col-sm-8 col-md-8 text-center']//a[contains(text(),'ROAMING')]")
    private WebElement roamingPlanTab;

    @FindBy(xpath = "//div[@class='col-sm-8 col-md-8 text-center']//a[contains(text(),'eSIM')]")
    private WebElement eSimTab;

    @FindBy(xpath = "//div[@class='col-sm-8 col-md-8 text-center']//a[contains(text(),'5G')]")
    private WebElement _5GTab;

    @FindBy(xpath = "//div[@class='col-sm-2 col-md-2 text-right']//img[@class='search-b2c']")
    private WebElement searchIcon;

    @FindBy(xpath = "//div[@class='col-sm-2 col-md-2 text-right']//img[@class='no-notification no-notification-b2c']")
    private WebElement myZainButtton;

    @FindBy(xpath = "//a[@class='navbar-brand']//img")
    private WebElement zainLogo;

    @FindBy(xpath = "//a[@class='facebook-signin hvr-sweep-to-bottom']")
    private WebElement loginPanel;


    @FindBy(xpath = "//ul[@id='zain_common_menu_widgets_SingleLevelMenu_0']//a[contains(text(),'Personal')]")
    private WebElement personalTab;

    @FindBy(xpath = "//ul[@id='zain_common_menu_widgets_SingleLevelMenu_0']//a[contains(text(),'Business')]")
    private WebElement businessTab;

    @FindBy(xpath = "//ul[@id='zain_common_menu_widgets_SingleLevelMenu_0']//a[contains(text(),'E-Shop')]")
    private WebElement eShopTab;

    @FindBy(xpath = "//input[@id='elementn_widgets_ValidationTextBox_2']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@class='btn btn-default pull-right']")
    private WebElement footer;

    @FindBy(xpath = "//i[@class='fa fa-facebook']")
    private WebElement followUsIcon;

    @FindBy(xpath = "//ul[@class='nav nav-pills']//a[contains(text(),'Zain KSA')]")
    private WebElement headerHyperLink;

    @FindBy(xpath = "//ul[@id='zain_common_menu_widgets_SingleLevelMenu_0']//a[contains(text(),'5G')]")
    private WebElement FiveGTab;

    @FindBy(xpath = "//span[contains(text(),'Notifications')]")
    private WebElement notificationsDropDown;

    @FindBy(xpath = "//input[@id='elementn_widgets_ValidationTextBox_0']")
    private WebElement searchFieldAfterLogin;

    @FindBy(xpath = "//input[@id='elementn_widgets_ValidationTextBox_2']")
    private WebElement lblName;

    @FindBy(xpath = "//input[@id='selfcare_registration_NicknameValidationTextBox_0']")
    private WebElement lblNickName;

    @FindAll(value = {@FindBy(xpath = "//article[@class='box col1 masonry-brick']")})
    private List<WebElement> lstProducts;

    @FindBy(xpath = "//a[contains(text(),'Price')]")
    private WebElement price;

    @FindBy(xpath = "//a[contains(text(),'Supported Networks')]")
    private WebElement supportedNetworks;

    @FindBy(xpath = "//a[contains(text(),'Preorder')]")
    private WebElement preOrder;

    @FindBy(xpath = "//a[contains(text(),'SIM Type')]")
    private WebElement simType;

    @FindBy(xpath = "//a[contains(text(),'Color')]")
    private WebElement color;

    @FindBy(xpath = "//a[contains(text(),'Operating System')]")
    private WebElement operatingSystem;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;
    //--------------------------------Methods Definition----------------------------------------------------------

    public boolean verifyZainHomeScreen(){
        return isElementDisplay(voicePlanTab) && isElementDisplay(internetPlanTab) &&
                isElementDisplay(devicesPlanTab) && isElementDisplay(roamingPlanTab) &&
                isElementDisplay(eSimTab) && isElementDisplay(_5GTab) &&
                isElementDisplay(searchIcon) && isElementDisplay(myZainButtton);
    }

    public boolean verifyLoginScreen(){
        return isElementDisplay(zainLogo) && isElementDisplay(headerHyperLink) &&
                isElementDisplay(loginPanel) &&
                isElementDisplay(personalTab) && isElementDisplay(businessTab) &&
                isElementDisplay(eShopTab) && isElementDisplay(footer) &&
                isElementDisplay(followUsIcon) && isElementDisplay(searchField);
    }//input[@id='elementn_widgets_ValidationTextBox_0']

    public boolean verifyZainDashboardScreen() {
        testInfoLog("Logged in User Name : ", getInnerValue(lblName));
        testInfoLog("Logged in User's NickName : ", getInnerValue(lblNickName));

        return isElementDisplay(businessTab) && isElementDisplay(personalTab) &&
                isElementDisplay(businessTab) && isElementDisplay(eShopTab) &&
                isElementDisplay(notificationsDropDown) && isElementDisplay(searchFieldAfterLogin);
    }

    public boolean verifyEShopScreenContent(){
        testInfoLog("Total Available Products : ", String.valueOf(sizeOf(lstProducts)));
        return isElementDisplay(eShopTab);
    }

    public boolean verifySelectedProductScreen(){
        return isElementDisplay(price) && isElementDisplay(supportedNetworks) &&
                isElementDisplay(preOrder) && isElementDisplay(simType) &&
                isElementDisplay(color) && isElementDisplay(operatingSystem);
    }
}
