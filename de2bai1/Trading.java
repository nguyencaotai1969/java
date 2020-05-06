package de2bai1;
public class Trading {
	private String id;
	private String date;
	private int quantity;
	private double price;
	private double amount;
	
	
	public Trading(String id, String date, int quantity, double price) {
		super();
		this.id = id;
		this.date = date;
		this.quantity = quantity;
		this.price = price;
	}

	public Trading() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return this.getPrice() * this.getQuantity();
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
