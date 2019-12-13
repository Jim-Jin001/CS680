package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ParetoComparatorTest {
	@Test
	public void ParetoCompare(){
		Car[] carArray = {
			new Car(4000, 2002, 40000),
			new Car(7995, 2002, 84271),
			new Car(7998, 2002, 84272),
			new Car(8000, 2019, 8888)};
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
        for(Car car: cars){ 
            car.setDominationCount(cars); 
        }
		Collections.sort(cars, (Car car1, Car car2)->{return car2.getDominationCount() - car1.getDominationCount();});
		assertEquals(4000, cars.get(0).getPrice());
		assertEquals(7995, cars.get(1).getPrice());
		assertEquals(7998, cars.get(2).getPrice());
		assertEquals(8000, cars.get(3).getPrice());
	}
}