package com.framework.utility;

import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;


/**
 * Created by Rutu shah.
 * Date: 2020-07-29
 * Time:
 * Project Name: TAG
 */

public class RetryCounterManagerListener implements ITestListener {
    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }

    /**
     * Manage Retry Analyzer Counter if Test Fail
     *
     * @param context Test Context
     */
    public void onFinish(ITestContext context) {
        Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
        for (ITestResult temp : failedTests) {
            ITestNGMethod method = temp.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                failedTests.remove(temp);
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    failedTests.remove(temp);
                }
            }
        }
    }
}
