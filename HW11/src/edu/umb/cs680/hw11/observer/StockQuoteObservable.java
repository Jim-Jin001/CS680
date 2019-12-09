package edu.umb.cs680.hw11.observer;


import java.util.Observable;

public class StockQuoteObservable extends Observable{
	private StockEvent stockEvent;
	
	public void changeQuote(String t, float q) {
			this.stockEvent = new StockEvent(t,q);
			this.setChanged();
		
		this.notifyObservers(stockEvent); 
	}
}
