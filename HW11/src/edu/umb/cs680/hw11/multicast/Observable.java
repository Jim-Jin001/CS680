package edu.umb.cs680.hw11.multicast;

import java.util.ArrayList;

public class Observable<T> {

	public ArrayList<Observer<T>> observers;
	private boolean changed;

	public Observable() {
		observers = new ArrayList<Observer<T>>();
		changed = false;
	}

	public void addObserver(Observer<T> observer) {
		this.observers.add(observer);
	}

	public void setChanged() {
		this.changed = true;
	}

	public boolean hasChanged() {
		return this.changed;
	}

	public void clearChanged() {
		this.changed = false;
	}

	public void notifyObservers() {
		notifyObservers(null);
	}

	public void notifyObservers(T arg) {
		if (hasChanged()) {
			for (Observer<T> o : this.observers) {
				o.update(arg);
			}
			clearChanged();
		}
	}

}
