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
    public static XSSFSheet ExcelWSheet;
    public static XSSFWorkbook ExcelWBook;
    public static XSSFCell Cell;
    public static XSSFRow Row;

    public static void main(String[] args) {
        writeIntoExcel("www.jio.com","www.jio.com/welcome",200,200,"Pass");
    }

    public static void writeIntoExcel(String mainUrl, String subUrl, int expectedResult, int actualResult,String executionStatus){
        // Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Broken Links");
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

    public static void setDataExcel(String filename, String sheetname,  ArrayList<String> mainUrl, ArrayList<String> subUrl, ArrayList<Integer> expectedResult, ArrayList<Integer> actualResult,ArrayList<String> executedStatus) throws IOException {
        File datafile = new File(filename);
        String fullpath = datafile.getAbsolutePath();
        ExcelWBook = new XSSFWorkbook(fullpath);
        ExcelWSheet = ExcelWBook.getSheet(sheetname);
        int totalRows = ExcelWSheet.getLastRowNum();
        try {
            int rowno = totalRows + 1;
            FileInputStream inputStream = new FileInputStream(new File(fullpath));
            @SuppressWarnings("resource")
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet firstSheet = workbook.getSheetAt(0);
//			XSSFRow row = firstSheet.createRow(rowno);

            CellStyle style1 = workbook.createCellStyle();
           // style1.setFillForegroundColor(IndexedColors.BLACK.getIndex());
           // style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
           // Font font = workbook.createFont();
           // font.setColor(IndexedColors.AQUA.getIndex());
//	        style1.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
          //  font.setBold(true);
          //  style1.setFont(font);


            for(int i=0;i<mainUrl.size() && i<subUrl.size() && i<expectedResult.size() && i<actualResult.size() && i<executedStatus.size();i++)
            {
                Row rw= firstSheet.createRow(i);
                Cell cl1=rw.createCell(0);
                cl1.setCellValue(mainUrl.get(i));
               // cl1.setCellStyle(style1);

                Cell cl2=rw.createCell(1);
                cl2.setCellValue(subUrl.get(i));
               // cl2.setCellStyle(style1);

                Cell cl3 = rw.createCell(2);
                cl3.setCellValue(expectedResult.get(i));

                Cell cl4 = rw.createCell(3);
                cl4.setCellValue(actualResult.get(i));

                Cell cl5 = rw.createCell(4);
                cl5.setCellValue(executedStatus.get(i));

            }
            inputStream.close();
            FileOutputStream fos = new FileOutputStream(new File(fullpath));
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

