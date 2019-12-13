package edu.umb.cs680.hw15;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PriceComparatorTest {
	
	@Test
	public void compareTest(){
		Car[] carArray = {
			new Car(4000, 2002, 40000),
			new Car(7995, 2002, 84271),
			new Car(7998, 2002, 84272)};
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, (Car car1, Car car2)->{return car1.getPrice() - car2.getPrice();});
		assertEquals(4000, cars.get(0).getPrice());
		assertEquals(7995, cars.get(1).getPrice());
		assertEquals(7998, cars.get(2).getPrice());
	}
}