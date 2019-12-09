package edu.umb.cs680.hw11.multicast;

public class ThreeObserver<T>  implements Observer<T> {

	@Override
	public void update(T arg) {
		System.out.println(" 3D: " + arg.toString());
	}

}
