package edu.umb.cs680.hw11.multicast;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class MulticastTest {
	PiechartObserver piechartObserver = new PiechartObserver();
	TableObserver tableObserver = new TableObserver();
    THREEDObserver threeDObserver = new THREEDObserver();
	StockQuoteObservable stock = new StockQuoteObservable();
	DJIAQuoteObservable djia = new DJIAQuoteObservable();
	
	@Test
	public void DJIATest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      	System.setOut(new PrintStream(outContent));
		Random r = new Random(10);
		float quote = r.nextFloat()*10;
		djia.addObserver(threeDObserver);
		djia.addObserver(tableObserver);
		djia.addObserver(piechartObserver);
		djia.changeQuote(quote);
		assertEquals("3D of DJIAEvent: " + quote +
		"TableChart of DJIAEvent: " + quote +
		"PieChart of DJIAEvent: " + quote, outContent.toString());
		outContent.reset();
		quote = r.nextFloat()*10;
		djia.changeQuote(quote);
		assertEquals("3D of DJIAEvent: " + quote +
		"TableChart of DJIAEvent: " + quote +
		"PieChart of DJIAEvent: " + quote, outContent.toString());
	}
	@Test
	public void StockTest() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      	System.setOut(new PrintStream(outContent));
		Random r = new Random(10);
		float quote = r.nextFloat()*10;
		stock.addObserver(threeDObserver);
		stock.addObserver(tableObserver);
		stock.addObserver(piechartObserver);
		stock.changeQuote("apple", quote);
		assertEquals("3D of StockEvent: " + "apple" + " " + quote +
		"TableChart of StockEvent: " + "apple" + " " + quote +
		"PieChart of StockEvent: " + "apple" + " " + quote, outContent.toString());
		outContent.reset();
		quote = r.nextFloat()*10;
		stock.changeQuote("google", quote);
		assertEquals("3D of StockEvent: " + "google" + " " + quote +
		"TableChart of StockEvent: " + "google" + " " + quote +
		"PieChart of StockEvent: " + "google" + " " + quote, outContent.toString());
	}
}