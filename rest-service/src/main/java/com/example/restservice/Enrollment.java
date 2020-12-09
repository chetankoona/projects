package com.example.restservice;

public class Enrollment {
    private String name;
    private String value1;
    private String value2;
    private Demographic demographic;

    @Override
    public String toString() {
        return "Enrollment{" +
                "name='" + name + '\'' +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", demographic=" + demographic +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public void setDemographic(Demographic demographic) {
        this.demographic = demographic;
    }
}
