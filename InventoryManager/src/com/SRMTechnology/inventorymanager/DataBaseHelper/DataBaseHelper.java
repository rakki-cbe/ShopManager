/**
 * @author Radhakrishnan S
 * Created Date :29-Sep-2014
 * Purpose : Data Base helper to create read and writable database for usage.
 * LinK reference: http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/ 
 * 
 */
package com.SRMTechnology.inventorymanager.DataBaseHelper;

import com.SRMTechnology.inventorymanager.DataModels.MasterEntry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "contactsManager";

	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(MasterEntry.CreateTable());	//Create master Table
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(MasterEntry.DropTable()); //Drop Master Table
		onCreate(db);
	}
	public boolean insertRecord(Object Tbl)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values=null;
		String TableName=null;
		/****Change according to tables***/
		if(Tbl instanceof MasterEntry)
		{
			MasterEntry ObjMe=(MasterEntry) Tbl;
			TableName=ObjMe.TableName;
			values=ObjMe.InsertRecord();


		}
		/****Change according to tables ends***/
		if(TableName!=null && values!=null)
		{

			long rowid=db.insert(TableName, null, values);
			db.close(); // Closing database connection
			if(rowid!=-1)	
				return true;
			else
				return false;
		}else
		{

			db.close(); // Closing database connection
			return false;
		}

	}
	public Object[] getRecord(String TableName,String SelectionColumn,String[] SelectionValues) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TableName, null, SelectionColumn,SelectionValues, null, null, null, null);

		if (cursor != null)
		{
			/****Change according to tables***/
			if(TableName.equals(MasterEntry.TableName))
			{
				MasterEntry ME[]=new MasterEntry[cursor.getCount()];	
				cursor.moveToFirst();
				for(int i =0;i<ME.length;i++,cursor.moveToNext())
				{
					ME[i] = new MasterEntry();
					ME[i].SetValuesFromCursor(cursor);
				}  
				// return contact
				return ME;


			}
			/****Change according to tables ends***/

		}
		return null;
	}
	public boolean updateRecord(Object Tbl)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values=null;
		String TableName=null;
		long rowid=-1;
		/****Change according to tables***/
		if(Tbl instanceof MasterEntry)
		{
			MasterEntry ObjMe=(MasterEntry) Tbl;
			TableName=ObjMe.TableName;
			values=ObjMe.InsertRecord();
			rowid=db.update(TableName, values, ObjMe.FieldPrimaryId + " = ?",
					new String[] { String.valueOf(ObjMe.getPrimaryId()) });
			db.close(); // Closing database connection
			if(rowid!=-1)	
				return true;
			else
				return false;
		}
		/****Change according to tables ends***/
			db.close(); // Closing database connection
			return false;

	}

	public void deleteRecord(Object Tbl) {
		SQLiteDatabase db = this.getWritableDatabase();
		/****Change according to tables***/
		if(Tbl instanceof MasterEntry)
		{
			MasterEntry ObjMe=(MasterEntry) Tbl;
			db.delete(ObjMe.TableName, ObjMe.FieldPrimaryId  + " = ?",
					new String[] { String.valueOf(ObjMe.getPrimaryId()) });
		}
		/****Change according to tables ends***/
		db.close();

	}	


}


