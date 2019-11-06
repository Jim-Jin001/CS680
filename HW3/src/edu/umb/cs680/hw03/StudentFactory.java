package edu.umb.cs680.hw03;

class StudentFactory {

    // private constructor
    private StudentFactory() {
    }

    public static Student createInStateStudent(String name, String usAddr) {
        Student st = new Student(name, usAddr, Integer.MAX_VALUE, Integer.MIN_VALUE, null, StudentStatus.INSTATE);
        st.setTution(1000f);
        return st;
    }

    public static Student createOutStateStudent(String name, String usAddr, int yrsinState) {
        Student st = new Student(name, usAddr, yrsinState, Integer.MIN_VALUE, null, StudentStatus.OUTSTATE);
        st.setTution(10000f);
        return st;

    }

    public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr) {
        Student st = new Student(name, usAddr, Integer.MIN_VALUE, i20num, foreignAddr, StudentStatus.INTL);
        st.setTution(20000f);
        return st;
    }
}