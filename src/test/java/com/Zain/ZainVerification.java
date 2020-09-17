package com.Zain;

import com.framework.init.AbstractPage;
import com.utils.ExcelUtils;
import com.utils.ZainProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
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

    //-------------------------------VariableDeclaration--------------------------------------------------------
    public static String _blackColor;
    public static String _whiteColor;
    public static String _redColor;

    public static String _model64GB;
    public static String _model128GB;
    public static String _model256GB;

    public static String _blackModelPrice;
    public static String _whiteModelPrice;
    public static String _redModelPrice;

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

    @FindBy(xpath = "//div[@class='slick-initialized slick-slider']")
    private WebElement thumbnailPage;

    @FindBy(xpath = "//input[@id='elementn_widgets_FilteringSelect_1']")
    private WebElement drpBlack;

    @FindBy(xpath = "//input[@id='elementn_widgets_FilteringSelectAdvanced_0']")
    private WebElement drp64GB;

    @FindBy(xpath = "//section[@class='col-xs-12 col-md-4']//span//span[1]")
    private WebElement lblPriceBlack;

    @FindBy(xpath = "//a[@class='twitter-signin hvr-sweep-to-bottom']")
    private WebElement logoutSuccess;
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

    public boolean verifyThumnailInformationPage(){
        return isElementDisplay(thumbnailPage);
    }

    public boolean verifyBlackModel() throws IOException {
        String black = ZainProvider.getCellData(1,1);
        String model = ZainProvider.getCellData(1,2);
        String price = ZainProvider.getCellData(1,3);
        _blackColor = getInnerValue(drpBlack);
        _model64GB = getInnerValue(drp64GB);
        _blackModelPrice = getText(lblPriceBlack);

        testInfoLog("Currently selected Mobile Color :  " ,  _blackColor.trim());
        testVerifyLog("Currently selected Mobile Model  : "+ _model64GB);
        testVerifyLog("Currently selected Mobile price   : "+ _blackModelPrice);

        return _blackColor.trim().contains(black.trim()) && _model64GB.trim().contains(model.trim()) &&
                _blackModelPrice.trim().contains(price.trim());
    }

    public boolean verifyUserLogoutSuccessFully(){
        return  isElementDisplay(logoutSuccess);
    }
}
