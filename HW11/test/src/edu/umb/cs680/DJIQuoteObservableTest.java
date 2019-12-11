package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


public class DJIAQuoteObservableTest {

	DJIAQuoteObservable dJIAQuoteObservable = new DJIAQuoteObservable();
	 Set<Float> data = new HashSet<Float>();
	
	public void setup()
	{
		dJIAQuoteObservable.addObservers(new PiechartObserver());
		dJIAQuoteObservable.addObservers(new TableObserver());
		dJIAQuoteObservable.addObservers(new ThreeDObserver());
	}
	
	@Test
	public void testObserver()
	{
		dJIAQuoteObservable.changeQuote(40);
		dJIAQuoteObservable.changeQuote(65);
		dJIAQuoteObservable.changeQuote(80);
		data.add((float) 40);
		data.add((float) 65);
		data.add((float) 80);
		assertTrue(dJIAQuoteObservable.getData().containsAll(data));
	}
}