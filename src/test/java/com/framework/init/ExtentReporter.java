package com.framework.init;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.configurations.Configuration;

import java.io.File;

/**
 * Created by Rutu shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: TBLOCKS_Web_Zain_POC
 */
public class ExtentReporter implements Configuration {

    protected static ExtentReports extent;
    protected static ExtentTest logger;

    static void initializeReport(String suiteName) {

        File directory = new File(PROJECT_DIR + File.separator + "ExtentReports");
        if (!directory.exists()) {
            directory.mkdir();
        }

        ExtentHtmlReporter htmlReporter;
        htmlReporter = new ExtentHtmlReporter(PROJECT_DIR + File.separator + "ExtentReports" +
                File.separator + "Report_" + suiteName + "_" + ".html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS : ", System.getProperty("os.name"));
        extent.setSystemInfo("OS Architecture : ", System.getProperty("os.arch"));
        extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
        extent.setSystemInfo("User Name : ", System.getProperty("user.name"));
        extent.setSystemInfo("Machine Name : ", System.getProperty("machine.name"));
        extent.setSystemInfo("IP Address : ", System.getProperty("machine.address"));
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);

        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("TBlocks Automation Test Report");
        htmlReporter.config().setReportName("<img src='https://www.kiwiqa.com/wp-content/uploads/2017/06/KiwiQA_option2.png' " +
                "width='auto' height='40' style='margin-top: 5px;' align='center'/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" );
    }

    static void flushReport() {
        extent.flush();
    }

}