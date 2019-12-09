package edu.umb.cs680.hw11.observer;

public class StockEvent {
	public static String ticker;
	public static float quote;
	public StockEvent(String t, float q) {
		StockEvent.ticker = t;
		StockEvent.quote = q;
	}
	public String getTicker() {
		return ticker;
	}
	public float getQuote() {
		return quote;
	}
}
