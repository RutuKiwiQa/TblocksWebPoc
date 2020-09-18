package com.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {



    static  XSSFWorkbook workbook;
    static XSSFSheet sheet;


    /**A constructor.*/
    public ExcelUtils(String excelPath, String sheetName) throws IOException {

        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);

    }

    public static void main(String[] args) throws IOException {
        getRowCount();
        getColumnCount();
    }

    /** To get row count of current sheet */
    public static int getRowCount() throws IOException {
        int rowCount = 0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();  //method which gives numbers of rows.
          // System.out.println("No of rows : "  + rowCount);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
           // e.printStackTrace();
        }
        return rowCount;
    }

    /** To get column count of current sheet */
    public static int getColumnCount() throws IOException {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();  //method which gives numbers of rows.
         //   System.out.println("No of columns : "  + colCount);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            // e.printStackTrace();
        }
        return colCount;
    }

    public static String  getCellDataString(int rowNum, int colNum) throws IOException {
        String cellData = null;
        try {
            //getcelldata
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue(); //this will store in a string value
        //    System.out.println(cellData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            // e.printStackTrace();
        }
        return cellData;
    }

    public static void  getCellDataNumber(int rowNum, int colNum) throws IOException {
        try {

            //getcelldata
            String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue(); //this will store in a string value
         //   System.out.println(cellData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            // e.printStackTrace();
        }
    }

    /**
     * To get the current project directory path
     *
     * @return Project Directory path
     */
    static String getProjectDir() {
        return System.getProperty("user.dir");
    }

}
