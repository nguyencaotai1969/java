package de2bai1;
public class GoldTrading extends Trading {

	public GoldTrading() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getAmount()
	{
		//Begin editable part
	return super.getAmount();
		//End editable part
	}
	public GoldTrading(String id, String date, int quantity, double price) {
		super(id, date, quantity, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GoldTrading [getId()=" + getId() + ", getDate()=" + getDate() + ", getQuantity()=" + getQuantity()
				+ ", getPrice()=" + getPrice() + ", getAmount()=" + getAmount() + "]";
	}

}
