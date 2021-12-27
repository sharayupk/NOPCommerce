package com.nopCommerce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlsheet) throws Exception
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		int rowcount=sh.getLastRowNum();
		return rowcount;
	}
	
	public static int getColCount(String xlfile,String xlsheet,int rownum) throws Exception
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(0);
		int col=row.getLastCellNum();
		return col;
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int cellnum) throws Exception
	{
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		cell=row.getCell(cellnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}
	
}
