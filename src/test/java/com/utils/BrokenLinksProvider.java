package com.utils;

import com.framework.common.Generics;
import com.framework.configurations.Configuration;
import com.framework.init.SeleniumInit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class BrokenLinksProvider implements Configuration {
    public static String excelPath = "./Excel/Data.xlsx"; //relative path of excel
    public static String sheetName = "Price";

    ExcelUtils excel = new ExcelUtils(excelPath,sheetName);

    public static  String WORKBOOK = PROJECT_DIR + File.separator + "Excel" + File.separator + "Data.xlsx";

    public BrokenLinksProvider() throws IOException {
    }
    //-----------------------Broken Links Data Provider Code--------------------------------------

    @Test(dataProvider = "BrokenLinks")
    public void brokenLinks(String urlFromExcel){
        System.out.println("URL : " + urlFromExcel);
    }

    /**Testng data provider to get data url from excel to check broken links.*/
    @DataProvider(name = "BrokenLinks") //dataprovider name
    public Object[][] getDataEquipment() throws IOException {
        Object data[][] = testDataEquipment(WORKBOOK,"BrokenLinks"); //passing sheet location and sheetname
        return data;
    }

    /**This is excel data provider function for fetching url for brokenlink checking*/
    public  Object[][] testDataEquipment(String excelPath, String sheetName) throws IOException {

        ExcelUtils excelUtils = new ExcelUtils(excelPath,sheetName);
        int rowCount =  excelUtils.getRowCount();
        int colCount = excelUtils.getColumnCount();


        Object data[][] = new Object[rowCount-1][colCount];

        for (int i =1; i<rowCount; i++){
            for (int j = 0; j<colCount; j++){
                String cellData = excelUtils.getCellDataString(i,j);
                System.out.print(cellData + " | ");
                data[i-1][j] = cellData;
            }
            System.out.println();
        }
        return data;
    }

}
