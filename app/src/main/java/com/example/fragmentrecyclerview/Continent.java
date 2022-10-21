package com.example.fragmentrecyclerview;

import java.io.Serializable;

public class Continent implements Serializable {

    private String name;
    private String card;

    public Continent(String name, String card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
