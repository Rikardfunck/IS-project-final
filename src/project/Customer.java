package project;

public class Customer {
	
	private String customerNbr;
	private String name;
	private String address;
	
	public Customer (String customerNbr, String name, String address){
		this.customerNbr=customerNbr;
		this.name=name;
		this.address=address;
	}
	public String getCustomerNbr() {
		return customerNbr;
	}
	public void setCustomerNbr(String customerNbr) {
		this.customerNbr = customerNbr;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
