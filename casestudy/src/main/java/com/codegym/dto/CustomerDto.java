package com.codegym.dto;

import com.codegym.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private Long id;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^(KH-)(\\d{4})$",message = "Phải đúng định dạng KH-XXXX")
    private String customerCode;

    @NotBlank(message = "Họ tên không được để trống.")
    private String customerName;

    @NotBlank(message = "Ngày sinh không được để trống.")
    @Pattern(regexp = "^/(((0|1)[0-9]|2[0-9]|3[0-1])\\/(0[1-9]|1[0-2])/((19|20)\\d\\d))$/",
            message = "Ngày sinh phải đúng định dạng: dd/MM/yyyy.")
    private String customerBirthday;

    private int gender;

    @NotBlank(message = "Không được để trống.")
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$",
            message = "Phải đúng định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX.")
    private String idCard;

    @NotBlank(message = "Không được để trống.")
    @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Phải đúng định dạng: 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String numberPhone;
    private String email;
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Long id, @NotBlank(message = "không được để trống") @Pattern(regexp = "^(KH-)(\\d{4})$", message = "Phải đúng định dạng KH-XXXX") String customerCode, @NotBlank(message = "Họ tên không được để trống.") String customerName, String customerBirthday, int gender, String idCard, String numberPhone, String email, String address) {
        this.id = id;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.gender = gender;
        this.idCard = idCard;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
    }

    public CustomerDto(Long id, @NotBlank(message = "không được để trống") @Pattern(regexp = "^(KH-)(\\d{4})$", message = "Phải đúng định dạng KH-XXXX") String customerCode, @NotBlank(message = "Họ tên không được để trống.") String customerName, @NotBlank(message = "Ngày sinh không được để trống.") @Pattern(regexp = "^/(((0|1)[0-9]|2[0-9]|3[0-1])\\/(0[1-9]|1[0-2])/((19|20)\\d\\d))$/",
            message = "Ngày sinh phải đúng định dạng: dd/MM/yyyy.") String customerBirthday, int gender, @NotBlank(message = "Không được để trống.") @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$",
            message = "Phải đúng định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX.") String idCard, @NotBlank(message = "Không được để trống.") @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Phải đúng định dạng: 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx") String numberPhone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.gender = gender;
        this.idCard = idCard;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
