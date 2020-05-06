package de2bai1;
public class CurrencyTrading extends Trading {
	private double rate;
	private boolean type;
	public CurrencyTrading() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyTrading(String id, String date, int quantity, double price, double rate, boolean type) {
		super(id, date, quantity, price);
		this.rate = rate;
		this.type = type;
	}

	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	
	@Override
	public double getAmount() {
            if(type){
                return super.getAmount();
            }else{
                return super.getAmount()*rate; 
            }
		//Begin editable part
		//End editable part
	}

	@Override
	public String toString() {
		return "CurrencyTrading [rate=" + rate + ", type=" + type + ", getId()=" + getId() + ", getDate()=" + getDate()
				+ ", getQuantity()=" + getQuantity() + ", getPrice()=" + getPrice() + ", getAmount()=" + getAmount()
				+ "]";
	}
	
	
}
