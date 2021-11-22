package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int numberOfFloors;
    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id", referencedColumnName = "id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private List<Contract> contractList;

    public Service() {
    }

    public Service(Long id, String name, int area, double cost, int maxPeople, String standardRoom, String description, double poolArea, int numberOfFloors, RentType rentType, ServiceType serviceType, List<Contract> contractList) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.contractList = contractList;
    }



    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType renType) {
        this.rentType = renType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
