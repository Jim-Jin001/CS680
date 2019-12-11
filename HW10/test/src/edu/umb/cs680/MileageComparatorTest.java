package edu.umb.cs680.hw10;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MileageComparatorTest {
	
	@Test
	public void MileageCompare(){
		Car[] carArray = {
			new Car(4000, 2002, 40000),
			new Car(7995, 2002, 84271),
			new Car(7998, 2002, 84272)};
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, new MileageComparator());
		assertEquals(40000, cars.get(0).getMileage());
		assertEquals(84271, cars.get(1).getMileage());
		assertEquals(84272, cars.get(2).getMileage());
	}
}