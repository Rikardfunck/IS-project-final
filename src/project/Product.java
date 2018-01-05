package project;

public class Product {

	private String productName;
	private String category;
	private int price;
	
	public Product (String productName, String category, int price){
		this.productName=productName;
		this.category=category;
		this.price=price;
	}
	public String getProductName() {
		return this.productName;
	}
	public void setName(String name) {
		this.productName = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
