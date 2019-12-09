package edu.umb.cs680.hw10;

import java.util.ArrayList;

public class Car {
	private int price;
	private int mileage;
	private int year;
	
	public Car(int price, int year, int mileage){
		this.price = price;
		this.mileage = mileage;
		this.year = year;
	}
	

	public int getPrice() {
		return price;
	}
	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}


	public int getDominationCount(ArrayList<Car> cars){
		int count = 0;
		for(Car car : cars){
			if( (car.getPrice() <= this.getPrice()) && (car.getMileage() <= this.getMileage()) && (car.getYear() >= this.getYear()))
				count++;
		}
		count--;
		return count;
	}
}