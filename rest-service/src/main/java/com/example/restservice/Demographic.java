package com.example.restservice;

public class Demographic {
    private String loc;

    @Override
    public String toString() {
        return "Demographic{" +
                "loc='" + loc + '\'' +
                '}';
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
