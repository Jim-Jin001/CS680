package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Car;


public class CarTest {
    // transfer make, model and year into array;
    private String[] carToStringArray(Car car) {
        String[] carInfo = {car.getMake(),car.getModel(),Integer.toString(car.getYear())};
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
         String[] expected = {"Toyota", "RAV4", "2018"}; 
         Car actual = new Car("Toyota", "RAV4", 1000, 2018, 20000f); 
         assertArrayEquals(expected, carToStringArray(actual));
    }
    
    @Test
    public void seondVerifyCarEqualityWithMakeModelYear() {
        String[] expected = { "Hoda", "CRV", "2017" };
        Car actual = new Car("Hoda", "CRV", 2000, 2017, 21000f);
        assertArrayEquals(expected, carToStringArray(actual));
    }
}