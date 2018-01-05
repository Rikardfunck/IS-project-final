package project;

import java.util.ArrayList;

public class Controller {
	
	CustomerRegister customerRegister = new CustomerRegister();
	ProductRegister productRegister = new ProductRegister();

	public Customer searchCustomerinList (String customerNbr){
		return customerRegister.findCustomerInList(customerNbr);
	}
	public Order searchOrderinList (String orderID){
		return customerRegister.findOrderInList(orderID);
	}
	public OrderLine searchOrderLineinList (String idNumber){
		return customerRegister.findOrderLineInList(idNumber);
	}
	public Customer removeCustomerFromList (String customerNbr){
		return customerRegister.removeCustomerFromList(customerNbr);
	}
	public Order removeOrderFromList (String orderID){
		return customerRegister.removeOrderFromList(orderID);
	}
	public OrderLine removeOrderLineFromList (String idNumber){
		return customerRegister.removeOrderLineFromList(idNumber);
	}
	public void addCustomerToList (Customer addThisCustomer){
		customerRegister.addCustomerToList(addThisCustomer);
	}
	public void addOrderToList (Order addThisOrder){
		customerRegister.addOrderToList(addThisOrder);
	}
	public void addOrderLineToList (OrderLine addThisOrderLine){
		customerRegister.addOrderLineToList(addThisOrderLine);
	}
	public Product searchProductInList (String name){
		return productRegister.findProductInList(name);
	}
	public Item searchIteminList (String serialNumber){
		return productRegister.findItemInList(serialNumber);
	}
	public Item removeItemFromList (String serialNumber){
		return productRegister.removeItemFromList(serialNumber);
	}
	public Product removeProductFromList (String name){
		return productRegister.removeProductFromList(name);
	}
	public void addItemToList (Item addThisItem){
		productRegister.addItemToList(addThisItem);
	}
	public void addProductToList (Product addThisProduct){
		productRegister.addProductToList(addThisProduct);
	}
	public Product changeProductInList (String productName, String category, int price){
		return productRegister.changeProductInList(productName, category, price);
	}
	public Customer changeCustomerInList (String customerNbr, String customerName, String customerAddress){
		return customerRegister.changeCustomerInList(customerNbr, customerName, customerAddress);
	}
	public int totalAmountForOrder (String orderNumber){
		return customerRegister.totalAmount(orderNumber);
	}
	public ArrayList<Item> getItemList (){
		return productRegister.getItemList();
	}
	public int getItemQuantity (Product productName){
		return productRegister.getItemQuantity(productName);
	}
}
