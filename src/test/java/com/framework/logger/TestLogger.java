package com.framework.logger;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.framework.configurations.Configuration;
import com.framework.init.ExtentInitializer;
import org.testng.Reporter;

/**
 * Created by Rutu shah.
 * Date: 2020-07-29
 * Time:
 * Project Name: TAG
 */

public class TestLogger extends ExtentInitializer implements Configuration {

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
     * To log the Confirmation Message comes during the test
     *
     * @param log Confirmation Message
     */
    public static void testConfirmationLog(String log) {
        logger.info(MarkupHelper.createLabel(log, ExtentColor.TEAL));
        log("Confirmation Message : <Strong><font color=#008000>" + log + "</strong></font>");
    }

    /**
     * To log the Warning Message comes during the test
     *
     * @param log Warning Message
     */
    public static void testWarningLog(String log) {
        logger.warning(MarkupHelper.createLabel(log, ExtentColor.AMBER));
        log("<img src=\"warning.png\" alt=\"Warning\" height=\"18\" width=\"18\">Warning Message : <Strong><font color=#FF1870>" + log + "</strong></font>");
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