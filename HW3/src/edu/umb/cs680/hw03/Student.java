package edu.umb.cs680.hw03;

class Student {
    float tution;
    String name;
    int i20num;
    String usAddr;
    int yrInState;
    String foreignAddr;
    StudentStatus status;

    protected Student(String name, String usAddr, int yrInState, int i20num, String foreignAddr, StudentStatus status) {
        this.name = name;
        this.usAddr = usAddr;
        this.yrInState = yrInState;
        this.status = status;
        this.i20num = i20num;
        this.foreignAddr = foreignAddr;
    }

    public float getTution() {
        return tution;
    }

    public String getName() {
        return name;
    }

    public int getI20num() {
        return i20num;
    }

    public String getUsAddr() {
        return usAddr;
    }

    public int getYrInState() {
        return yrInState;
    }

    public String getForeignAddr() {
        return foreignAddr;
    }

    public StudentStatus getStatus() {
        return status;
    }
    public void setTution(float tution) {
        this.tution = tution;
    }

}