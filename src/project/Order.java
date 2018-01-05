package project;

public class Order {
	
	private String orderID;
	private String deliveryDate;
	private Customer customer;
	
	public Order (String orderID, String deliveryDate, Customer customer){
		this.orderID=orderID;
		this.deliveryDate=deliveryDate;
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	

}
