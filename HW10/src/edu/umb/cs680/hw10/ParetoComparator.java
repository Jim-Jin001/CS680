package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.Comparator;

public class ParetoComparator  implements Comparator<Car>{

	ArrayList<Car> usedCars = new ArrayList<Car>();
	public ParetoComparator(ArrayList<Car> usedCars) {
		this.usedCars = usedCars;
	}

	public int compare(Car car_1, Car car_2) {
		if(car_1.getDominationCount(usedCars) == car_2.getDominationCount(usedCars))
			return 0;
		else if(car_1.getDominationCount(usedCars) > car_2.getDominationCount(usedCars))
			return 1;
		else
			return -1;
	}

}