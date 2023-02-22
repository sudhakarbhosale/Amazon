package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility   {
	
	public  WebDriver driver ;
	
	public static void captureScreenshot (String TestID,WebDriver driver) throws IOException
	{
		Date date = new Date ();
		SimpleDateFormat dateformat = new SimpleDateFormat ("YYYY.MM.DD-HH.MM.SS");
		String dateTime = dateformat.format(date);
	
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File  dest = new File ("C:\\Users\\Sudhakar\\New folder\\"+TestID+dateTime+".jpg");
		FileHandler.copy(src, dest);
	}
	
	public static String getExcelSheetData (String sheetname ,int rowNo ,int cellNo) throws EncryptedDocumentException, IOException
	{
		String path ="C:\\Users\\Sudhakar\\Desktop\\test data excel.xlsx" ;
		InputStream file = new FileInputStream (path);
		Cell cell = WorkbookFactory.create(file).getSheet(sheetname).getRow(rowNo).getCell(cellNo);
		String data ="";
		
		try 
		{
			data = cell.getStringCellValue();
		}
		catch (InvalidElementStateException e)
		{
			double data1 = cell.getNumericCellValue();
			data= Double.toString(data1);
	//		data=data1+"";
		}
		return data;
	}
	

}
