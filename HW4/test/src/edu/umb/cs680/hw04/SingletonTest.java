package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.Singleton;

public class SingletonTest {
    @Test
    public void sameInstanceTest() {
        Singleton ins1 = Singleton.getInstance();
        Singleton ins2 = Singleton.getInstance();
        assertSame(ins1, ins2);
    }
}
