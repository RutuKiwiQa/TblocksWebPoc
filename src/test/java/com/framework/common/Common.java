package com.framework.common;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.framework.init.ExtentReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.*;
import org.testng.IResultMap;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rutu shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: TBLOCKS_Web_Zain_POC
 */

public class Common extends ExtentReporter {

    protected static int _logStep = 1;

    protected static WebDriverWait wait;

    /**
     * Gets current time in the following format Month, Date, Hours, Minutes,
     * Seconds, Millisecond.
     *
     * @return Current date.
     */
    public static String getCurrentTimeStampString() {

        Date date = new Date();

        SimpleDateFormat sd = new SimpleDateFormat("MMddHHmmssSS");
        TimeZone timeZone = TimeZone.getDefault();
        Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
        sd.setCalendar(cal);
        return sd.format(date);
    }

    /**
     * Takes screenshot and adds it to TestNG report.
     *
     * @param driver         WebDriver instance.
     * @param screenshotName Screenshot path
     */
    public static void makeScreenshot(WebDriver driver, String screenshotName) {

        WebDriver augmentedDriver = new Augmenter().augment(driver);

        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtension = screenshotName + ".png";

        try {
            String reportFolder = "test-output" + File.separator;
            String screenshotsFolder = "screenshots";
            File screenshotFolder = new File(reportFolder + screenshotsFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            FileUtils.copyFile(screenshot,
                    new File(screenshotFolder + File.separator + nameWithExtension).getAbsoluteFile());
        } catch (IOException e) {
            log("Failed to capture screenshot: " + e.getMessage());
        }
        log(getScreenshotLink(nameWithExtension, nameWithExtension));
    }

    /**
     * Log given message to Reporter output.
     *
     * @param msg Message/Log to be reported.
     */
    public static void log1(String msg) {
        System.out.println(msg);
        Reporter.log(msg);
    }

    /**
     * Generates link for TestNG report.
     *
     * @param screenshot_name Screenshot name.
     * @param link_text       Link text.
     * @return Formatted link for TestNG report.
     */
    public static String getScreenshotLink(String screenshot_name, String link_text) {

        log("<br><Strong><font color=#FF0000>--- Failure Screen Image ---</font></strong><br>");
        return "<a href='../test-output/screenshots/" + screenshot_name + "' target='_new'>" + link_text + "</a>";
    }

    /**
     * Checks whether the needed WebElement is displayed or not.
     *
     * @param element Needed element
     * @return true or false.
     */
    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public static void jsClick(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("return arguments[0].click();", element);
        // this.waitForAjax("0");
    }

    /**
     * Highlight the element and click on same
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void clickOn(WebDriver driver, WebElement element) {
        highlightElement(driver, element);
        element.click();
    }


    public static void clickOnJS(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


    /**
     * Mouse Hover in Web element
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void mouseOver(WebDriver driver, WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();

    }

    /**
     * Perform Mouse Hover on element
     *
     * @param driver WebDriver
     * @param ele    WebElement
     */
    public static void mouseHover(WebDriver driver, WebElement ele) {
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
    }

    /**
     * Highlight Element
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void highlightElement(WebDriver driver, WebElement element) {
        /*
         * for (int i = 0; i < 2; i++) { JavascriptExecutor js = (JavascriptExecutor)
         * driver; js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
         * element, "color: yellow; border: 2px solid yellow;");
         * js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
         * element, ""); }
         */

        // draw a border around the found element

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '3px solid yellow'", element);
        pause(2);
    }

    /**
     * unHighlight Element
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void unhighlightElement(WebDriver driver, WebElement element) {
        /*
         * for (int i = 0; i < 2; i++) { JavascriptExecutor js = (JavascriptExecutor)
         * driver; js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
         * element, "color: yellow; border: 2px solid yellow;");
         * js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
         * element, ""); }
         */

        // draw a border around the found element
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '0px solid yellow'", element);
        pause(1);
    }

    /**
     * Pause for passed seconds
     *
     * @param secs Time in Seconds
     */
    public static void pause(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException interruptedException) {
            System.out.println("Failure in Pause.");
        }
    }

    public static WebElement explicitWait(WebDriver driver, By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    /**
     * To get text from the element
     *
     * @param element WebElement
     * @return Text from the WebElement
     */
    public static String getText(WebElement element) {
        //wait.until(ExpectedConditions.visibilityOfAllElements(element));
        return element.getText().trim();
    }

    /**
     * To check if element is available in page or not
     *
     * @param element WebElement
     * @return if web element display or not
     */
    public static boolean isElementDisplay(WebElement element) {
        return element.isDisplayed();
    }


    /**
     * To find element by given xpath locator
     *
     * @param driver  Instance of WebDriver
     * @param locator Locator String
     * @return WebElement by passed locator
     */
    public static WebElement findElementByXPath(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    /**
     * To open the URL in browser window
     *
     * @param driver WebDriver
     * @param url    URL String
     */
    public static void openURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void close(WebDriver driver) {
        driver.close();
    }

    public static int sizeOf(List list) {
        return list.size();
    }

    /**
     * To get text from the element
     *
     * @param element WebElement
     * @return Text from the WebElement
     */
    public static String getInnerValue(WebElement element) {
        return element.getAttribute("value").trim();
    }

    /**
     * To get the failure exception in single line
     *
     * @param tests Test Result
     */
    public static void getShortException(IResultMap tests) {

        for (ITestResult result : tests.getAllResults()) {

            Throwable exception = result.getThrowable();
            List<String> msgs = Reporter.getOutput(result);
            boolean hasReporterOutput = msgs.size() > 0;
            boolean hasThrowable = exception != null;
            if (hasThrowable) {
                boolean wantsMinimalOutput = result.getStatus() == ITestResult.SUCCESS;
                if (hasReporterOutput) {
                    testInfoLog((wantsMinimalOutput ? "Expected Exception" : "Failure Reason:"), "");
                }

                String str = Utils.shortStackTrace(exception, true);
                System.out.println(str);
                Scanner scanner = new Scanner(str);
                String firstLine = scanner.nextLine();
                testValidationLog(firstLine);
            }
        }
    }

    /**
     * To kill IE Server Instance once execution completed
     */
    public static void killIEServer() {
        try {
            pause(5);
            String[] cmd = new String[3];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "taskkill /F /IM iexplore.exe";
            Process process = Runtime.getRuntime().exec(cmd);
            Process process1 = Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
            System.err.println(process + "" + process1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDownloadDirectory() {
        try {
            FileUtils.deleteDirectory(new File(FILE_DOWNLOAD_PATH));
        } catch (IOException io) {
            testValidationLog("Failed to delete the folder.");
        }
    }

    public static String getExtentScreenShot(WebDriver driver, String screenshot_name) {
        String destination = "";
        try {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            destination = System.getProperty("user.dir") + "/Screenshots/" + screenshot_name + dateName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public void stepFailure(WebDriver driver) {
        makeScreenshot(driver, getCurrentTimeStampString());
        failure();
    }

    public void stepPassed() {
        success();
    }

    public void deleteCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public void quit(WebDriver driver) {
        driver.quit();
    }

    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void implicitWaitOf(WebDriver driver, int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


    /**
     * To log the Test Message in report
     *
     * @param log Log Message
     */
    private static void log(String log) {
        System.out.println(log.replaceAll("<[^>]*>", ""));
        Reporter.log("<br></br>" + log);
    }

    /**
     * To log the Test Case Name in report
     *
     * @param log Log Message
     */
    public static void testCaseLog(String log) {
        logger = extent.createTest(log);
        logger.assignAuthor("Rutu Shah");
        log("<strong>" + log + "</strong>");
    }

    /**
     * To log the information passed during the test execution in report
     *
     * @param key   Key/Log Message
     * @param value Value/Entered Details
     */
    public static void testInfoLog(String key, String value) {
        logger.info(key + " : " + value);
        log("<strong>" + key + " : </strong><font color=#9400D3>" + value + "</font>");
    }

    /**
     * To log the test steps in the report.
     *
     * @param logStep Step Number
     * @param log     Step Information
     */
    public static void testStepsLog(int logStep, String log) {
        logger.info(log);
        log("Step " + logStep + " : " + log);
    }

    /**
     * To log the test verification steps
     *
     * @param log Verification Message
     */
    public static void testVerifyLog(String log) {
        logger.info(MarkupHelper.createLabel(log, ExtentColor.ORANGE));
        log("<img src=\"info.png\" alt=\"Info\" height=\"18\" width=\"18\"><font color=#000080>" + log + "</font>");
    }

    /**
     * To log the Validation Message comes during the test
     *
     * @param log Validation Message
     */
    public static void testValidationLog(String log) {
        logger.info(MarkupHelper.createLabel(log, ExtentColor.PINK));
        log("<img src=\"warning.png\" alt=\"Warning\" height=\"18\" width=\"18\">Validation Message : <Strong><font color=#ff0000>" + log + "</strong></font>");
    }


    /**
     * To log the test verification step is passed successfully
     */

    public static void success() {
        logger.pass(MarkupHelper.createLabel("PASS", ExtentColor.GREEN));
        System.out.println("<Strong><font color=#008000>Pass</font></strong>".replaceAll("<[^>]*>", ""));
        Reporter.log("<br></br><img src=\"pass.png\" height=\"18\" width=\"18\"><Strong><font color=#008000>Pass</font></strong>");
    }
    /**
     * To log test verification is failed
     */
    public static void failure() {
        logger.fail(MarkupHelper.createLabel("FAIL", ExtentColor.RED));
        System.out.println("<Strong><font color=#ff0000>Fail</font></strong>".replaceAll("<[^>]*>", ""));
        Reporter.log("<br></br><img src=\"fail.png\" alt=\"Fail\" height=\"18\" width=\"18\"><Strong><font color=#ff0000>Fail</font></strong>");
    }
}
