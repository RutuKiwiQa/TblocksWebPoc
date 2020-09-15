package com.utils;

import java.io.File;
import java.io.IOException;

public class ExcelUtilsDemo {

    public static  String PROJECT_DIR = getProjectDir();
    public static  String WORKBOOK = PROJECT_DIR + File.separator + "Excel" + File.separator + "Data.xlsx";

//    public static void main(String[] args) throws IOException {
//
//        ExcelUtils excelUtils = new ExcelUtils(WORKBOOK, "Requestor");
//        excelUtils.getRowCount();
//        excelUtils.getColumnCount();
//        excelUtils.getCellDataString(1,0);
//        excelUtils.getCellDataNumber(1,1);
//        excelUtils.getCellDataNumber(1,2);
//    }

    /**
     * To get the current project directory path
     *
     * @return Project Directory path
     */
    static String getProjectDir() {
        return System.getProperty("user.dir");
    }
}
