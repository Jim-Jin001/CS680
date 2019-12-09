package edu.umb.cs680.hw11.multicast;


public class DJIAQuoteObservable extends Observable<DJIAEvent> {
	
	private float quote;

	public void changeQuote(float q)
	{	
        this.quote = q;
        setChanged();
        notifyObservers(new DJIAEvent(q));
	}

}