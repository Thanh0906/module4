package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;
    private int unit;
    private String status;
    @OneToMany(mappedBy = "attachService")
    private List<ContractDetail> contractDetails;

    public AttachService() {
    }


    public AttachService(String name, double cost, int unit, String status) {
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
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

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
