package com.TBlocks_POC;

import com.framework.common.Common;
import com.framework.init.AbstractPage;
import com.utils.ZainProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class TblocksVerification extends AbstractPage {
    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public TblocksVerification(WebDriver driver) {
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

    public static String _plans;

    public static String _598Plans;
    public static String _598Validity;
    public static String _598Benefits;
    public static String _598PlansFromExcel;
    public static String _598ValidityFromExcel;
    public static String _598BenefitsFromExcel;

    public static String _2599Plans;
    public static String _2599Validity;
    public static String _2599Benefits;
    public static String _2599PlansFromExcel;
    public static String _2599ValidityFromExcel;
    public static String _2599BenefitsFromExcel;

    public static String _2399Plans;
    public static String _2399Validity;
    public static String _2399Benefits;
    public static String _2399PlansFromExcel;
    public static String _2399ValidityFromExcel;
    public static String _2399BenefitsFromExcel;

    public static String _599Plans;
    public static String _599Validity;
    public static String _599Benefits;
    public static String _599PlansFromExcel;
    public static String _599ValidityFromExcel;
    public static String _599BenefitsFromExcel;

    public static String _444Plans;
    public static String _444Validity;
    public static String _444Benefits;
    public static String _444PlansFromExcel;
    public static String _444ValidityFromExcel;
    public static String _444BenefitsFromExcel;

    public static String _249Plans;
    public static String _249Validity;
    public static String _249Benefits;
    public static String _249PlansFromExcel;
    public static String _249ValidityFromExcel;
    public static String _249BenefitsFromExcel;

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

    @FindBy(xpath = "//li[@class='activemenu active']//a[contains(text(),'Plans')]")
    private WebElement planTabs;

    @FindBy(xpath = "//li[@class='activemenu']//a[contains(text(),'Devices')]")
    private WebElement devicesTab;

    @FindBy(xpath = "//li[@class='activemenu']//a[contains(text(),'Apps')]")
    private WebElement appsTab;

    @FindBy(xpath = "//a[contains(text(),'SIM HOME DELIVERY')]")
    private WebElement simHomeDeliveryTab;

    @FindBy(xpath = "//li[@class='active-subheader']//a[contains(text(),'MOBILITY')]")
    private WebElement mobilityTab;

    @FindBy(xpath = "//div[@class='sub-header-left-list']//a[contains(text(),'JIOFIBER')]")
    private WebElement jioFiberTab;

    @FindBy(xpath = "//a[contains(text(),'Popular Plans')]")
    private WebElement popularPlans;

    @FindAll(value = {@FindBy(xpath = "//div[@class='jio-accordion-body']//div[@class='row plan_details']//div[@class='col-lg-3 col-md-3 col-sm-3 col-xs-3 plan_detail_list']//span[@class='MainPrice redtxt']")})
    public List<WebElement> lstPlans;

    @FindAll(value = {@FindBy(xpath = "//div[@class='jio-accordion-body']//div[@class='row plan_details']//div[@class='col-lg-2 col-md-2 col-sm-2 col-xs-3 plan_detail_list']//div[@class='list_inline']")})
    public List<WebElement> lstValidity;

    @FindAll(value = {@FindBy(xpath = "//div[@class='jio-accordion-body']//div[@class='row plan_details']//div[@class='col-lg-3 col-md-3 col-sm-3 col-xs-3 plan_detail_list datatype ']//div[@class='list_inline']")})
    public List<WebElement> lstBenefits;

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
            //    isElementDisplay(personalTab) && isElementDisplay(businessTab) &&
               // isElementDisplay(eShopTab) && isElementDisplay(footer) &&
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
        String black = ZainProvider.getCellData("Price",1,1);
        String model = ZainProvider.getCellData("Price",1,2);
        String price = ZainProvider.getCellData("Price", 1,3);
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

    public boolean verifyJioPlansScreen(){

//        testVerifyLog("Verify the following tabs are displayed on jio plans page." +
//                "<br> 1. Mobility" +
//                "<br> 2. JioFiber" +
//                "<br> 3. Plans" +
//                "<br> 4. Devices" +
//                "<br> 5. Apps" +
//                "<br> 6. Sim Home Delivery" +
//                "<br> 7. PostPaid" +
//                "<br> 8. Prepaid" +
//                "<br> 9. Popular Plans." +
//                "<br> 10. Jio Cricket" +
//                "<br> 11. Jio Phone" +
//                "<br> 12. 4G Data Voucher" +
//                "<br> 13. ISD" +
//                "<br> 14. International Roaming" +
//                "<br> 15. Top-up" +
//                "<br> 16. JioLink" +
//                "<br> 17. JioSaavnPro" +
//                "<br> 18. Others");

        return isElementDisplay(planTabs) && isElementDisplay(devicesTab) &&
                isElementDisplay(appsTab) && isElementDisplay(simHomeDeliveryTab) &&
                isElementDisplay(mobilityTab) && isElementDisplay(jioFiberTab);
    }

    public boolean verify2GBPerDayFirstPlansPricing() throws IOException {

        _598Plans = getText(lstPlans.get(0));

        _598Validity = getText(lstValidity.get(0));
        _598Benefits = getText(lstBenefits.get(0));

        _598PlansFromExcel = ZainProvider.getCellData("JioPlans",1,0);
        _598ValidityFromExcel = ZainProvider.getCellData("JioPlans",1,1);
        _598BenefitsFromExcel= ZainProvider.getCellData("JioPlans",1,2);



        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("First Plan Price : " , _598Plans );
        testInfoLog("First Plan Validity : ", _598Validity);
        testInfoLog("First Plan Benefits : ", _598Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("First plan price : " ,_598PlansFromExcel);
        testInfoLog("First plan validity : " ,_598ValidityFromExcel);
        testInfoLog("First Plan Benefits : ",_598BenefitsFromExcel);

        testVerifyLog("Verify first plan 2GB/Day details are same on screen and excel sheet.");
        return _598Plans.trim().contains(_598PlansFromExcel) &&
                _598Validity.trim().contains(_598ValidityFromExcel);
    }

    public boolean verify2GBPerDaySecondPlansPricing() throws IOException {

        _2599Plans = getText(lstPlans.get(1));
        _2599Validity = getText(lstValidity.get(1));
        _2599Benefits = getText(lstBenefits.get(1));

        _2599PlansFromExcel = ZainProvider.getCellData("JioPlans",2,0);
        _2599ValidityFromExcel = ZainProvider.getCellData("JioPlans",2,1);
        _2599BenefitsFromExcel= ZainProvider.getCellData("JioPlans",2,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Second Plan Price : " , _2599Plans );
        testInfoLog("Second Plan Validity : ", _2599Validity);
        testInfoLog("Second Plan Benefits : ", _2599Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Second plan price : " ,_2599PlansFromExcel);
        testInfoLog("Second plan validity : " ,_2599ValidityFromExcel);
        testInfoLog("Second Plan Benefits : ",_2599BenefitsFromExcel);

        testVerifyLog("Verify Second plan 2GB/Day details are same on screen and excel sheet.");

        return _2599Plans.trim().contains(_2599PlansFromExcel) &&
                _2599Validity.trim().contains(_2599ValidityFromExcel) &&
                _2599Benefits.trim().contains(_2599BenefitsFromExcel);
    }

    public boolean verify2GBPerDayThirdPlansPricing() throws IOException {
        _2399Plans = getText(lstPlans.get(2));
        _2399PlansFromExcel = ZainProvider.getCellData("JioPlans",3,0);
        _2399Validity = getText(lstValidity.get(2));;
        _2399ValidityFromExcel = ZainProvider.getCellData("JioPlans",3,1);
        _2399Benefits = getText(lstBenefits.get(2));
        _2399BenefitsFromExcel= ZainProvider.getCellData("JioPlans",3,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Third Plan Price : " , _2399Plans );
        testInfoLog("Third Plan Validity : ", _2399Validity);
        testInfoLog("Third Plan Benefits : ", _2399Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Third plan price : " ,_2399PlansFromExcel);
        testInfoLog("Third plan validity : " ,_2399ValidityFromExcel);
        testInfoLog("Third Plan Benefits : ",_2399BenefitsFromExcel);

        testVerifyLog("Verify Third plan 2GB/Day details are same on screen and excel sheet.");

        return _2399Plans.trim().contains(_2399PlansFromExcel) &&
                _2399Validity.trim().contains(_2399ValidityFromExcel)&&
                _2399Benefits.trim().contains(_2399BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDayForthPlansPricing() throws IOException {
        _599Plans = getText(lstPlans.get(3));
        _599PlansFromExcel = ZainProvider.getCellData("JioPlans",4,0);
        _599Validity = getText(lstValidity.get(3));
        _599ValidityFromExcel = ZainProvider.getCellData("JioPlans",4,1);
        _599Benefits = getText(lstBenefits.get(3));
        _599BenefitsFromExcel= ZainProvider.getCellData("JioPlans",4,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Forth Plan Price : " , _599Plans );
        testInfoLog("Forth Plan Validity : ", _599Validity);
        testInfoLog("Forth Plan Benefits : ", _599Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Forth plan price : " ,_599PlansFromExcel);
        testInfoLog("Forth plan validity : " ,_599ValidityFromExcel);
        testInfoLog("Forth Plan Benefits : ",_599BenefitsFromExcel);

        testVerifyLog("Verify Forth plan 2GB/Day details are same on screen and excel sheet.");

        return _599Plans.trim().contains(_599PlansFromExcel) &&
                _599Validity.trim().contains(_599ValidityFromExcel) &&
                _599Benefits.trim().contains(_599BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDayFifthPlansPricing() throws IOException {
        _444Plans = getText(lstPlans.get(4));
        _444PlansFromExcel = ZainProvider.getCellData("JioPlans",5,0);

        _444Validity = getText(lstValidity.get(4));
        _444ValidityFromExcel = ZainProvider.getCellData("JioPlans",5,1);

        _444Benefits = getText(lstBenefits.get(4));
        _444BenefitsFromExcel= ZainProvider.getCellData("JioPlans",5,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Fifth Plan Price : " , _444Plans );
        testInfoLog("Fifth Plan Validity : ", _444Validity);
        testInfoLog("Fifth Plan Benefits : ", _444Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Fifth plan price : " ,_444PlansFromExcel);
        testInfoLog("Fifth plan validity : " ,_444ValidityFromExcel);
        testInfoLog("Fifth Plan Benefits : ",_444BenefitsFromExcel);

        testVerifyLog("Verify Fifth plan 2GB/Day details are same on screen and excel sheet.");

        return _444Plans.trim().contains(_444PlansFromExcel) &&
                _444Validity.trim().contains(_444ValidityFromExcel) &&
                _444Benefits.trim().contains(_444BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDaySixthPlansPricing() throws IOException {

        _249Plans = getText(lstPlans.get(5));
        _249PlansFromExcel = ZainProvider.getCellData("JioPlans",6,0);

        _249Validity = getText(lstValidity.get(5));
        _249ValidityFromExcel = ZainProvider.getCellData("JioPlans",6,1);

        _249Benefits = getText(lstBenefits.get(5));
        _249BenefitsFromExcel= ZainProvider.getCellData("JioPlans",6,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Sixth Plan Price : " , _249Plans );
        testInfoLog("Sixth Plan Validity : ", _249Validity);
        testInfoLog("Sixth Plan Benefits : ", _249Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Sixth plan price : " ,_249PlansFromExcel);
        testInfoLog("Sixth plan validity : " ,_249ValidityFromExcel);
        testInfoLog("Sixth Plan Benefits : ",_249BenefitsFromExcel);

        testVerifyLog("Verify Sixth plan 2GB/Day details are same on screen and excel sheet.");

        return _249Plans.trim().contains(_249PlansFromExcel) &&
                _249Validity.trim().contains(_249ValidityFromExcel) &&
                _249Benefits.trim().contains(_249BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDayFirstPlansPricingNegative() throws IOException {

        _598Plans = getText(lstPlans.get(0));
        _598Validity = getText(lstValidity.get(0));
        _598Benefits = getText(lstBenefits.get(0));

        _598PlansFromExcel = ZainProvider.getCellData("JioPlansNegative",1,0);
        _598ValidityFromExcel = ZainProvider.getCellData("JioPlansNegative",1,1);
        _598BenefitsFromExcel= ZainProvider.getCellData("JioPlansNegative",1,2);



        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("First Plan Price : " , _598Plans );
        testInfoLog("First Plan Validity : ", _598Validity);
        testInfoLog("First Plan Benefits : ", _598Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("First plan price : " ,_598PlansFromExcel);
        testInfoLog("First plan validity : " ,_598ValidityFromExcel);
        testInfoLog("First Plan Benefits : ",_598BenefitsFromExcel);

        testVerifyLog("Verify first plan 2GB/Day details are same on screen and excel sheet.");
        return _598Plans.trim().contains(_598PlansFromExcel) &&
                _598Validity.trim().contains(_598ValidityFromExcel);
    }

    public boolean verify2GBPerDaySecondPlansPricingNegative() throws IOException {

        _2599Plans = getText(lstPlans.get(1));
        _2599Validity = getText(lstValidity.get(1));
        _2599Benefits = getText(lstBenefits.get(1));

        _2599PlansFromExcel = ZainProvider.getCellData("JioPlansNegative",2,0);
        _2599ValidityFromExcel = ZainProvider.getCellData("JioPlansNegative",2,1);
        _2599BenefitsFromExcel= ZainProvider.getCellData("JioPlansNegative",2,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Second Plan Price : " , _2599Plans );
        testInfoLog("Second Plan Validity : ", _2599Validity);
        testInfoLog("Second Plan Benefits : ", _2599Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Second plan price : " ,_2599PlansFromExcel);
        testInfoLog("Second plan validity : " ,_2599ValidityFromExcel);
        testInfoLog("Second Plan Benefits : ",_2599BenefitsFromExcel);

        testVerifyLog("Verify Second plan 2GB/Day details are same on screen and excel sheet.");

        return _2599Plans.trim().contains(_2599PlansFromExcel) &&
                _2599Validity.trim().contains(_2599ValidityFromExcel) &&
                _2599Benefits.trim().contains(_2599BenefitsFromExcel);
    }

    public boolean verify2GBPerDayThirdPlansPricingNegative() throws IOException {
        _2399Plans = getText(lstPlans.get(2));
        _2399PlansFromExcel = ZainProvider.getCellData("JioPlansNegative",3,0);
        _2399Validity = getText(lstValidity.get(2));;
        _2399ValidityFromExcel = ZainProvider.getCellData("JioPlansNegative",3,1);
        _2399Benefits = getText(lstBenefits.get(2));
        _2399BenefitsFromExcel= ZainProvider.getCellData("JioPlansNegative",3,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Third Plan Price : " , _2399Plans );
        testInfoLog("Third Plan Validity : ", _2399Validity);
        testInfoLog("Third Plan Benefits : ", _2399Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Third plan price : " ,_2399PlansFromExcel);
        testInfoLog("Third plan validity : " ,_2399ValidityFromExcel);
        testInfoLog("Third Plan Benefits : ",_2399BenefitsFromExcel);

        testVerifyLog("Verify Third plan 2GB/Day details are same on screen and excel sheet.");

        return _2399Plans.trim().contains(_2399PlansFromExcel) &&
                _2399Validity.trim().contains(_2399ValidityFromExcel)&&
                _2399Benefits.trim().contains(_2399BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDayForthPlansPricingNegative() throws IOException {
        _599Plans = getText(lstPlans.get(3));
        _599PlansFromExcel = ZainProvider.getCellData("JioPlansNegative",4,0);
        _599Validity = getText(lstValidity.get(3));
        _599ValidityFromExcel = ZainProvider.getCellData("JioPlansNegative",4,1);
        _599Benefits = getText(lstBenefits.get(3));
        _599BenefitsFromExcel= ZainProvider.getCellData("JioPlansNegative",4,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Forth Plan Price : " , _599Plans );
        testInfoLog("Forth Plan Validity : ", _599Validity);
        testInfoLog("Forth Plan Benefits : ", _599Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Forth plan price : " ,_599PlansFromExcel);
        testInfoLog("Forth plan validity : " ,_599ValidityFromExcel);
        testInfoLog("Forth Plan Benefits : ",_599BenefitsFromExcel);

        testVerifyLog("Verify Forth plan 2GB/Day details are same on screen and excel sheet.");

        return _599Plans.trim().contains(_599PlansFromExcel) &&
                _599Validity.trim().contains(_599ValidityFromExcel) &&
                _599Benefits.trim().contains(_599BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDayFifthPlansPricingNegative() throws IOException {
        _444Plans = getText(lstPlans.get(4));
        _444PlansFromExcel = ZainProvider.getCellData("JioPlansNegative",5,0);

        _444Validity = getText(lstValidity.get(4));
        _444ValidityFromExcel = ZainProvider.getCellData("JioPlansNegative",5,1);

        _444Benefits = getText(lstBenefits.get(4));
        _444BenefitsFromExcel= ZainProvider.getCellData("JioPlansNegative",5,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Fifth Plan Price : " , _444Plans );
        testInfoLog("Fifth Plan Validity : ", _444Validity);
        testInfoLog("Fifth Plan Benefits : ", _444Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Fifth plan price : " ,_444PlansFromExcel);
        testInfoLog("Fifth plan validity : " ,_444ValidityFromExcel);
        testInfoLog("Fifth Plan Benefits : ",_444BenefitsFromExcel);

        testVerifyLog("Verify Fifth plan 2GB/Day details are same on screen and excel sheet.");

        return _444Plans.trim().contains(_444PlansFromExcel) &&
                _444Validity.trim().contains(_444ValidityFromExcel) &&
                _444Benefits.trim().contains(_444BenefitsFromExcel.trim());
    }

    public boolean verify2GBPerDaySixthPlansPricingNegative() throws IOException {

        _249Plans = getText(lstPlans.get(5));
        _249PlansFromExcel = ZainProvider.getCellData("JioPlansNegative",6,0);

        _249Validity = getText(lstValidity.get(5));
        _249ValidityFromExcel = ZainProvider.getCellData("JioPlansNegative",6,1);

        _249Benefits = getText(lstBenefits.get(5));
        _249BenefitsFromExcel= ZainProvider.getCellData("JioPlansNegative",6,2);

        testCaseLog("----------------Details on Jio Popular Plans Page-------------");
        testInfoLog("Sixth Plan Price : " , _249Plans );
        testInfoLog("Sixth Plan Validity : ", _249Validity);
        testInfoLog("Sixth Plan Benefits : ", _249Benefits);

        testCaseLog("----------------Details of Jio Popular Plans in excel sheet -------------");
        testInfoLog("Sixth plan price : " ,_249PlansFromExcel);
        testInfoLog("Sixth plan validity : " ,_249ValidityFromExcel);
        testInfoLog("Sixth Plan Benefits : ",_249BenefitsFromExcel);

        testVerifyLog("Verify Sixth plan 2GB/Day details are same on screen and excel sheet.");

        return _249Plans.trim().contains(_249PlansFromExcel.trim()) &&
                _249Validity.trim().contains(_249ValidityFromExcel.trim()) &&
                _249Benefits.trim().contains(_249BenefitsFromExcel.trim());
    }


}
