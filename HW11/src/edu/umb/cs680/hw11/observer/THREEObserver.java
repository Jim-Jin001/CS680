package edu.umb.cs680.hw11.observer;

import java.util.Observable;
import java.util.Observer;

public class THREEObserver implements Observer{
	private StockEvent arg;
	@Override
	public void update(Observable o, Object arg) {
			this.arg = (StockEvent) arg;
			System.out.println(" 3D: " + this.arg.getTicker() + " " + this.arg.getQuote());;
		}
}

