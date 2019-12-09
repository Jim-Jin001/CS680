package edu.umb.cs680.hw11.multicast;

public class TableObserver<T> implements Observer<T> {

	@Override
	public void update(T arg) {
		System.out.println(" Table: " + arg.toString());
	}

}
