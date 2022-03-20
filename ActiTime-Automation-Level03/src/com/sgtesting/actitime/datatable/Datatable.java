package com.sgtesting.actitime.datatable;

import java.io.FileInputStream;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datatable {
	public static Workbook wb=null;
	/**
	 * Testcase ID:
	 * Testcase Name:
	 * Created By:
	 * Reviewed By:
	 * Reviewed Date:
	 * Return Value
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	public int rowCount(String filename,String sheetname)
	{
		Workbook wb=null;
		Sheet sh=null;
		FileInputStream fin=null;
		int rowcount=0;
		try
		{
			fin=new FileInputStream(filename);
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet(sheetname);
			if(sh==null)
			{
				rowcount=-1;
			}
			rowcount=sh.getPhysicalNumberOfRows();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
				sh=null;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return rowcount-1;
	}
	
	/**
	 * Testcase ID:
	 * Testcase Name:
	 * Created By:
	 * Reviewed By:
	 * Reviewed Date:
	 * Return Value
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	public int rowCount(String sheetname)
	{
		Sheet sh=null;
		FileInputStream fin=null;
		int rowcount=0;
		try
		{
			sh=wb.getSheet(sheetname);
			if(sh==null)
			{
				rowcount=-1;
			}
			rowcount=sh.getPhysicalNumberOfRows();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowcount-1;
	}
	
	/**
	 * Testcase ID:
	 * Testcase Name:
	 * Created By:
	 * Reviewed By:
	 * Reviewed Date:
	 * Return Value
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	public boolean importExcelFile(String filename)
	{
		FileInputStream fin=null;
		boolean isStatus=false;
		try
		{
			fin=new FileInputStream(filename);
			wb=new XSSFWorkbook(fin);
			if(wb!=null)
			{
				isStatus=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isStatus;
	}
	
	/**
	 * Testcase ID:
	 * Testcase Name:
	 * Created By:
	 * Reviewed By:
	 * Reviewed Date:
	 * Return Value
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	public String getCellData(String fileName,String sheetName,String columnName,int rownum)
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		String strCellData=null;
		int colNum=0;
		try
		{
			fin=new FileInputStream(fileName);
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet(sheetName);
			if(sh==null)
			{
				strCellData=null;
			}
			row=sh.getRow(0);
			for(int c=0;c<row.getPhysicalNumberOfCells();c++)
			{
				cell=row.getCell(c);
				String colName=cell.getStringCellValue();
				if(columnName.trim().equalsIgnoreCase(colName.trim()))
				{
					colNum=c;
					break;
				}
			}
			row=sh.getRow(rownum-1);
			cell=row.getCell(colNum);
			if(cell==null||cell.getCellType()==CellType.BLANK)
			{
				strCellData="";
			}
			else if(cell.getCellType()==CellType.STRING)
			{
				strCellData=cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.BOOLEAN)
			{
				strCellData=String.valueOf(cell.getBooleanCellValue());
			}
			else if(cell.getCellType()==CellType.FORMULA ||cell.getCellType()==CellType.NUMERIC)
			{
				if (DateUtil.isCellDateFormatted(cell))
				{
					double d=cell.getNumericCellValue();
					Calendar cal=Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					int month=cal.get(Calendar.MONTH)+1;
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int year=cal.get(Calendar.YEAR);
					String sDate=month+"/"+day+"/"+year;
					strCellData=sDate;
				}
				else
				{
					strCellData=String.valueOf(cell.getNumericCellValue());
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return strCellData;
	}
	
	/**
	 * Testcase ID:
	 * Testcase Name:
	 * Created By:
	 * Reviewed By:
	 * Reviewed Date:
	 * Return Value
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	public String getCellData(String sheetName,String columnName,int rownum)
	{
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		String strCellData=null;
		int colNum=0;
		try
		{
			sh=wb.getSheet(sheetName);
			if(sh==null)
			{
				strCellData=null;
			}
			row=sh.getRow(0);
			for(int c=0;c<row.getPhysicalNumberOfCells();c++)
			{
				cell=row.getCell(c);
				String colName=cell.getStringCellValue();
				if(columnName.trim().equalsIgnoreCase(colName.trim()))
				{
					colNum=c;
					break;
				}
			}
			row=sh.getRow(rownum-1);
			cell=row.getCell(colNum);
			if(cell==null||cell.getCellType()==CellType.BLANK)
			{
				strCellData="";
			}
			else if(cell.getCellType()==CellType.STRING)
			{
				strCellData=cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.BOOLEAN)
			{
				strCellData=String.valueOf(cell.getBooleanCellValue());
			}
			else if(cell.getCellType()==CellType.FORMULA ||cell.getCellType()==CellType.NUMERIC)
			{
				if (DateUtil.isCellDateFormatted(cell))
				{
					double d=cell.getNumericCellValue();
					Calendar cal=Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					int month=cal.get(Calendar.MONTH)+1;
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int year=cal.get(Calendar.YEAR);
					String sDate=month+"/"+day+"/"+year;
					strCellData=sDate;
				}
				else
				{
					strCellData=String.valueOf(cell.getNumericCellValue());
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return strCellData;
	}
	public static void main(String[] args) {
		Datatable o=new Datatable();
		String strPath=System.getProperty("user.dir");
		String filename=strPath+"\\Controller\\data_Controller.xlsx";
		String data=o.getCellData(filename, "Scenarios", "TestcaseName", 5);
		System.out.println(data);
	}

}
