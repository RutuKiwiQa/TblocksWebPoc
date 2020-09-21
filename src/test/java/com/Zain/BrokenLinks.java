package com.Zain;

import com.framework.common.Common;
import com.utils.BrokenLinksProvider;
import com.utils.WriteIntoExcel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BrokenLinks extends BrokenLinksProvider {
    public BrokenLinks() throws IOException {
    }
    protected static int _log1Step = 1;
    protected static int _serialNo =1;
    WebDriver driver;
    public static String ExcelOutput = PROJECT_DIR + File.separator + "Excel" + File.separator + "SaveToExcel.xlsx";

    @Test(dataProvider = "BrokenLinks",description = "BrokenLinks Checking" ,priority = 1)
    public void BrokenLinkTestCase(String urlFromExcel) throws Exception {

        int numOfFailedSteps = 0;
        _log1Step = 1;
        boolean flag = false;

        Common.log1(" <h2> TS_WEB_002 :: To verify broken links of the web page. </h2>");

        System.setProperty("webdriver.chrome.driver", "E:\\TBLOCKS_WEB_POC\\chromedriver.exe");
        driver = new ChromeDriver();

        //maximize the page
        driver.manage().window().maximize();

        //implicit wait for 10 secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(urlFromExcel);

        //wait
        Thread.sleep(5000);

        Common.log1("<h3> WebLink for which broken link is been checked  : -  <a> "   + urlFromExcel + " </a> </h3>" );

        //capture links from a webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //number of links
        Common.log1("<h4> Link Size : " +links.size() + " </h4> ");

        Common.log1(" <h4>List of Broken Links </h4>");


        //read each and every link
        for (int i = 0; i < links.size(); i++) {
            //by using href attribute we can get URL of required link

            WebElement element = links.get(i); //capture the element
            String url = element.getAttribute("href");

            if (isUrlValid(url)) {
                URL link = new URL(url);
                // URL link = new URL(url);

                //to check whether target page is connected to the link or not without click on target url
                //create a connection using url object link
                HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();


                Thread.sleep(3000);

                httpConn.setConnectTimeout(7000);

                //connect () method used to establish connection
                httpConn.connect();

                //capture response code
                int resCode = httpConn.getResponseCode(); //return response if res code is above 400 : broken link

                if (resCode >= 400) {
                    Reporter.log("<br></br><img src=\"fail.png\" alt=\"Fail\" height=\"18\" width=\"18\"><Strong><font color=#ff0000>Fail</font></strong>");
                    Common.log1(url + " - " + " <br> is a broken link.");
                    Common.log1("<br> <br>");
                    flag = false;
                    WriteIntoExcel.writeIntoExcel(urlFromExcel,url,200,resCode,"Fail");
                    numOfFailedSteps++;

                } else {
                    Reporter.log("<br></br><img src=\"pass.png\" height=\"18\" width=\"18\"><Strong><font color=#008000>Pass</font></strong>");
                    Common.log1(url + " - " + " <br> is a valid link.");
                    Common.log1("<br> <br>");
                    WriteIntoExcel.writeIntoExcel(urlFromExcel,url,200,resCode,"Pass");
                    flag = true;

                }
            }
            if (numOfFailedSteps > 0) Assert.fail("Test Verification failed, please check test log1s.");
        }

    }

    public static boolean isUrlValid(String url) throws UnknownHostException, SocketTimeoutException {
        try {
            URL obj = new URL(url);
            obj.toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    @AfterClass
    public void suiteTearDown() {
        // close the browser
        driver.close();
        driver.quit();
    }
}

