package project;

public class OrderLine {
	
	private String idNumber;
	private int quantityOrderLine;
	private Order order;
	private Product product;
	
	public OrderLine (String idNumber, int quantity, Order order, Product product){
		this.idNumber=idNumber;
		this.quantityOrderLine=quantity;
		this.order=order;
		this.product=product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public int getQuantity() {
		return quantityOrderLine;
	}
	public void setQuantity(int quantity) {
		this.quantityOrderLine = quantity;
	}
	

}
