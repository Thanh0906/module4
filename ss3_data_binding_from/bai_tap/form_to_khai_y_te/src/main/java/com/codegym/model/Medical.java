package com.codegym.model;

public class Medical {
    private int id;
    private String fullName;
    private String birthday;
    private String gender;
    private String idCard;
    private String address;
    private String phone;
    private String email;
    private String startAddress;
    private String comeAddress;
    private String travel;
    private boolean testPCR;

    public Medical() {
    }

    public Medical(int id, String fullName, String birthday, String gender, String idCard, String address, String phone, String email, String startAddress, String comeAddress, String travel, boolean testPCR) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.startAddress = startAddress;
        this.comeAddress = comeAddress;
        this.travel = travel;
        this.testPCR = testPCR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getComeAddress() {
        return comeAddress;
    }

    public void setComeAddress(String comeAddress) {
        this.comeAddress = comeAddress;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public boolean isTestPCR() {
        return testPCR;
    }

    public void setTestPCR(boolean testPCR) {
        this.testPCR = testPCR;
    }
}
