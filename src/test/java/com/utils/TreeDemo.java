package com.utils;

import com.framework.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TreeDemo {
    WebDriver driver;

    public ArrayList<Object> getUrls(String urlFromExcel) throws InterruptedException {
        ArrayList<Object> urls = new ArrayList<>();

        System.setProperty("webdriver.chrome.driver", "E:\\TBLOCKS_WEB_POC\\chromedriver.exe");
        driver = new ChromeDriver();

        //maximize the page
        driver.manage().window().maximize();

        //implicit wait for 10 secs
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(urlFromExcel);

        //wait
        Thread.sleep(5000);

        Common.log1("<h3> WebLink for which broken link is been checked  : -  <a> " + urlFromExcel + " </a> </h3>");

        //capture links from a webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //number of links
        Common.log1("<h4> Link Size : " + links.size() + " </h4> ");

        Common.log1(" <h4>List of Broken Links </h4>");

        //read each and every link
        for (int i = 0; i < links.size(); i++) {
            //by using href attribute we can get URL of required link

            WebElement element = links.get(i); //capture the element
            String url = element.getAttribute("href");
            urls.add(url);
        }

      return urls;
    }

    public List<Object> getUrlStatus() throws InterruptedException, IOException {

        ArrayList<Object> data = new ArrayList<>();

        return data;

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
}