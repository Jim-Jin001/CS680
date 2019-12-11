package edu.umb.cs680.hw10;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class YearComparatorTest {
	
	@Test
	public void YearCompare(){
		Car[] carArray = {
			new Car(4000, 2001, 40000),
			new Car(7995, 2002, 84271),
			new Car(7998, 2003, 84272)};
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, new YearComparator());
		assertEquals(2003, cars.get(0).getYear());
		assertEquals(2002, cars.get(1).getYear());
		assertEquals(2001, cars.get(2).getYear());
	}
}