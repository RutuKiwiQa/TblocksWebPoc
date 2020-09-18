package com.Zain;

import com.framework.common.Common;
import com.utils.BrokenLinksProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinks extends BrokenLinksProvider {
    public BrokenLinks() throws IOException {
    }
    protected static int _logStep = 1;
    WebDriver driver;

    @Test(dataProvider = "BrokenLinks")
    public void BrokenLinkTestCase(String urlFromExcel) throws IOException, InterruptedException {

        int numOfFailedSteps = 0;
        _logStep = 1;
        boolean flag = false;

        Common.log(" <h2> TS_WEB_002 :: To verify broken links of the web page. </h2>");

        System.setProperty("webdriver.chrome.driver", "E:\\TBLOCKS_WEB_POC\\chromedriver.exe");
        driver = new ChromeDriver();

        //maximize the page
        driver.manage().window().maximize();

        //implicit wait for 10 secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(urlFromExcel);

        //wait
        Thread.sleep(5000);

        Common.log("<h3> WebLink for which broken link is been checked  : -  <a> "   + urlFromExcel + " </a> </h3>" );

        //capture links from a webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //number of links
        Common.log("<h4> Link Size : " +links.size() + " </h4> ");

        Common.log(" <h4>List of Broken Links </h4>");


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
                    Common.log(url + " - " + " <br> is a broken link.");
                    Common.log("<br> <br>");
                    flag = false;
                    numOfFailedSteps++;

                } else {
                    Reporter.log("<br></br><img src=\"pass.png\" height=\"18\" width=\"18\"><Strong><font color=#008000>Pass</font></strong>");
                    Common.log(url + " - " + " <br> is a valid link.");
                    Common.log("<br> <br>");
                    flag = true;

                }
            }
            if (numOfFailedSteps > 0) Assert.fail("Test Verification failed, please check test logs.");
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

    @AfterTest
    public void  tearDownTest(){
        driver.close();
        driver.quit();
    }
}

