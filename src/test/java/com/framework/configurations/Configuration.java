package com.framework.configurations;

import com.framework.common.Common;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Rutu shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: TBLOCKS_Web_Zain_POC
 */

public interface Configuration {

    Properties configProp = new Properties();

    String configurationPath = "Resources/config.properties";

    String PROJECT_DIR = getProjectDir();

    String BROWSER = getProperty("browser");
    String ZAIN_URL = getProperty("zain_url");
    String JIO_PLANS_URL = getProperty("jio_plans_url");

    String FILE_DOWNLOAD_PATH = PROJECT_DIR + File.separator + "download";

    /**
     * To get the current project directory path
     *
     * @return Project Directory path
     */
    static String getProjectDir() {
        return System.getProperty("user.dir");
    }

    /**
     * To get the Test Configuration Property values
     *
     * @param key Key
     * @return Value of Key
     */
    static String getProperty(String key) {
        InputStream input = null;
        try {
            input = new FileInputStream(configurationPath);
            configProp.load(input);
        } catch (Exception e) {
            Common.log1("Error occurred while reading the file.");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return configProp.getProperty(key);
    }




}