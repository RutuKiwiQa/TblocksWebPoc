package com.Zain;

import com.framework.common.Common;
import com.framework.init.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ZainIndexPage extends AbstractPage {
    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public ZainIndexPage(WebDriver driver) {
        super(driver);
    }

    //---------------------Variable Definition------------------------------------
    public static String _emailAddress;
    public static String _password;

    //----------------------Locators Definition-------------------------------------

    @FindBy(xpath = "//div[@class='col-sm-2 col-md-2 text-right']//img[@class='no-notification no-notification-b2c']")
    private WebElement myZainButtton;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement txtEmailAddress;

    @FindBy(xpath = "//input[@name= 'password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//span[@id='dijit_form_Button_0_label']")
    private WebElement btnLogin;

    @FindBy(xpath = "//ul[@id='zain_common_menu_widgets_SingleLevelMenu_0']//a[contains(text(),'E-Shop')]")
    private WebElement eShopTab;

    @FindBy(xpath = "//p[contains(text(),'Available Now')]")
    private WebElement firstProduct;

    @FindBy(xpath = "//div[@id='zain_catalogue_widgets_DevicesViewContainer_0']//div[1]//article[1]//section[4]//div[2]//div[2]//a[1]")
    private WebElement firstThumbnail;



    //----------------------Method Definition--------------------------------------

    public void getVersion() {
        try {
            testVerifyLog(getText(findElementByXPath(driver, "//div[contains(text(),'Version')]")));
        } catch (Exception ex) {
            testVerifyLog("Version is not available for the current build.");
        }
    }

    public ZainVerification clickOnMyZainAccount(){
        testStepsLog(_logStep++,"Click on My Zain Account button from the top right corner of the web application.");
        Common.mouseHover(driver,myZainButtton);
        clickOnJS(driver,myZainButtton);
        pause(5);
        return new ZainVerification(driver);
    }

    public ZainVerification loginAs(String emailAddress, String password) {

        testStepsLog(_logStep++, "Enter Credentials for login.");

        _emailAddress = emailAddress;
        Common.mouseOver(driver,txtEmailAddress);
        clickOnJS(driver,txtEmailAddress);
        testInfoLog("Email Address", _emailAddress);
        txtEmailAddress.sendKeys(_emailAddress);

        _password = password;
        //  testInfoLog("Password", password);
        Common.mouseOver(driver,txtPassword);
        txtPassword.sendKeys(_password);

        Common.mouseOver(driver,btnLogin);
        testStepsLog(_logStep++, "Click on Sign in button.");
        clickOn(driver, btnLogin);
        pause(10);
        return new ZainVerification(driver);

    }

    public ZainVerification clickOnEshopTab(){
        testStepsLog(_logStep++,"Click on E-Shop Tab.");
        Common.mouseHover(driver,eShopTab);
        clickOnJS(driver,eShopTab);
        pause(2);
        return new ZainVerification(driver);
    }

    public ZainVerification clickOnFirstProduct(){
        testStepsLog(_logStep++,"Click on First available product.");
        clickOnJS(driver,firstProduct);
        pause(3);
        return new ZainVerification(driver);
    }

    public ZainVerification getfirstProductThumbnail(){
        testStepsLog(_logStep++,"Observe and click on the first thumbnail.");
        clickOnJS(driver,firstThumbnail);
        pause(3);
        return new ZainVerification(driver);
    }


}
