package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw02.PrimeGenerator;

public class PrimeGeneratorTest {
    @Test
    public void primeFrom1To10() {
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        Long[] expectedPrimes = { 2L, 3L, 5L, 7L };
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }

    @Test
    public void primeFrom_10To10() {
        try{
            PrimeGenerator gen = new PrimeGenerator(-10, 10);
            fail("Out of range");
        } catch(IllegalArgumentException ex) {
            assertEquals("start number should bigger than 0", ex.getMessage());
        }
    }

    @Test
    public void primeFrom100To1() {
        try {
            PrimeGenerator gen = new PrimeGenerator(100, 1);
            fail("Out of range");
        } catch (IllegalArgumentException ex) {
            assertEquals("end number should bigger than start number", ex.getMessage());
        }
    }
}
