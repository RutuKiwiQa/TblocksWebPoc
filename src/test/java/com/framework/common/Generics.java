package com.framework.common;

import com.framework.configurations.Configuration;
import com.framework.init.SeleniumInit;
import com.framework.logger.TestLogger;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IResultMap;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rutu shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: TBLOCKS_Web_Zain_POC
 */

public class Generics extends TestLogger {

    protected static int _logStep = 1;

    protected static WebDriverWait wait;

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
     * To click on particular WebElement
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void clickOn(WebDriver driver, WebElement element) {
        pause(1);
        try {
            element.click();
        } catch (ElementClickInterceptedException ex) {
            clickOnJS(driver, element);
        }
    }

    public static void clickOnJS(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void jsClick(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].click();", element);
        // this.waitForAjax("0");
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
            testWarningLog("Failed to capture screenshot: " + e.getMessage());
        }
        testInfoLog("Step Failure<br>Please check attached screenshot : <br><br>", getScreenshotLink(nameWithExtension));
    }

    public static String getScreenshotLink(String screenshot_name) {
        return "<img src='../test-output/screenshots/" + screenshot_name + "' width='683' height='384'/>";
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

    public static String getCurrentTimeStampString() {

        Date date = new Date();

        SimpleDateFormat sd = new SimpleDateFormat("MMddHHmmssSS");
        TimeZone timeZone = TimeZone.getDefault();
        Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
        sd.setCalendar(cal);
        return sd.format(date);
    }

    public void stepFailure(WebDriver driver) {
        makeScreenshot(driver, getCurrentTimeStampString());
        TestLogger.failure();
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
}



