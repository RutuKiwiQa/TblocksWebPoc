package com.framework.init;



import com.Zain.ZainIndexPage;
import com.Zain.ZainVerification;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.framework.common.Generics;
import com.framework.configurations.Configuration;
import com.framework.logger.TestLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


/**
 * Created by Rutu shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: TBLOCKS_Web_Zain_POC
 */

public class SeleniumInit extends Generics implements Configuration {

    public WebDriver driver;
    public static String _methodName;
    protected static WebDriverWait wait;
    public static String testUrl;

    protected ZainIndexPage zainIndexPage;
    protected ZainVerification zainVerification;


    @BeforeSuite(alwaysRun = true)
    public void startReport(ITestContext testContext) {
        ExtentInitializer.initializeReport(testContext.getCurrentXmlTest().getSuite().getName());
    }

    /**
     * To initialize the driver before executing the test cases
     *
     * @param method Test Method Instance
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {

        DesiredCapabilities capability;

                switch (BROWSER.toLowerCase()){
                    case "firefox":
                    case "mozilla firefox":
                        capability = BrowserCaps.configureMozillaFirefox();
                        driver = new FirefoxDriver(capability);
                        break;
                    case "chrome":
                    case "google chrome":
                    default:
                        capability = BrowserCaps.configureGoogleChrome();
                        driver = new ChromeDriver(capability);
                        break;
                } // end of  first switch

        implicitWaitOf(driver, 10);
        maximizeWindow(driver);

        zainIndexPage = new ZainIndexPage(driver);
        zainVerification = new ZainVerification(driver);

        testUrl = URL;
        openURL(driver, testUrl);

    }

    /**
     * To close the resources once the test execution is completed
     *
     * @param testResult Test Result
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {

        String testName;

        ITestContext ex = testResult.getTestContext();

        try {
            testName = testResult.getName();
            if (testResult.getStatus() == ITestResult.FAILURE) {

                logger.log(Status.FAIL, MarkupHelper.createLabel(testName + " - Test Case Failed", ExtentColor.RED));
                logger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));
                String screenshotPath = getExtentScreenShot(driver, testName);
                logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));

                System.out.println();
                System.out.println("TEST FAILED - " + testName);
                System.out.println();
                System.out.println("ERROR MESSAGE: " + testResult.getThrowable());
                System.out.println("\n");

                Reporter.setCurrentTestResult(testResult);

                String screenshotName = getCurrentTimeStampString() + testName;

                makeScreenshot(driver, screenshotName);
                TestLogger.failure();

                getShortException(ex.getFailedTests());

            } else if ((testResult.getStatus() == ITestResult.SUCCESS)) {
                logger.log(Status.PASS, MarkupHelper.createLabel(testName + " Test Case PASSED", ExtentColor.GREEN));
                System.out.println("TEST PASSED - " + testName + "\n");
            } else if ((testResult.getStatus() == ITestResult.SKIP)) {
                logger.log(Status.SKIP, MarkupHelper.createLabel(testName + " - Test Case Skipped", ExtentColor.ORANGE));
            }

            deleteCookies(driver);
            close(driver);
            quit(driver);

        } catch (Exception throwable) {
            System.err.println("Exception ::\n" + throwable);
        } finally {
            if (BrowserCaps.browserName.contains("internet explorer")) {
                deleteCookies(driver);
                killIEServer();
                pause(5);
            }
            deleteDownloadDirectory();
        }
    }

    /**
     * To flush the extent report details.
     */
    @AfterSuite(alwaysRun = true)
    public void endReport() {
        ExtentInitializer.flushReport();
    }

}