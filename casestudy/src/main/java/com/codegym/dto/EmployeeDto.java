package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeeDto implements Validator {
    private Long id;
    @NotBlank(message = "Không được để trống.")
    private String name;
    @NotBlank(message = "Không được để trống.")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Ngày sinh phải đúng định dạng: dd/MM/yyyy.")
    private String birthday;
    @NotBlank(message = "Không được để trống.")
    @Pattern(regexp = "^([0-9]{9})|([0-9]{10})$",
            message = "Phải đúng định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX.")
    private String idCard;

    @Min(value = 0,message = "Phải là số nguyên dương")
    private double salary;

    @NotBlank(message = "Không được để trống.")
    @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Phải bắt đầu 090 hoặc 091x hoặc (84)+90 hoặc (84)+91")
    private String phone;

    @NotBlank(message = "Không được để trống.")
    @Pattern(regexp = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$",
            message = "Phải đúng định dạng")
    private String email;
    private String address;
    private int position;
    private int educationDegree;
    private int division;
    private String username;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, @NotBlank(message = "Không được để trống.") String name, @NotBlank(message = "Không được để trống.") String birthday, @NotBlank(message = "Không được để trống.") String idCard, double salary, @NotBlank(message = "Không được để trống.") @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Phải bắt đầu 090 hoặc 091x hoặc (84)+90 hoặc (84)+91") String phone, @NotBlank(message = "Không được để trống.") @Pattern(regexp = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$", message = "Phai dung dinh dang") String email, String address, int position, int educationDegree, int division, String username) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;

        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.username = username;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(int educationDegree) {
        this.educationDegree = educationDegree;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
