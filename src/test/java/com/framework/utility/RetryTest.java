package com.framework.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


/**
 * Created by Rutu shah.
 * Date: 2020-07-29
 * Time:
 * Project Name: TAG
 */

public class RetryTest implements IRetryAnalyzer {

    private int retryCounter = 0;

    public boolean retry(ITestResult result) {
        int maxRetryCounter = 2;
        if (retryCounter < maxRetryCounter) {
            System.out.println("Retrying test Execution: " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCounter + 1) + " time(s).");
            retryCounter++;
            return true;
        }
        return false;
    }

    private String getResultStatusName(int status) {
        String resultName = "";
        if (status == 1) resultName = "SUCCESS";
        if (status == 2) resultName = "FAILURE";
        if (status == 3) resultName = "SKIP";
        return resultName;
    }
}
