package de2bai1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TradingManagement {

	public TradingManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trading[] readData(String fileName) {
		try {
			Scanner input = new Scanner(new File(fileName));
			int n;
			n = Integer.parseInt(input.nextLine());
			Trading[] _trading = new Trading[n];
			String id, date;
			double price, rate, amount;
			int quantity, c;

			for (int i = 0; i < n; i++) {
				c = Integer.parseInt(input.nextLine());
				id = input.nextLine();
				date = input.nextLine();
				quantity = Integer.parseInt(input.nextLine());
				price = Double.parseDouble(input.nextLine());
				if (c == 1) {
					_trading[i] = (Trading) new GoldTrading(id, date, quantity, price);
				}

				else {
					rate = Double.parseDouble(input.nextLine());
					boolean type = (Integer.parseInt(input.nextLine()) == 1);
					_trading[i] = (Trading) new CurrencyTrading(id, date, quantity, price, rate, type);
				}
			}
			return _trading;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void printTradings(Trading[] tradings) {
		for (int i = 0; i < tradings.length; i++)
		{
			System.out.println(tradings[i].toString());
		}
	}

	public List<Trading> findMaxTradings(Trading[] tradings) {
		//Begin editable part
                List<Trading> listMax = new ArrayList<>();
                double max =0;
                for (Trading trading : tradings) {
                if(trading.getAmount()>max){
                    max = trading.getAmount();
                }
            }
                for (Trading trading : tradings) {
                if(trading.getAmount()>=max){
                    listMax.add(trading);
                }
            }
	return listMax;
		//End editable part
	}

	public void sortByPrice(Trading[] tradings) {
		//Begin editable part
                for(int i=0;i < tradings.length;i++){
                    for(int j=0;j<i+1;j++){
                        if(tradings[j].getPrice()>tradings[i].getPrice()){
                            Trading temp;
                            temp = tradings[i];
                            tradings[i]=tradings[j];
                            tradings[j]=temp;
                        }
                    }
                }
		//End editable part
	}

	public double computeAverage(Trading[] tradings, String typeOfTrading) {
		//Begin editable part
	   
        double sum = 0;
       for(Trading  trading :tradings){
            if(typeOfTrading.equals("Gold")){
              sum += trading.getAmount();
        }else{
              sum += trading.getAmount();            
        }
       }
        return (sum>0)?sum/tradings.length:0;
		//End editable part
	}

	public static void main(String[] args) {
		TradingManagement tradingManagement = new TradingManagement();
		Trading[] tradings = tradingManagement.readData("trading.txt");
		tradingManagement.printTradings(tradings);
	}

}
