package edu.umb.cs680.hw11.multicast;

public class StockEvent {

	private String ticker;
	private float quote;
	
	public StockEvent(String ticker, float quote){
		this.ticker = ticker;
		this.quote = quote;
	}
	
	public String getTicker(){
		return this.ticker;
	}
	
	public float getQuote(){
		return this.quote;
	}
	
	@Override
	public String toString(){
		return ticker + " " + quote; 
	}
}
