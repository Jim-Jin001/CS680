package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw03.*;

class StudentTest {
    @Test
    public void createInStateStudentTest() {
        Student st = StudentFactory.createInStateStudent("Bill", "Boston");
        String usAddr = st.getUsAddr();
        float tution = st.getTution();
        String name = st.getName();
        int i20Num = st.getI20num();
        int yrInState = st.getYrInState();
        String foreignAddr = st.getForeignAddr();
        StudentStatus status = st.getStatus();
        assertEquals(usAddr, "Boston");
        assertEquals(tution, 1000f);
        assertEquals(name, "Bill");
        // should be integer.min_value, because they do not have i20.
        assertEquals(i20Num, Integer.MIN_VALUE);
        // should be integer.max_value, because they live in state.
        assertEquals(yrInState, Integer.MAX_VALUE);
        // should be null, because they do not have foreign address.
        assertEquals(foreignAddr, null);
        assertEquals(status, StudentStatus.INSTATE);
    }

    @Test
    public void createOutStateStudentTest() {
        Student st = StudentFactory.createOutStateStudent("John", "New York", 10);
        String usAddr = st.getUsAddr();
        float tution = st.getTution();
        String name = st.getName();
        int i20Num = st.getI20num();
        int yrInState = st.getYrInState();
        String foreignAddr = st.getForeignAddr();
        StudentStatus status = st.getStatus();
        assertEquals(usAddr, "New York");
        assertEquals(tution, 10000f);
        assertEquals(name, "John");
        // should be integer.min_value, because they do not have i20.
        assertEquals(i20Num, Integer.MIN_VALUE);
        assertEquals(yrInState, 10);
        // should be null, because they do not have foreign address.
        assertEquals(foreignAddr, null);
        assertEquals(status, StudentStatus.OUTSTATE);
    }

    @Test
    public void createIntlStateStudentTest() {
        Student st = StudentFactory.createIntlStudent("Mike", "Boston", 123456, "China");
        String usAddr = st.getUsAddr();
        float tution = st.getTution();
        String name = st.getName();
        int i20Num = st.getI20num();
        int yrInState = st.getYrInState();
        String foreignAddr = st.getForeignAddr();
        StudentStatus status = st.getStatus();
        assertEquals(usAddr, "Boston");
        assertEquals(tution, 20000f);
        assertEquals(name, "Mike");
        assertEquals(i20Num, 123456);
        // should be integer.min_value, because they are international student.
        assertEquals(yrInState, Integer.MIN_VALUE);
        assertEquals(foreignAddr, "China");
        assertEquals(status, StudentStatus.INTL);
    }
}

