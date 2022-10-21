package com.example.fragmentrecyclerview;

import java.io.Serializable;

public class Country implements Serializable{

    private String country;
    private String map;
    private String capital;

    public Country(String country, String map, String capital) {
        this.country = country;
        this.map = map;
        this.capital = capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
