/**
 * @author RadhaKrishnan S
 * Created Date :29-Sep-2014
 * Purpose : Database table Master entry object 
 * 
 */
package com.SRMTechnology.inventorymanager.DataModels;

import java.util.Date;

import android.content.ContentValues;

public class MasterEntry {
	public static String TableName="MasterTable";
	Date Date,ExpireDate;
	String ItemGroupCode,ItemCode,NameOfProduct,LocationOfProduct,SingleUnitPrice,Quantity,PurchasedPricePerUnit,UnitMetrix,QualityGrade,Category,InvoiceNo,PurchasedCompany;
	long PrimaryId;
	public static String FieldDate="Date",FieldExpireDate="ExpireDate",FieldItemGroupCode="ItemGroupCode",FieldItemCode="ItemCode",FieldPrimaryId="PrimaryId",FieldNameOfProduct="NameOfProduct",FieldLocationOfProduct="LocationOfProduct",FieldSingleUnitPrice="SingleUnitPrice",FieldUnitMetrics="UnitMetrix",FieldQuantity="Quantity",FieldPurchasedPricePerUnit="PurchasedPricePerUnit",FieldQualityGrade="QualityGrade",FieldCategory="Category",FieldInvoiceNo="InvoiceNo",FieldPurchasedCompany="PurchasedCompany";
	private String getUnitMetrix() {
		return UnitMetrix;
	}
	private void setUnitMetrix(String unitMetrix) {
		UnitMetrix = unitMetrix;
	}
	private Date getDate() {
		return Date;
	}
	private void setDate(Date date) {
		this.Date = date;
	}
	private Date getExpireDate() {
		return ExpireDate;
	}
	private void setExpireDate(Date expireDate) {
		ExpireDate = expireDate;
	}
	private String getItemGroupCode() {
		return ItemGroupCode;
	}
	private void setItemGroupCode(String itemGroupCode) {
		ItemGroupCode = itemGroupCode;
	}
	private String getItemCode() {
		return ItemCode;
	}
	private void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}
	private long getPrimaryId() {
		return PrimaryId;
	}
	private void setPrimaryId(long primaryId) {
		PrimaryId = primaryId;
	}
	private String getNameOfProduct() {
		return NameOfProduct;
	}
	private void setNameOfProduct(String nameOfProduct) {
		NameOfProduct = nameOfProduct;
	}
	private String getLocationOfProduct() {
		return LocationOfProduct;
	}
	private void setLocationOfProduct(String locationOfProduct) {
		LocationOfProduct = locationOfProduct;
	}
	private String getSingleUnitPrice() {
		return SingleUnitPrice;
	}
	private void setSingleUnitPrice(String singleUnitPrice) {
		SingleUnitPrice = singleUnitPrice;
	}
	private String getQuantity() {
		return Quantity;
	}
	private void setQuantity(String quantity) {
		Quantity = quantity;
	}
	private String getPurchasedPricePerUnit() {
		return PurchasedPricePerUnit;
	}
	private void setPurchasedPricePerUnit(String purchasedPricePerUnit) {
		PurchasedPricePerUnit = purchasedPricePerUnit;
	}
	private String getQualityGrade() {
		return QualityGrade;
	}
	private void setQualityGrade(String qualityGrade) {
		QualityGrade = qualityGrade;
	}
	private String getCategory() {
		return Category;
	}
	private void setCategory(String category) {
		Category = category;
	}
	private String getInvoiceNo() {
		return InvoiceNo;
	}
	private void setInvoiceNo(String invoiceNo) {
		InvoiceNo = invoiceNo;
	}
	private String getPurchasedCompany() {
		return PurchasedCompany;
	}
	private void setPurchasedCompany(String purchasedCompany) {
		PurchasedCompany = purchasedCompany;
	}

	public static String  CreateTable()
	{
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TableName + "("
				+ FieldPrimaryId +" INTEGER PRIMARY KEY," +FieldDate+" DATE,"	+FieldExpireDate+" DATE,"	+FieldItemGroupCode+" TEXT,"	+FieldItemCode+" TEXT,"	+FieldPrimaryId+" TEXT,"	+FieldNameOfProduct+" TEXT,"	+FieldLocationOfProduct+" TEXT,"	+FieldSingleUnitPrice+" TEXT,"	+FieldQuantity+" TEXT,"	+FieldPurchasedPricePerUnit+" TEXT"+FieldUnitMetrics+" TEXT,"+FieldQualityGrade+" TEXT,"	+FieldCategory+" TEXT,"	+FieldInvoiceNo+" TEXT,"	+FieldPurchasedCompany+" TEXT,+" + ")";
		return CREATE_CONTACTS_TABLE;
	}
	public static String DropTable()
	{
		return "DROP TABLE IF EXISTS "+TableName;
	}
	public ContentValues InsertRecord() {

		ContentValues values = new ContentValues();
		values.put(FieldDate, getDate()+"");
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

}
