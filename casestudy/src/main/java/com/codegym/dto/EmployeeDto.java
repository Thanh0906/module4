package com.codegym.dto;

import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Position;
import com.codegym.model.User;
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
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private User user;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, @NotBlank(message = "Không được để trống.") String name, @NotBlank(message = "Không được để trống.") @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Ngày sinh phải đúng định dạng: dd/MM/yyyy.") String birthday, @NotBlank(message = "Không được để trống.") @Pattern(regexp = "^([0-9]{9})|([0-9]{10})$",
            message = "Phải đúng định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX.") String idCard, @Min(value = 0, message = "Phải là số nguyên dương") double salary, @NotBlank(message = "Không được để trống.") @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Phải bắt đầu 090 hoặc 091x hoặc (84)+90 hoặc (84)+91") String phone, @NotBlank(message = "Không được để trống.") @Pattern(regexp = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$",
            message = "Phải đúng định dạng") String email, String address, Position position, EducationDegree educationDegree, Division division, User user) {
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
        this.user = user;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
