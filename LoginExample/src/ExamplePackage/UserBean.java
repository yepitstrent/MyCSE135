package ExamplePackage;

import java.util.ArrayList;

public class UserBean {
	private String username;
	private int age;
	private int userID;
	private String role;
	private String state;
	private String[] catStrArr;

	private String catID;
	private String prodName;
	private String prodSKU;
	private String prodPrice;
	private String prodDesc;

	private String catName;
	private String catDesc;

	private String prodSearchStr;

	private String[] catNameList;// = new ArrayList<String>();
	private String[] catDescList;
	private String[] catIDList;

	private String[] prodNameArr;
	private String[] prodDescArr;
	private String[] prodIDArr;

	private String prodSearchCat;

	public boolean valid;

	public void setProdSearchCat(String parameter) {
		prodSearchCat = parameter;
	}

	public String getProdSearchCat() {
		return prodSearchCat;
	}

	public void setProdIDArr(String[] arr) {
		prodIDArr = arr.clone();
	}

	public String[] getProdIDArr() {
		return prodIDArr;
	}

	public void setProdDescArr(String[] arr) {
		prodDescArr = arr.clone();
	}

	public String[] getProdDescArr() {
		return prodDescArr;
	}

	public void setProdNameArr(String[] arr) {
		prodNameArr = arr.clone();
	}

	public String[] getProdNameArr() {
		return prodNameArr;
	}

	public String getCatNameByIndex(int i) {
		return catNameList[i];
	}

	public String getCatIDByIndex(int i) {
		return catIDList[i];
	}

	public String getCatDescByIndex(int i) {
		return catDescList[i];
	}

	public void setCatIDArrList(ArrayList<String> catIDArrList) {
		catIDList = catIDArrList.toArray(new String[catIDArrList.size()]);
	}

	public String[] getCatIDArrList() {
		return catIDList;
	}

	public void setCatNameArrList(ArrayList<String> catNameArrList) {
		System.out.println("SET CAT NAM LIST &&&&&&&&");
		catNameList = catNameArrList.toArray(new String[catNameArrList.size()]);
	}

	public String[] getCatNameArrList() {
		return catNameList;
	}

	public void setCatName(String newCatName) {
		catName = newCatName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatDescArray(ArrayList<String> catDescArrayList) {
		catDescList = catDescArrayList.toArray(new String[catDescArrayList
				.size()]);
	}

	public String[] getCatDescArray() {
		return catDescList;
	}

	public void setCatDesc(String newCatDesc) {
		catDesc = newCatDesc;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatID(String currCatID) {
		catID = currCatID;
	}

	public String getCatID() {
		return catID;
	}

	public void setProdName(String newProdName) {
		prodName = newProdName;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdSKU(String newProdSKU) {
		prodSKU = newProdSKU;
	}

	public String getProdSKU() {
		return prodSKU;
	}

	public void setProdPrice(String newProdPrice) {
		prodPrice = newProdPrice;
	}

	public String getProdPrice() {
		return prodPrice;
	}

	public void setProdDesc(String newProdDesc) {
		prodDesc = newProdDesc;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setCatArr(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			catStrArr[i] = arr[i];
		}
	}

	public String[] getCatArr() {
		return catStrArr;
	}

	public void setAge(int the_age) {
		age = the_age;
	}

	public int getAge() {
		return age;
	}

	public void setRole(String the_role) {
		role = the_role;
	}

	public String getRole() {
		return role;
	}

	public void setState(String the_state) {
		state = the_state;
	}

	public String getState() {
		return state;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String newUsername) {
		username = newUsername;
	}

	public void setUserID(int newUserID) {
		userID = newUserID;
	}

	public int getUserID() {
		return userID;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	public String getProdSearchStr() {
		return prodSearchStr;
	}

	public void setProdSearchStr(String newProdSearchStr) {
		prodSearchStr = newProdSearchStr;
	}

}