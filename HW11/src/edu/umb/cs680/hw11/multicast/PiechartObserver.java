package edu.umb.cs680.hw11.multicast;

public class PiechartObserver<T> implements Observer<T> {
	
	@Override
	public void update(T arg) {
		System.out.println(" PieChart: " + arg.toString());
	}

}
