package com.framework.init;

import com.framework.configurations.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rutu shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: TBLOCKS_Web_Zain_POC
 */

public class BrowserCaps implements Configuration {

    private static String osName = "";
    public static String browserVersion = "";
    public static String browserName = "";

    private static DesiredCapabilities capability;

    /**
     * To configure the Firefox browser capabilities
     *
     * @return Firefox Browser Capabilities
     */
    static DesiredCapabilities configureMozillaFirefox() {

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.dir", FILE_DOWNLOAD_PATH);

        capability = DesiredCapabilities.firefox();
        capability.setCapability("marionette", true);
        capability.setJavascriptEnabled(true);
        capability.setCapability(FirefoxDriver.PROFILE, profile);

        browserName = capability.getBrowserName();
        osName = System.getProperty("os.name");
        browserVersion = capability.getVersion();

        System.out.println("OS Name : " + osName);
        System.out.println("Browser Name : " + browserName);
        System.out.println("Browser Version : " + browserVersion);

        return capability;
    }

    /**
     * To configure the Chrome browser capabilities from windows
     *
     * @return Chrome Browser Capabilities
     */
    static DesiredCapabilities configureGoogleChrome() {

        capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setJavascriptEnabled(true);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches", "--disable-extensions");
        options.addArguments("disable-infobars");
        options.addArguments("test-type");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        //options.addArguments("--allow-running-insecure-content");
        options.addArguments("incognito");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", FILE_DOWNLOAD_PATH);
        prefs.put("profile.default_content_setting_values.plugins", 1);
        prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
        prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
        prefs.put("PluginsAllowedForUrls", URL);
        options.setExperimentalOption("prefs", prefs);

        capability.setCapability(ChromeOptions.CAPABILITY, options);

        browserName = capability.getBrowserName();
        osName = System.getProperty("os.name");
        browserVersion = capability.getVersion();

        System.out.println("OS Name : " + osName);
        System.out.println("Browser Name : " + browserName);
        System.out.println("Browser Version : " + browserVersion);

        return capability;
    }

    /**
     * To configure the Chrome browser capabilities from linux
     *
     * @return Chrome Browser Capabilities
     */
    static DesiredCapabilities configureGoogleChromeLinux() {

        capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setJavascriptEnabled(true);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches", "--disable-extensions");
        options.addArguments("disable-infobars");
        options.addArguments("test-type");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        //options.addArguments("--start-maximized");
        options.addArguments("incognito");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", FILE_CHROME_LINUX);
        prefs.put("profile.default_content_setting_values.plugins", 1);
        prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
        prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
        prefs.put("PluginsAllowedForUrls", URL);
        options.setExperimentalOption("prefs", prefs);

        capability.setCapability(ChromeOptions.CAPABILITY, options);

        browserName = capability.getBrowserName();
        osName = System.getProperty("os.name");
        browserVersion = capability.getVersion();

        System.out.println("OS Name : " + osName);
        System.out.println("Browser Name : " + browserName);
        System.out.println("Browser Version : " + browserVersion);

        return capability;
    }

    /**
     * To configure the IE browser capabilities
     *
     * @return IE Browser Capabilities
     */
    static DesiredCapabilities configureInternetExplorer11() {

        capability = DesiredCapabilities.internetExplorer();
        capability.setBrowserName("internet explorer");
        capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        capability.setCapability("requireWindowFocus", true);
        capability.setJavascriptEnabled(true);

        browserName = capability.getBrowserName();
        osName = System.getProperty("os.name");
        browserVersion = capability.getVersion();

        System.out.println("OS Name : " + osName);
        System.out.println("Browser Name : " + browserName);
        System.out.println("Browser Version : " + browserVersion);

        return capability;
    }

    static DesiredCapabilities configureSafari(){
        capability = DesiredCapabilities.safari();
        capability.setBrowserName("safari");

        browserName = capability.getBrowserName();
        osName = System.getProperty("os.name");
        browserVersion = capability.getVersion();

        System.out.println("OS Name : " +osName);
        System.out.println("Browser Name : " + browserName);
        System.out.println("Browser Version : " + browserVersion);

        return capability;
    }

}