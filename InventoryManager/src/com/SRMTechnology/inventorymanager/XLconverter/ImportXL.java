/**
 * @author android6
 * Created Date :26-Sep-2014
 * Purpose :Use this file for import the xl files and get the values from there. 
 * Reference of implementation :http://www.andykhan.com/jexcelapi/tutorial.html#introduction Tutorial for reading xl sheed
 * Library: jxl.jar XL reader 
 */
package com.SRMTechnology.inventorymanager.XLconverter;

import java.io.File;
import java.util.Date;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;


public class ImportXL {
	Workbook workbook;
	Sheet sheet;
	int CurrentSheetIndex=0;
	String SheetNames[];
	public ImportXL(String Path) {
		// TODO Auto-generated constructor stub
		try
		{
			File f =new File(Path);
			if(f.exists())
				workbook = Workbook.getWorkbook(f);
			SheetNames=workbook.getSheetNames();
			sheet = workbook.getSheet(0);
		}catch(Exception e)
		{
			workbook=null;	
		}
	}
	public boolean MovetoSheet(int i)
	{
		if(workbook!=null)
		{
			try
			{
				sheet = workbook.getSheet(i);
			}catch(Exception e)
			{
				return false;
			}
			if(sheet!=null)
			{
				CurrentSheetIndex=i;
				return true;
			}
		}
		return false;
	}
	public boolean MovetoSheet(String SheetName)
	{
		if(workbook!=null)
		{
			try
			{
				sheet = workbook.getSheet(SheetName);
			}catch(Exception e)
			{
				return false;
			}
			if(sheet!=null)
			{

				for(int i =0;i<SheetNames.length;i++)
				{
					if(SheetNames[i].equals(SheetName))
						CurrentSheetIndex=i;
				}
				return true;
			}
		}
		return false;
	}
	public boolean MovetoNextSheet()
	{
		if(workbook!=null)
		{
			if(SheetNames.length>(CurrentSheetIndex+1))
				CurrentSheetIndex+=1;
			else
				return false;
			sheet=workbook.getSheet(CurrentSheetIndex);
			return true;
		}
		return false;

	}
	public boolean MovetoPreviousSheet()
	{
		if(workbook!=null)
		{
			if(SheetNames.length>(CurrentSheetIndex+1))
				CurrentSheetIndex+=1;
			else
				return false;
			sheet=workbook.getSheet(CurrentSheetIndex);
			return true;
		}
		return false;
	}
	public String getString(int Row,int Column)
	{
		if(sheet!=null){
			Cell a1 = sheet.getCell(Row,Column);
			if(a1!=null && a1.getType() == CellType.LABEL)
			return a1.getContents().toString(); 
			else 
				return "";
		}
		else
		{
			return ""; // Sheet must not be null
		}
	}
	public double getNumber(int Row,int Column)
	{
		if(sheet!=null){
			Cell a1 = sheet.getCell(Row,Column);
			if(a1!=null && a1.getType() == CellType.NUMBER)
			{
				NumberCell nc = (NumberCell) a1; 
				  return nc.getValue(); 
			}
			else 
				return 0;
		}
		else
		{
			return 0; // Sheet must not be null
		}
	}
	public Date getDate(int Row,int Column)
	{
		if(sheet!=null){
			Cell a1 = sheet.getCell(Row,Column);
			if(a1!=null && a1.getType() == CellType.DATE)
			{
				DateCell nc = (DateCell) a1; 
				  return nc.getDate(); 
			}
			else 
				return null;
		}
		else
		{
			return null; // Sheet must not be null
		}
	}

}
