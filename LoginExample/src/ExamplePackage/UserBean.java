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

	private String[] prodSkuArr;
	private String[] prodCatArr;
	private String[] prodPriArr;

	private String prodSearchCat;
	private int catIndex;

	public boolean valid;
	private String prodCatSearchStr;

	private double cartTotal;

	public void setCartTotal(double a) {
		cartTotal = a;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	private String[] cartProd;
	private String[] cartPric;
	private String prodIndex;
	private String[] prodNameArray;
	private String[] prodIDArray;
	private String[] prodDescArray;
	private String[] prodPriceArray;
	private String[] confirmArr;
	private String updateCatDesc;
	private String updateCatName;
	private String[] prodSKUArray;
	private String updateProdName;
	private String updateProdSKU;
	private String updateProdPrice;

	public String[] getCartProd() {
		return cartProd;
	}

	public void setCartProd(ArrayList<String> a) {
		cartProd = a.toArray(new String[a.size()]);
	}

	public String[] getCartPric() {
		return cartPric;
	}

	public void setCartPric(ArrayList<String> a) {
		cartPric = a.toArray(new String[a.size()]);
	}

	public String[] getprodSkuArr() {
		// System.out.println("IN GET SKU : " + prodSkuArr[0]);
		return prodSkuArr;
	}

	public String[] getprodCatArr() {
		return prodCatArr;
	}

	public String[] getprodPriArr() {
		return prodPriArr;
	}

	public void setprodSkuArr(String[] a) {
		prodSkuArr = a.clone();
	}

	public void setprodCatArr(String[] a) {
		prodCatArr = a.clone();
	}

	public void setprodPriArr(String[] a) {
		prodPriArr = a.clone();
	}

	public void setCatIndex(String index) {
		catIndex = Integer.parseInt(index);
	}

	public int getCatIndex() {
		return catIndex;
	}

	public void deleteCatByIndex(String str) {

	}

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
		System.out.println("setting name");
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

	public void setProdCatSearchStr(String str) {
		prodCatSearchStr = str;
	}

	public String getProdCatSearchStr() {
		return prodCatSearchStr;
	}

	public void setProdIndex(String index) {

		prodIndex = index;
	}

	public String getProdIndex() {
		return prodIndex;
	}

	public void setProdNameArrList(String[] array) {

		prodNameArray = array;
	}

	public void setProdIDArrList(String[] array) {

		prodIDArray = array.clone();
	}

	public void setProdDescArray(String[] array) {
		prodDescArray = array.clone();
	}

	public String[] getProdIDArrList() {
		// TODO Auto-generated method stub

		return prodIDArray;
	}

	public String[] getProdNameArrList() {
		// TODO Auto-generated method stub

		return prodNameArray;
	}

	public String[] getProdPriceArrList() {
		// TODO Auto-generated method stub
		return prodPriceArray;
	}

	public void setProdSKUArrList(String[] array) {
		// TODO Auto-generated method stub
		prodSKUArray = array;
	}

	public String[] getProdSKUArrList() {
		return prodSKUArray;
	}

	public void setProdPriceArray(String[] array) {
		// TODO Auto-generated method stub
		prodPriceArray = array;
	}

	public void setConfirmation(String[] arr) {
		confirmArr = arr.clone();
	}

	public String[] getConfirmation() {
		return confirmArr;
	}

	public String getCartProdID() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUpdateCatName() {
		// TODO Auto-generated method stub
		return updateCatName;
	}

	public String getUpdateCatDesc() {
		// TODO Auto-generated method stub
		return updateCatDesc;
	}

	public void setUpdateCatName(String parameter) {
		// TODO Auto-generated method stub
		updateCatName = parameter;
	}

	public void setUpdateCatDesc(String parameter) {
		// TODO Auto-generated method stub
		updateCatDesc = parameter;
	}

	public String getUpdateProdName() {
		// TODO Auto-generated method stub
		return updateProdName;

	}

	public String getUpdateProdSKU() {
		// TODO Auto-generated method stub
		return updateProdSKU;

	}

	public String getUpdateProdPrice() {
		// TODO Auto-generated method stub
		return updateProdPrice;

	}

	public void setUpdateProdName(String parameter) {
		// TODO Auto-generated method stub
		updateProdName = parameter;

	}

	public void setUpdateProdSKU(String parameter) {
		// TODO Auto-generated method stub
		updateProdSKU = parameter;

	}

	public void setUpdateProdPrice(String parameter) {
		// TODO Auto-generated method stub
		updateProdPrice = parameter;

	}
}