package project;

import java.util.ArrayList;

public class ProductRegister {

	private ArrayList<Product> productList = new ArrayList<Product>();
	private ArrayList<Item> itemList = new ArrayList<Item>();

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	public Product findProductInList(String name) {
		for (Product tempProduct : productList) {
			if (tempProduct.getProductName().equals(name)) {
				return tempProduct;
			}
		}
		return null;
	}

	public Product removeProductFromList(String name) {
		Product tempProduct = this.findProductInList(name);
		if (tempProduct != null) {
			this.productList.remove(tempProduct);
		}
		return null;
	}

	public Item findItemInList(String serialNumber) {
		for (Item tempItem : itemList) {
			if (tempItem.getSerialNumber().equals(serialNumber)) {
				return tempItem;
			}
		}
		return null;
	}

	public Item removeItemFromList(String serialNumber) {
		Item tempItem = this.findItemInList(serialNumber);
		if (tempItem != null) {
			this.itemList.remove(tempItem);
		}
		return null;
	}

	public void addProductToList(Product addThisProduct) {
		this.productList.add(addThisProduct);
	}
	public void addItemToList(Item addThisItem) {
		this.itemList.add(addThisItem);
	}

	public Product changeProductInList(String productName, String category, int price) {
		Product foundProduct = this.findProductInList(productName);
		if (foundProduct != null) {
			foundProduct.setCategory(category);
			foundProduct.setPrice(price);
			return foundProduct;
		}
		return null;
	}

//	public String findProductitem(Product itemProduct) {
//		String tmp = "";
//		tmp += "Produkten " + itemProduct.getProductName() + " innehåller följande serienummer: \n";
//		for (Item temp : itemList) {
//			if (temp.getProduct().equals(itemProduct)) {
//				tmp += "Serienummer #" + temp.getSerialNumber() + "\n";
//			}
//		}
//		return tmp;
//	}
	public int getItemQuantity (Product productName){
		int quantity = 0;
		for (Item foundItem : itemList){
			if (foundItem.getProduct().equals(productName)){
				quantity += 1;
			}
		}
		return quantity;
	
	}
	
}
