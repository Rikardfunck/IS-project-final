package project;

import java.util.ArrayList;

public class CustomerRegister {
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Order> orderList = new ArrayList<Order>();
	private ArrayList<OrderLine> orderLineList = new ArrayList<OrderLine>();
	private Integer orderCount = 0;
	
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}
	public ArrayList<OrderLine> getOrderLineList() {
		return orderLineList;
	}
	public void setOrderLineList(ArrayList<OrderLine> orderLineList) {
		this.orderLineList = orderLineList;
	}
	public Customer findCustomerInList (String customerNbr){
		for (Customer tempCustomer : customerList){
			if (tempCustomer.getCustomerNbr().equals(customerNbr)){
				return tempCustomer;
			}
		}
		return null;
	}
	public Customer removeCustomerFromList (String customerNbr){
		Customer tempCustomer = this.findCustomerInList(customerNbr);
		if (tempCustomer != null){
			this.customerList.remove(tempCustomer);
		}
		return null;
	}
	public Order findOrderInList (String orderID){
		for (Order tempOrder : orderList){
			if (tempOrder.getOrderID().equals(orderID)){
				return tempOrder;
			}
		}
		return null;
	}
	public Order removeOrderFromList (String orderID){
		Order tempOrder = this.findOrderInList(orderID);
		if (tempOrder != null){
			this.orderList.remove(tempOrder);
		}
		return null;
	}
	public OrderLine findOrderLineInList (String idNumber){
		for (OrderLine tempOrderLine : orderLineList){
			if (tempOrderLine.getIdNumber().equals(idNumber)){
				return tempOrderLine;
			}
		}	
		return null;
	}
	public OrderLine removeOrderLineFromList (String idNumber){
		OrderLine tempOrderLine = this.findOrderLineInList(idNumber);
		if (tempOrderLine != null){
			this.orderLineList.remove(tempOrderLine);
		}
		return null;
	}
	public void addCustomerToList (Customer addThisCustomer){
			this.customerList.add(addThisCustomer);
	}
	public void addOrderToList (Order addThisOrder){
			this.orderList.add(addThisOrder);
	}	
	public void addOrderLineToList (OrderLine addThisOrderLine){
		this.orderLineList.add(addThisOrderLine);
	}
	public Customer changeCustomerInList (String customerNbr, String customerName, String customerAddress){
		Customer foundCustomer = this.findCustomerInList(customerNbr);
		if (foundCustomer != null){
			foundCustomer.setName(customerName);
			foundCustomer.setAddress(customerAddress);
			return foundCustomer;
		}
		return null;
	}
	public int totalAmount(String orderNumber){
		int total = 0; 
		for(OrderLine totalAmountOrderLine : orderLineList){
			if (totalAmountOrderLine.getOrder().getOrderID().equals(orderNumber)) {
				total += totalAmountOrderLine.getProduct().getPrice() * totalAmountOrderLine.getQuantity();
			}
		}
		return total;
	}
		
	

}
