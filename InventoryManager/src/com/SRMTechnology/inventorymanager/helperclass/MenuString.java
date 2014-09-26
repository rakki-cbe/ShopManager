/**
 * @author android6
 * Created Date :26-Sep-2014
 * Purpose :MenuString used to store the option we use for menu and it charactors  
 * 
 */
package com.SRMTechnology.inventorymanager.helperclass;

public class MenuString {

String DisplayName="";
String Name="";
int Charctor=0;
/****
 * charactor 0 for nothing
 * charactor 1 for Title
 * charactor 2 for Menu
 * charactor 3 for sub menu
 */
public String getDisplayName() {
	return DisplayName;
}
public void setDisplayName(String displayName) {
	DisplayName = displayName;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getCharctor() {
	return Charctor;
}
public void setCharctor(int charctor) {
	Charctor = charctor;
}

}
