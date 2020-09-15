package com.framework.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Created by Rutu shah.
 * Date: 2020-09-15
 * Time:
 * Project Name: TBLOCKS_Web_Zain_POC
 */

public abstract class AbstractPage extends SeleniumInit {

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,
                10);
        PageFactory.initElements(finder, this);
    }
}
