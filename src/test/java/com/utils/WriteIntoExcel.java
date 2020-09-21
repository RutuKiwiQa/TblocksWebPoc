package com.utils;

import com.framework.configurations.Configuration;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

//-----------------------Variable Declaration------------------------------
public class WriteIntoExcel implements Configuration {
    //  write data into excel file
    public static  XSSFSheet sheet ;
    public static XSSFWorkbook workbook;
    public static XSSFCell Cell;
    public static XSSFRow Row;

    public static String sheetName = "";

    public static String ExcelOutput = PROJECT_DIR + File.separator + "Excel" + File.separator + "SaveToExcel.xlsx";

    public static void main(String[] args) throws Exception {
        writeIntoExcel("www.j2io.com","www.jio.com/welcome",200,200,"Pass");
       // setDataToExcel(ExcelOutput,sheetName,"tets","test",2,2,"pass");
//        setCellData(ExcelOutput,"Sheet1","test","test",1,2,"Pass";
    }

    public static void writeIntoExcel(String mainUrl, String subUrl, int expectedResult, int actualResult,String executionStatus){
        // Blank workbook
         workbook = new XSSFWorkbook();

        // Create a blank sheet
        sheet = workbook.createSheet("Broken Links");
        int num = 1;

        // This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>(); //tree map creation

        data.put("1" + num++, new Object[]{"Main URL", "Sub URLs", "Expected Result", "Actual Result", "Execution Status"});

        ArrayList<Object> list = new ArrayList();
        list.add(new Object[]{mainUrl, subUrl, expectedResult, actualResult, executionStatus});

        data.put("2  " + num++, new Object[]{mainUrl, subUrl, expectedResult, actualResult, executionStatus});
        data.put("3  " + num++, new Object[]{mainUrl, subUrl, expectedResult, actualResult, executionStatus});
        data.put("4  " + num++, new Object[]{mainUrl, subUrl, expectedResult, actualResult, executionStatus});
        data.put("5  " + num++, new Object[]{mainUrl, subUrl, expectedResult, actualResult, executionStatus});

          //  Iterate over data and write to sheet
            Set<String> keyset = data.keySet();
            int rownum = 0;
            for (Object key : keyset) {
                // this creates a new row in the sheet
                Row row = sheet.createRow(rownum++);
               List<Object> objArr = Arrays.asList(data.get(key));
                int cellnum = 0;
                for (Object obj : objArr){
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

