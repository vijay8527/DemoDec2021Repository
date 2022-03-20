package com.sgtesting.actitime.driverscript;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import com.sgtesting.actitime.datatable.Datatable;
import com.sgtesting.actitime.tests.Initialize;

public class DriverScript {
	public static WebDriver oBrowser=null;
	public static String controllerFile=null;
	public static String strPath=null;
	public static Datatable datatable=null;
	public static String testscriptexcelfile=null;
	public static void main(String[] args) {
		
		try
		{
			datatable =new Datatable();
			strPath=System.getProperty("user.dir");
			controllerFile=strPath+"\\Controller\\data_Controller.xlsx";
			int controllerRowCount=datatable.rowCount(controllerFile, "Scenarios");
			for(int tcid=0;tcid<controllerRowCount;tcid++)
			{
				String testcaseid=datatable.getCellData(controllerFile, "Scenarios", "TestcaseID", tcid+2);
				String testcasename=datatable.getCellData(controllerFile, "Scenarios", "TestcaseName", tcid+2);
				String testcasedesc=datatable.getCellData(controllerFile, "Scenarios", "Description", tcid+2);
				String runstatus=datatable.getCellData(controllerFile, "Scenarios", "RunStatus", tcid+2);
				System.out.println("testcaseid :"+testcaseid);
				System.out.println("testcasename :"+testcasename);
				System.out.println("testcasedesc :"+testcasedesc);
				System.out.println("runstatus :"+runstatus);
				
				if(runstatus.equalsIgnoreCase("yes"))
				{
					oBrowser=Initialize.launchBrowser();
					
					//Create parameter for WebDriver
					Class driverparam[]=new Class[1];
					driverparam[0]=WebDriver.class;
					
					testscriptexcelfile=strPath+"\\TestScriptDataFiles\\"+testcasename+".xlsx";
					int testscriptrowcount=datatable.rowCount(testscriptexcelfile, testcaseid);
					for(int tsid=0;tsid<testscriptrowcount;tsid++)
					{
						String testscriptid=datatable.getCellData(testscriptexcelfile, testcaseid, "TestScriptID", tsid+2);
						String testscriptdesc=datatable.getCellData(testscriptexcelfile, testcaseid, "Description", tsid+2);
						String testmethodname=datatable.getCellData(testscriptexcelfile, testcaseid, "MethodName", tsid+2);
						String pkgclassname=datatable.getCellData(testscriptexcelfile, testcaseid, "PackageClassName", tsid+2);
						System.out.println("testscriptid :"+testscriptid);
						System.out.println("testscriptdesc :"+testscriptdesc);
						System.out.println("testmethodname :"+testmethodname);
						System.out.println("pkgclassname :"+pkgclassname);
						
						Class clsObject=Class.forName(pkgclassname);
						Object obj=clsObject.getDeclaredConstructor().newInstance();
						
						Method method=obj.getClass().getMethod(testmethodname, driverparam);
						method.invoke(obj, oBrowser);
					}
					System.out.println("+++++++++++++++++++++++++");
				}	
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
