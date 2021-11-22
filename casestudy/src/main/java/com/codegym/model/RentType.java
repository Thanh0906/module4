package com.codegym.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;

    @OneToMany(mappedBy = "rentType")
    private List<Service> services;
    public RentType() {
    }

    public RentType(Long id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
