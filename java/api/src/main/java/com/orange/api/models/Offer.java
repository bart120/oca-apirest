package com.orange.api.models;

import java.util.ArrayList;
import java.util.List;

public class Offer {
    private long id;
    private String name;

    public Offer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Offer> getAllOffers() {
        Offer o1 = new Offer(1, "Illimité mobile");
        Offer o2 = new Offer(2, "Illimité voix");
        List<Offer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);
        return list;
    }
}
