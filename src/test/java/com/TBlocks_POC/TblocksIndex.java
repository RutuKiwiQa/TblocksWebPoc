package com.TBlocks_POC;

import com.framework.common.Common;
import com.utils.ZainProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TblocksIndex extends ZainProvider {

    public TblocksIndex() throws IOException {
    }

    @Test(dataProvider = "Zain")
    public void zain_verifyLogin_Dashboard_Price(String username, String password) throws IOException {

        int numOfFailedSteps = 0;
        _logStep = 1;

        testCaseLog("TS_WEB_001 ::  To perform login, verify Dashboard and Add device from E-Shop and price verification.");

        tblocksIndexPage.getVersion();

        pause(10);

        testVerifyLog("To verify that user can see the home page of the \" Zain Web Application \" .");
        if(tblocksVerification.verifyZainHomeScreen()){
            stepPassed();
        }else{
            stepFailure(driver);
            numOfFailedSteps++;
        }

        tblocksVerification = tblocksIndexPage.clickOnMyZainAccount();

        testVerifyLog("Verify that user can see \" Login Screen \" of zain web application with following fields." +
                "<br> 1. Zain Logo " +
                "<br> 2. Login Panel " +
                "<br> 3. Register Panel" +
                "<br> 4. Personal Tab" +
                "<br> 5. Business Tab.\n" +
                "<br> 6. E-Shop Tab.\n" +
                "<br> 7. I am looking for Search field.\n" +
                "<br> 8. Follow us Icons\n" +
                "<br> 9. Footer Text\n" +
                "<br> 10. Header Hyperlinks\n");
        if (tblocksVerification.verifyLoginScreen()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        tblocksVerification = tblocksIndexPage.loginAs(username,password);

        testVerifyLog("Verify user is directed to the dashboard screen after successful login and verify following details." +
                "<br> 1. Logged in user name\n" +
                "<br> 2. Add to cart button\n" +
                "<br> 3. Zain Logo\n" +
                "<br> 4. Personal Tab\n" +
                "<br> 5. Business Tab\n" +
                "<br> 6. E-Shop Tab\n" +
                "<br> 7. 5G Tab\n" +
                "<br  8. Notifications dropdown\n" +
                "<br> 9. I am looking for Search field.\n" +
                "<br> 10. Profile Picture of user.\n" +
                "<br> 11. Name \n" +
                "<br> 12. Nickname\n");
        if(tblocksVerification.verifyZainDashboardScreen()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        tblocksVerification = tblocksIndexPage.clickOnEshopTab();

        testVerifyLog("Verify user can see E-Shop Screen's content.");
        if (tblocksVerification.verifyEShopScreenContent()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        tblocksVerification = tblocksIndexPage.clickOnFirstProduct();

        testVerifyLog("Verify selected product screen.");
        if (tblocksVerification.verifySelectedProductScreen()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        tblocksVerification = tblocksIndexPage.getfirstProductThumbnail();

        testVerifyLog("Verify user can see information page of the thumbnail.");
        if (tblocksVerification.verifyThumnailInformationPage()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify select Iphone SE with black color and model number");
        if (tblocksVerification.verifyBlackModel()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }


      //  tblocksVerification = tblocksIndexPage.changeColorToWhiteAndModel128();

//        testVerifyLog("Verify price of selected thumbnail with color white and model 128 GB");
//        if (tblocksVerification.verifyWhiteModel()){
//            stepPassed();
//        }else {
//            stepFailure(driver);
//            numOfFailedSteps++;
//        }

//        tblocksVerification = tblocksIndexPage.changeColorToRedAndModel256();

//        testVerifyLog("Verify price of selected thumbnail with color red and model 256 GB");
//        if (tblocksVerification.verifyRedModel()){
//            stepPassed();
//        }else {
//            stepFailure(driver);
//            numOfFailedSteps++;
//        }
//
         tblocksVerification = tblocksIndexPage.clickOnLogoutButton();

        testVerifyLog("Verify the user is logout successfully.");
        if (tblocksVerification.verifyUserLogoutSuccessFully()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }



        if (numOfFailedSteps > 0) Assert.fail("Test Verification failed, please check test logs.");

    }

    @Test()
    public void jio_verify2GBPlansPositiveFlow() throws IOException {
        int numOfFailedSteps = 0;
        _logStep = 1;

        testCaseLog("TS_WEB_003 :: To verify 2 GB/Day Packs pricing of plans, validity and benefits.");

        pause(5);

        testVerifyLog("Verify user can see Jio plans screen.");
        if (tblocksVerification.verifyJioPlansScreen()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify first plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDayFirstPlansPricing()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify second plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDaySecondPlansPricing()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify third plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDayThirdPlansPricing()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify forth plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDayForthPlansPricing()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify fifth plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDayFifthPlansPricing()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify sixth plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDaySixthPlansPricing()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        if (numOfFailedSteps > 0) Assert.fail("Test Verification failed, please check test logs.");
    }

    @Test()
    public void jio_verify2GBPlansNegativeFlow() throws IOException {
        int numOfFailedSteps = 0;
        _logStep = 1;

        testCaseLog("TS_WEB_004 :: To verify 2 GB/Day Packs pricing of plans, validity and benefits Negative flow.");

        pause(5);

        testVerifyLog("Verify user can see Jio plans screen.");
        if (tblocksVerification.verifyJioPlansScreen()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify first plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDayFirstPlansPricingNegative()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify second plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDaySecondPlansPricingNegative()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify third plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDayThirdPlansPricingNegative()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify forth plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDayForthPlansPricingNegative()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify fifth plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDayFifthPlansPricingNegative()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify pricing of 2GB/Day plans should be as below " +
                "<br> Verify sixth plan of 2GB/Day Page.");
        if (tblocksVerification.verify2GBPerDaySixthPlansPricingNegative()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        if (numOfFailedSteps > 0) Assert.fail("Test Verification failed, please check test logs.");
    }

}

