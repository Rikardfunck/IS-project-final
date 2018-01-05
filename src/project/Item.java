package project;

public class Item {
	
	private String serialNumber;
	private Product product;

	public Item (String serialNumber, Product product){
		this.serialNumber=serialNumber;
		this.product=product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
