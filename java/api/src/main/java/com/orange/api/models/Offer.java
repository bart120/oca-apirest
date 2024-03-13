package com.orange.api.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "label", length = 80, nullable = false)
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
