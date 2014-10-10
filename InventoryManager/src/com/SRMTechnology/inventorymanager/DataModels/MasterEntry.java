/**
 * @author RadhaKrishnan S
 * Created Date :29-Sep-2014
 * Purpose : Database table Master entry object 
 * 
 */
package com.SRMTechnology.inventorymanager.DataModels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.database.Cursor;

public class MasterEntry {
	public static String TableName="MasterTable";
	Date ValDate,ExpireDate;
	String ItemGroupCode,ItemCode,NameOfProduct,LocationOfProduct,SingleUnitPrice,Quantity,PurchasedPricePerUnit,UnitMetrix,QualityGrade,Category,InvoiceNo,PurchasedCompany;
	long PrimaryId;
	public static String FieldValDate="ValDate",FieldExpireDate="ExpireDate",FieldItemGroupCode="ItemGroupCode",FieldItemCode="ItemCode",FieldPrimaryId="PrimaryId",FieldNameOfProduct="NameOfProduct",FieldLocationOfProduct="LocationOfProduct",FieldSingleUnitPrice="SingleUnitPrice",FieldUnitMetrics="UnitMetrix",FieldQuantity="Quantity",FieldPurchasedPricePerUnit="PurchasedPricePerUnit",FieldQualityGrade="QualityGrade",FieldCategory="Category",FieldInvoiceNo="InvoiceNo",FieldPurchasedCompany="PurchasedCompany";
	public String getUnitMetrix() {
		return UnitMetrix;
	}
	public void setUnitMetrix(String unitMetrix) {
		UnitMetrix = unitMetrix;
	}
	public Date getDate() {
		return ValDate;
	}
	public void setDate(Date date) {
		this.ValDate = date;
	}
	public Date getExpireDate() {
		return ExpireDate;
	}
	public void setExpireDate(Date expireDate) {
		ExpireDate = expireDate;
	}
	public String getItemGroupCode() {
		return ItemGroupCode;
	}
	public void setItemGroupCode(String itemGroupCode) {
		ItemGroupCode = itemGroupCode;
	}
	public String getItemCode() {
		return ItemCode;
	}
	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	public long getPrimaryId() {
		return PrimaryId;
	}
	public void setPrimaryId(long primaryId) {
		PrimaryId = primaryId;
	}
	public String getNameOfProduct() {
		return NameOfProduct;
	}
	public void setNameOfProduct(String nameOfProduct) {
		NameOfProduct = nameOfProduct;
	}
	public String getLocationOfProduct() {
		return LocationOfProduct;
	}
	public void setLocationOfProduct(String locationOfProduct) {
		LocationOfProduct = locationOfProduct;
	}
	public String getSingleUnitPrice() {
		return SingleUnitPrice;
	}
	public void setSingleUnitPrice(String singleUnitPrice) {
		SingleUnitPrice = singleUnitPrice;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public String getPurchasedPricePerUnit() {
		return PurchasedPricePerUnit;
	}
	public void setPurchasedPricePerUnit(String purchasedPricePerUnit) {
		PurchasedPricePerUnit = purchasedPricePerUnit;
	}
	public String getQualityGrade() {
		return QualityGrade;
	}
	public void setQualityGrade(String qualityGrade) {
		QualityGrade = qualityGrade;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getInvoiceNo() {
		return InvoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		InvoiceNo = invoiceNo;
	}
	public String getPurchasedCompany() {
		return PurchasedCompany;
	}
	public void setPurchasedCompany(String purchasedCompany) {
		PurchasedCompany = purchasedCompany;
	}

	public static String  CreateTable()
	{
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TableName + "("
				+ FieldPrimaryId +" INTEGER PRIMARY KEY," +FieldValDate+" DATE,"	+FieldExpireDate+" DATE,"	+FieldItemGroupCode+" TEXT,"	+FieldItemCode+" TEXT,"	+FieldPrimaryId+" TEXT,"	+FieldNameOfProduct+" TEXT,"	+FieldLocationOfProduct+" TEXT,"	+FieldSingleUnitPrice+" TEXT,"	+FieldQuantity+" TEXT,"	+FieldPurchasedPricePerUnit+" TEXT"+FieldUnitMetrics+" TEXT,"+FieldQualityGrade+" TEXT,"	+FieldCategory+" TEXT,"	+FieldInvoiceNo+" TEXT,"	+FieldPurchasedCompany+" TEXT,+" + ")";
		return CREATE_CONTACTS_TABLE;
	}
	public static String DropTable()
	{
		return "DROP TABLE IF EXISTS "+TableName;
	}
	public ContentValues InsertRecord() {

		ContentValues values = new ContentValues();
		values.put(FieldValDate, getDate()+"");
		values.put(FieldExpireDate, getExpireDate()+"");
		values.put(FieldItemGroupCode, getItemGroupCode());
		values.put(FieldItemCode, getItemCode());
		values.put(FieldNameOfProduct, getNameOfProduct());
		values.put(FieldLocationOfProduct, getLocationOfProduct());
		values.put(FieldSingleUnitPrice, getSingleUnitPrice());
		values.put(FieldUnitMetrics, getUnitMetrix());
		values.put(FieldQuantity, getQuantity());
		values.put(FieldPurchasedPricePerUnit, getPurchasedPricePerUnit());
		values.put(FieldQualityGrade, getQualityGrade());
		values.put(FieldCategory, getCategory());
		values.put(FieldInvoiceNo, getInvoiceNo());
		values.put(FieldPurchasedCompany, getPurchasedCompany());
		return values;

	}
	@SuppressWarnings("deprecation")
	public void SetValuesFromCursor(Cursor c)
	{
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
	    Date convertedDate = new Date();
        try {
			convertedDate = dateFormat.parse(c.getString(c.getColumnIndex(FieldValDate)));
			setDate(convertedDate);
			convertedDate = dateFormat.parse(c.getString(c.getColumnIndex(FieldExpireDate)));
			setExpireDate(convertedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setItemGroupCode(c.getString(c.getColumnIndex(FieldItemGroupCode)));
		setItemCode(c.getString(c.getColumnIndex(FieldItemCode)));
		setPrimaryId(c.getLong(c.getColumnIndex(FieldPrimaryId)));
		setNameOfProduct(c.getString(c.getColumnIndex(FieldNameOfProduct)));
		setLocationOfProduct(c.getString(c.getColumnIndex(FieldLocationOfProduct)));
		setSingleUnitPrice(c.getString(c.getColumnIndex(FieldSingleUnitPrice)));
		setUnitMetrix(c.getString(c.getColumnIndex(FieldUnitMetrics)));
		setQuantity(c.getString(c.getColumnIndex(FieldQuantity)));
		setPurchasedPricePerUnit(c.getString(c.getColumnIndex(FieldPurchasedPricePerUnit)));
		setQualityGrade(c.getString(c.getColumnIndex(FieldQualityGrade)));
		setCategory(c.getString(c.getColumnIndex(FieldCategory)));
		setInvoiceNo(c.getString(c.getColumnIndex(FieldInvoiceNo)));
		setPurchasedCompany(c.getString(c.getColumnIndex(FieldPurchasedCompany)));
	}
	

}
