package edu.umb.cs680.hw15;

import java.util.ArrayList;

public class Car {
	private int price;
	private int mileage;
	private int year;
	private int dominationCount;
	
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

	public void setDominationCount(ArrayList<Car> cars){
		for(Car car: cars) {
			if( (car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage()) && (car.getYear() <= this.getYear())){
				this.dominationCount++;
			}
		}
		this.dominationCount--; // minus the count for itself.
	}
	public int getDominationCount(){
		return this.dominationCount;
	}
}