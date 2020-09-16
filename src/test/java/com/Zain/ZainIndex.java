package com.Zain;

import com.utils.ZainProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.*;
import java.util.List;

public class ZainIndex extends ZainProvider {

    public ZainIndex() throws IOException {
    }

    @Test(dataProvider = "Zain")
    public void testCaseScenario_01(String username, String password) throws IOException {

        int numOfFailedSteps = 0;
        _logStep = 1;

        testCaseLog("Zain_TestScenario :: To perform login, verify Dashboard and Add device from E-Shop");

        zainIndexPage.getVersion();

        pause(10);

        testVerifyLog("To verify that user can see the home page of the \" Zain Web Application \" .");
        if(zainVerification.verifyZainHomeScreen()){
            stepPassed();
        }else{
            stepFailure(driver);
            numOfFailedSteps++;
        }

        zainVerification = zainIndexPage.clickOnMyZainAccount();

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
        if (zainVerification.verifyLoginScreen()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        zainVerification = zainIndexPage.loginAs(username,password);

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
        if(zainVerification.verifyZainDashboardScreen()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        zainVerification = zainIndexPage.clickOnEshopTab();

        testVerifyLog("Verify user can see E-Shop Screen's content.");
        if (zainVerification.verifyEShopScreenContent()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        zainVerification = zainIndexPage.clickOnFirstProduct();

        testVerifyLog("Verify selected product screen.");
        if (zainVerification.verifySelectedProductScreen()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        zainVerification = zainIndexPage.getfirstProductThumbnail();

        testVerifyLog("Verify user can see information page of the thumbnail.");
        if (zainVerification.verifyThumnailInformationPage()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }

        testVerifyLog("Verify select Iphone SE with black color and model number");
        if (zainVerification.verifyBlackModel()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }


      //  zainVerification = zainIndexPage.changeColorToWhiteAndModel128();

//        testVerifyLog("Verify price of selected thumbnail with color white and model 128 GB");
//        if (zainVerification.verifyWhiteModel()){
//            stepPassed();
//        }else {
//            stepFailure(driver);
//            numOfFailedSteps++;
//        }

//        zainVerification = zainIndexPage.changeColorToRedAndModel256();

//        testVerifyLog("Verify price of selected thumbnail with color red and model 256 GB");
//        if (zainVerification.verifyRedModel()){
//            stepPassed();
//        }else {
//            stepFailure(driver);
//            numOfFailedSteps++;
//        }
//
         zainVerification = zainIndexPage.clickOnLogoutButton();

        testVerifyLog("Verify the user is logout successfully.");
        if (zainVerification.verifyUserLogoutSuccessFully()){
            stepPassed();
        }else {
            stepFailure(driver);
            numOfFailedSteps++;
        }



        if (numOfFailedSteps > 0) Assert.fail("Test Verification failed, please check test logs.");

    }






}

