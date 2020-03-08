package com.ckdemo.coronavirustracker;

public class InfectionStats {
    private String state;
    private String country;
    private int infectionCount;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getInfectionCount() {
        return infectionCount;
    }

    public void setInfectionCount(int infectionCount) {
        this.infectionCount = infectionCount;
    }
}
