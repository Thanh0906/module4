package com.codegym.module;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "loi ")
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank
    private String phoneNumber;

    @NotNull
    @Min(value = 18)
    private Integer age;

    @Email
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",
            message = "Email phải đúng định dạng")
    private String email;
    public User() {
    }


    public User(@NotNull @Size(min = 5, max = 45) String firstName, @NotNull @Size(min = 5, max = 45) String lastName,
                @NotNull String phoneNumber, @NotNull @Min(value = 18) Integer age,
                @Email @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User(Long id, @NotNull @Size(min = 5, max = 45) String firstName, @NotNull @Size(min = 5, max = 45) String lastName,
                @NotNull String phoneNumber, @NotNull @Min(value = 18) Integer age,
                @Email @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phoneNumber = user.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "number.empty");
         if (phoneNumber.length()>11 ||phoneNumber.length()<10){
                    errors.rejectValue("phoneNumber", "number.length");
                }
                if (!phoneNumber.startsWith("0")){
                    errors.rejectValue("phoneNumber", "number.startsWith");
                }
                if (!phoneNumber.matches("(^$|[0-9]*$)")){
                    errors.rejectValue("phoneNumber", "number.matches");
                }
    }
}