package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	public void getYearTest(){
		Car car = new Car(4880, 2000, 136636);
		int actual = car.getYear();
		int expected = 2000;
		assertEquals(actual,expected);
	}
	
	@Test
	public void getMileageTest(){
		Car car = new Car(4880, 2000, 136636);
		int actual = car.getMileage();
		int expected = 136636;
		assertEquals(actual,expected);
	}
	
	@Test
	public void getPriceTest(){
		Car car = new Car(4880, 2000, 136636);
		int actual = car.getPrice();
		int expected = 4880;
		assertEquals(actual,expected);
	}
}

	

	