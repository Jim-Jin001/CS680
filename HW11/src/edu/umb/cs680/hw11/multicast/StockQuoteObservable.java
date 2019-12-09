package edu.umb.cs680.hw11.multicast;


public class StockQuoteObservable extends Observable<StockEvent> {
	
	private StockEvent stockEvent;
	
	public void changeQuote(String t, float q){
		this.stockEvent = new StockEvent(t, q);
		this.setChanged();
		this.notifyObservers(stockEvent);
	}
}
