package edu.umb.cs680.hw10;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car>{

	public int compare(Car car_1, Car car_2) {
		return car_1.getPrice() - car_2.getPrice();
	}

}