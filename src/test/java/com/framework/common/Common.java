package com.framework.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

/**
 * Created by Rutu shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: TBLOCKS_Web_Zain_POC
 */

public class Common {

    protected static Wait<WebDriver> wait;

    /**
     * Scroll Horizontal in Page
     *
     * @param driver  WebDriver Instance
     * @param element WebElement
     */
    public static void scrollToHorizontal(WebDriver driver, WebElement element) {

        Actions action = new Actions(driver);
        WebElement draggablePartOfScrollbar = element;

        int numberOfPixelsToDragTheScrollbarDown = 50;

        for (int i = 10; i < 500; i = i + numberOfPixelsToDragTheScrollbarDown) {
            try {
                action.moveToElement(draggablePartOfScrollbar).clickAndHold()
                        .moveByOffset(numberOfPixelsToDragTheScrollbarDown, 0).release().perform();
                Thread.sleep(1000L);
            } catch (Exception e1) {
                log("Failed to scroll Horizontal");
            }
        }
    }

    public static void scrollToVertical(WebDriver driver, WebElement element) {

        Actions action = new Actions(driver);
        WebElement draggablePartOfScrollbar = element;

        int numberOfPixelsToDragTheScrollbarDown = 50;
        for (int i = 10; i < 500; i = i + numberOfPixelsToDragTheScrollbarDown) {
            try {
                action.moveToElement(draggablePartOfScrollbar).clickAndHold()
                        .moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release().perform();
                Thread.sleep(1000L);
            } catch (Exception e1) {
                log("Failed to scroll vertical");
            }
        }

    }

    public static void checkChkBox(WebElement element) {
        boolean isCheckBoxSet;
        isCheckBoxSet = element.isSelected();
        if (!isCheckBoxSet) {
            element.click();
        }
    }

    public static void switchToAlert(WebDriver webDriver) {
        try {
            webDriver.switchTo().alert();
        } catch (Exception e) {
            log("Failed to switch to the Alert");
        }
    }

    public static void openMailinator(WebDriver driver, String emailAddress) {
        String url = "https://www.mailinator.com/";
        goToUrl(driver, url);
        WebElement eleInbox = driver.findElement(By.xpath(".//*[@id='inboxfield']"));
        eleInbox.sendKeys(emailAddress);
        driver.findElement(By.xpath("//button[contains(@class,'btn-dark')]")).click();
        Generics.pause(2);
    }

    public static void openEmail(WebDriver driver) {
        WebElement eleFrame = driver.findElement(By.xpath("//iframe[@id='msg_body']"));
        driver.switchTo().frame(eleFrame);
        Generics.pause(1);
        WebElement eleInbox = driver.findElement(By.xpath("//div//div[contains(.,'Verify your email')]"));
        eleInbox.click();
        Generics.pause(1);
        WebElement eleBtnVerify = driver.findElement(By.xpath("//td/a[contains(.,'Verify my email')]"));
        eleBtnVerify.click();
        Generics.pause(1);
    }

    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static String replaceString(String baseString, String targetString, String replaceString) {
        String newString = baseString.replace(targetString, replaceString);
        return newString;
    }

    public static void openNewTab(WebDriver driver) {
        String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND, "t");
        driver.findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);
        Generics.pause(3);
    }

    public static void JsopnNewtab(WebDriver driver) {
        Generics.pause(5);
        System.out.println("===========" + System.getProperty("os.name"));

        ((JavascriptExecutor) driver).executeScript("window.open();");
        Generics.pause(3);

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Generics.pause(3);

    }

    public static void SwitchtoTab(WebDriver driver, int tabNumber) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    public static void openPrivareWindow(WebDriver driver) {
        driver.findElement(By.xpath("//body")).sendKeys(Keys.CONTROL + "t" + "n");
        Generics.pause(3);
    }

    public static void logStatus(String Status) {
        System.out.println(Status);
        if (Status.equalsIgnoreCase("Pass")) {
            log("<br><Strong><font color=#008000>Pass</font></strong></br>");
        } else if (Status.equalsIgnoreCase("Fail")) {
            log("<br><Strong><font color=#FF0000>Fail</font></strong></br>");

        }

    }

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
    public static void log(String msg) {

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

    public static boolean isElementNotDisplayed(WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Wait(max. 1 minute) till given element does not disappear from page.
     *
     * @param by Locator of element.
     * @return Is element display or not
     */
    public static boolean waitForElementIsDisplayed(WebElement by) {

        for (int second = 0; ; second++) {
            if (second >= 60) {

                break;
            }
            try {
                if (isElementDisplayed(by))
                    break;
            } catch (Exception e) {
            }
            Generics.pause(1);
        }
        return false;
    }

    public static boolean isChecked(WebElement element) {
        return element.isSelected();
    }

    public static boolean isElementDisplayed(WebDriver driver, WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Set data in to clipboard
     *
     * @param string String to set
     */
    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    /**
     * Checks whether the visibility of Element Located
     *
     * @param by get locator By
     * @return is Element is visible or not
     */
    public static ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
        return new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(by);
                return element.isDisplayed() ? element : null;
            }
        };
    }

    public static void waitForElement(WebDriver driver, String xpath) {
        wait = new WebDriverWait(driver, 600);
        try {
            // wait.until(visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
        }
    }

    /**
     * Finds handle to second window other than given handle to current window and
     * switches to as well.
     *
     * @param driver              WebDriver
     * @param handleCurrentWindow Current WindowHandle Instance
     * @return handleSecondWindow
     */
    public static String findAndSwitchToSecondWindow(WebDriver driver, String handleCurrentWindow) {

        Generics.pause(1);
        Set<String> windows = driver.getWindowHandles();
        String handleSecondWindow = null;
        for (String window : windows) {
            if (!window.contains(handleCurrentWindow)) {
                handleSecondWindow = window;
            }
        }

        // Switch to the second window.
        try {

            Generics.pause(2000);

            driver.switchTo().window(handleSecondWindow);

        } catch (Throwable failure) { // If there is problem in switching
            // window, then re-try.

            Generics.pause(1000);

            driver.switchTo().window(handleSecondWindow);

        }

        return handleSecondWindow;

    }

    /**
     * Select data from drop down or combo box by Value.
     *
     * @param element WebElement
     * @param value   Value
     */
    public static void selectFromCombo(WebElement element, String value) {

        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * Select data form dropdown or combo box by visible element
     *
     * @param element WebElement
     * @param value   Visible Value
     */
    public static void selectFromComboByVisibleElement(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    /**
     * Wait up to By element present
     *
     * @param driver  WebDriver
     * @param element WebElement
     */
    public static void waitForElement(WebDriver driver, By element) {

        try {
            wait = new WebDriverWait(driver, 750);
            // wait.until(visibilityOfElementLocated(element));
        } catch (Exception e) {
        }
    }

    /**
     * Clicks on visible or not visible element.
     *
     * @param driver  WebDriver
     * @param element Web element.
     */

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

    public static String getText(WebDriver driver, WebElement element) {
        String text;
        try {
            text = element.getText();
        } catch (Exception e) {
            text = "Element was not found";
        }
        return text;
    }

    /**
     * Get text in of given Element using JavaScript
     *
     * @param driver  WebDriver
     * @param element webElement
     * @return Element Text
     */
    public static String getTextJS(WebDriver driver, WebElement element) {
        return (String) ((JavascriptExecutor) driver).executeScript("return jQuery(arguments[0]).text();", element);
    }

    public String getValue(WebDriver driver, WebElement element) {
        return element.getAttribute("value");
    }

    public static void waitForConditionIsElementPresent(WebDriver driver, WebElement element) {

        for (int second = 0; ; second++) {
            if (second >= 10) {
                break;
            }
            try {
                if (isElementDisplayed(element))
                    break;
            } catch (Throwable failure) {
            }

            Generics.pause(1000);
        }

    }


    public static int randomNumericValueGenerate(int length) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(length);
        return randomInt;
    }

    public static void type(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    /**
     * Wait till all ajax calls finish.
     *
     * @param driver WebDriver
     * @param num    Number of ajax calls to finish.
     */
    public static void waitForAjax(WebDriver driver, String num) {

        String ajax;

        ajax = ajaxFinised(driver, num);

        for (int second = 0; ; second++) {
            if (second >= 20) {
                break;
            } else if (ajax.equals("true")) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Wait till ajax call finish.
     *
     * @param driver WebDriver
     * @throws InterruptedException InterruptedException
     */
    public void waitForAjax(WebDriver driver) throws InterruptedException {

        String ajax;
        ajax = ajaxFinised(driver, "1");

        for (int second = 0; ; second++) {
            if (second >= 15) {
                break;
            } else if (ajax.equals("true")) {
                break;
            }
            Thread.sleep(1000);
        }

    }

    /**
     * Checks that all ajax calls are completed on page.
     *
     * @param driver WebDriver
     * @param num    Number of ajax calls to wait for completion.
     * @return "true" if completed else "false".
     */
    public static String ajaxFinised(WebDriver driver, String num) {

        Object isAjaxFinished;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        isAjaxFinished = js.executeScript("return jQuery.active == " + num);

        return isAjaxFinished.toString();

    }

    public static String selectRandomOptionFromCombo(WebElement eleDropDown, WebDriver driver)
            throws InterruptedException {
        String selectedOption = "";
        // WebElement selectCombo = driver.findElement(by);
        Thread.sleep(2);
        List<WebElement> getAllOption = eleDropDown.findElements(By.xpath("option"));
        ArrayList<String> arrayOfAllOption = new ArrayList<String>();

        for (WebElement ele : getAllOption) {

            if (!ele.getText().startsWith("Select")) {
                arrayOfAllOption.add(ele.getText());
            }

        }
        int index = new Random().nextInt(arrayOfAllOption.size());

        if (Integer.signum(index) == -1) {
            index = -index;
            // index=Math.abs(index);
        }
        selectedOption = arrayOfAllOption.get(index);
        System.out.println("Selected Option Is----====>" + selectedOption);
        return selectedOption;
    }

    /**
     * Get Total Number Of Elements
     *
     * @param driver WebDriver
     * @param by     Search Element By
     * @return interger number of total elements
     */
    public static int getNumOfElements(WebDriver driver, By by) {
        int i = 0;
        List<WebElement> ele = driver.findElements(by);
        i = ele.size();
        System.out.println("Total Number Of Elements Are >>> " + i);
        return i;
    }

    /**
     * Refresh Current Page
     *
     * @param driver WebDriver
     */
    public static void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    /**
     * Open URL in New Window
     *
     * @param driver WebDriver
     * @param url    String URL
     */
    public static void openUrlInNewTab(WebDriver driver, String url) {
        System.out.println("--------->" + System.getProperty("os.name"));
        if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
            driver.findElement(By.tagName("body")).sendKeys(Keys.COMMAND + "t");
        } else {
            driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
        }
        driver.get(url);
    }

    /**
     * Close Current Tab In Web Browser
     *
     * @param driver WebDriver
     */
    public static void closeCurrentTab(WebDriver driver) {

        if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
            driver.findElement(By.tagName("body")).sendKeys(Keys.COMMAND + "w");
        } else {
            driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");
        }

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
     * Perform Mouse Hover using java sript executer
     *
     * @param driver WebDriver
     * @param ele    WebElement
     */
    public static void mouseHoverUsingJS(WebDriver driver, WebElement ele) {
        String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
        ((JavascriptExecutor) driver).executeScript(mouseOverScript, ele);
    }

    /**
     * Go to URL.
     *
     * @param driver WebDriver
     * @param url    String URL
     */
    public static void goToUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    /**
     * Go to previous page
     *
     * @param driver WebDriver
     */
    public static void goToPreviuosPage(WebDriver driver) {
        driver.navigate().back();
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
        Generics.pause(2);
    }

    /**
     * Stop page loading
     *
     * @param driver WebDriver Instance
     */
    public static void stopPageLoading(WebDriver driver) {
        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
    }

    public static void jsClickNew(WebDriver driver, WebElement element) {
        // ((JavascriptExecutor) driver).executeScript(
        // "return
        // ((document.getElementsByTagName('object')[0]).contentDocument).arguments[0].click();",
        // element);

        // this.waitForAjax("0");
    }


}
