package com.framework.init;



import com.TBlocks_POC.TblocksIndexPage;
import com.TBlocks_POC.TblocksVerification;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.framework.common.Common;
import com.framework.configurations.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.lang.reflect.Method;


/**
 * Created by Rutu shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: TBLOCKS_Web_Zain_POC
 */

public class SeleniumInit extends Common implements Configuration {

    public WebDriver driver;
    public static String testUrl;
    public static String _methodName;

    protected TblocksIndexPage tblocksIndexPage;
    protected TblocksVerification tblocksVerification;


    @BeforeSuite(alwaysRun = true)
    public void startReport(ITestContext testContext) {
        ExtentReporter.initializeReport(testContext.getCurrentXmlTest().getSuite().getName());
    }
//
//    /**
//     * To initialize the driver before executing the test cases
//     *
//     * @param method Test Method Instance
//     */
//    @BeforeMethod(alwaysRun = true)
//    public void setUp(Method method) {
//
//        DesiredCapabilities capability;
//
//        switch (BROWSER.toLowerCase()){
//            case "firefox":
//            case "mozilla firefox":
//                capability = BrowserCaps.configureMozillaFirefox();
//                driver = new FirefoxDriver(capability);
//                break;
//            case "chrome":
//            case "google chrome":
//            default:
//                capability = BrowserCaps.configureGoogleChrome();
//                driver = new ChromeDriver(capability);
//                break;
//        } // end of  first switch
//
//        implicitWaitOf(driver, 10);
//        maximizeWindow(driver);
//
//        if (method.getName().startsWith("zain")) {
//
//            tblocksIndexPage = new TblocksIndexPage(driver);
//            tblocksVerification = new TblocksVerification(driver);
//
//            testUrl = ZAIN_URL;
//            openURL(driver, testUrl);
//
//        }else  if (method.getName().startsWith("jio")){
//
//            tblocksIndexPage = new TblocksIndexPage(driver);
//            tblocksVerification = new TblocksVerification(driver);
//
//            testUrl = JIO_PLANS_URL;
//            openURL(driver,testUrl);
//        }
//
//    }

    @Parameters("browser")
    @BeforeClass(alwaysRun=true)
    // Passing Browser parameter from TestNG xml
    public void beforeTest(String browser) {

        // If the browser is Firefox, then do this
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "E:\\TBLOCKS_WEB_POC\\geckodriver.exe");
            driver = new FirefoxDriver();

            implicitWaitOf(driver, 10);
            maximizeWindow(driver);

            tblocksIndexPage = new TblocksIndexPage(driver);
            tblocksVerification = new TblocksVerification(driver);

            //testUrl = "https://www.jio.com/en-in/4g-plans";
            testUrl = ZAIN_URL;
            driver.get(testUrl);

            // If browser is chrome, then do this
        }else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\TBLOCKS_WEB_POC\\chromedriver.exe");
            driver = new ChromeDriver();

            implicitWaitOf(driver, 10);
            maximizeWindow(driver);

            tblocksIndexPage = new TblocksIndexPage(driver);
            tblocksVerification = new TblocksVerification(driver);

            testUrl = "https://sa.zain.com/en";
            driver.get(testUrl);
        }

        System.out.println("======" + testUrl + "=========");
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
                failure();

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
        ExtentReporter.flushReport();
    }

}