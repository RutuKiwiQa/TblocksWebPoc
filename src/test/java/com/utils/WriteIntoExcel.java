package com.utils;

import com.framework.common.Common;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.reporters.jq.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//-----------------------Variable Declaration------------------------------
public class WriteIntoExcel {
    //  write data into excel file
    public static  XSSFSheet sheet ;
    public static XSSFWorkbook workbook;
    public static XSSFCell Cell;
    public static XSSFRow Row;

    public static void main(String[] args) {
        writeIntoExcel("www.jio.com","www.jio.com/welcome",200,200,"Pass");
    }

    public static void writeIntoExcel(String mainUrl, String subUrl, int expectedResult, int actualResult,String executionStatus){
        // Blank workbook
         workbook = new XSSFWorkbook();

        // Create a blank sheet
        sheet = workbook.createSheet("Broken Links");
        int num = 1;

        // This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        data.put("1" + num++, new Object[]{"Main URL", "Sub URLs", "Expected Result", "Actual Result", "Execution Status"});
        data.put("2 - " + num++, new Object[]{mainUrl, subUrl, expectedResult, actualResult, executionStatus});

            // Iterate over data and write to sheet
            Set<String> keyset = data.keySet();
            int rownum = 0;
            for (String key : keyset) {
                // this creates a new row in the sheet
                Row row = sheet.createRow(rownum++);
                Object[] objArr = data.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    // this line creates a cell in the next column of that row
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String)
                        cell.setCellValue((String) obj);
                    else if (obj instanceof Integer)
                        cell.setCellValue((Integer) obj);
                }


            }

        try {
            // this Writes the workbook SaveToExcel.xlsx
            FileOutputStream out = new FileOutputStream(new File("SaveToExcel.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("SaveToExcel.xlsx written successfully on disk.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}

