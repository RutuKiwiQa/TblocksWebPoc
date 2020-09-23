package com.TBlocks_POC;

import com.framework.common.Common;
import com.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TblocksIndexPage extends AbstractPage {
    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public TblocksIndexPage(WebDriver driver) {
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

    @FindBy(xpath = "(//div[@class='dijitReset dijitRight dijitButtonNode dijitArrowButton dijitDownArrowButton dijitArrowButtonContainer'])[1]")
    private WebElement colorDropdown;

    @FindBy(xpath = "//div[@id='dropdownMenu1']//a")
    private WebElement userName;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[contains(text(),'LOGOUT')]")
    private WebElement logout;

    @FindBy(xpath = "//div[@class='dijitReset dijitMenuItem' and @item='1']//div")
    private WebElement whiteColor;

    @FindBy(xpath = "//div[@class='dijitReset dijitMenuItem' and @item='2']//div")
    private WebElement redColor;

    @FindBy(xpath = "//div[@id='widget_elementn_widgets_FilteringSelectAdvanced_1']//div[@class='dijitReset dijitRight dijitButtonNode dijitArrowButton dijitDownArrowButton dijitArrowButtonContainer']")
    private WebElement modelDropDown;





    //----------------------Method Definition--------------------------------------

    public void getVersion() {
        try {
            testVerifyLog(getText(findElementByXPath(driver, "//div[contains(text(),'Version')]")));
        } catch (Exception ex) {
            testVerifyLog("Version is not available for the current build.");
        }
    }

    public TblocksVerification clickOnMyZainAccount(){
        testStepsLog(_logStep++,"Click on My Zain Account button from the top right corner of the web application.");
        Common.mouseHover(driver,myZainButtton);
        clickOnJS(driver,myZainButtton);
        pause(5);
        return new TblocksVerification(driver);
    }

    public TblocksVerification loginAs(String emailAddress, String password) {

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
        return new TblocksVerification(driver);

    }

    public TblocksVerification clickOnEshopTab(){
        testStepsLog(_logStep++,"Click on E-Shop Tab.");
        Common.mouseHover(driver,eShopTab);
        clickOnJS(driver,eShopTab);
        pause(2);
        return new TblocksVerification(driver);
    }

    public TblocksVerification clickOnFirstProduct(){
        testStepsLog(_logStep++,"Click on First available product.");
        clickOnJS(driver,firstProduct);
        pause(3);
        return new TblocksVerification(driver);
    }

    public TblocksVerification getfirstProductThumbnail(){
        testStepsLog(_logStep++,"Observe and click on the first thumbnail.");
        clickOnJS(driver,firstThumbnail);
        pause(3);
        return new TblocksVerification(driver);
    }

    public TblocksVerification changeColorToWhiteAndModel128(){
        testStepsLog(_logStep++,"Change the color of thumbnail from black to white.");
        testStepsLog(_logStep++,"Click on dropdown.");
        explicitWait(driver, By.xpath("(//div[@class='dijitReset dijitRight dijitButtonNode dijitArrowButton dijitDownArrowButton dijitArrowButtonContainer'])[1]"),10);
        Common.highlightElement(driver,colorDropdown);
        jsClick(driver,colorDropdown);
        pause(2);
//        testStepsLog(_logStep++,"Select color white.");
//        clickOnJS(driver,whiteColor);
//        pause(2);
        return new TblocksVerification(driver);
    }


    public TblocksVerification changeColorToRedAndModel256(){
        testStepsLog(_logStep++,"Change the color of thumbnail from white to red.");
        testStepsLog(_logStep++,"Click on dropdown.");
        clickOnJS(driver,colorDropdown);
        testStepsLog(_logStep++,"Select color white.");
        clickOnJS(driver,redColor);
        pause(2);
        return new TblocksVerification(driver);
    }

    public TblocksVerification clickOnLogoutButton(){
        testStepsLog(_logStep++, "Click on user name");
        clickOnJS(driver,userName);
        testStepsLog(_logStep++,"Click on Logout.");
        clickOnJS(driver,logout);
        pause(2);
        return new TblocksVerification(driver);
    }


}
