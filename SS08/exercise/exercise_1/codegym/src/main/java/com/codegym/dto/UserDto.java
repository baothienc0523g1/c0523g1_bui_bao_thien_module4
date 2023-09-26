package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class UserDto implements Validator {
    @NotBlank(message = "Please fill this field")
    @NotNull(message = "Please fill this field")
    private String firstName;
    @NotBlank(message = "Please fill this field")
    @NotNull(message = "Please fill this field")
    private String lastName;
    @NotBlank(message = "Please fill this field")
    @NotNull(message = "Please fill this field")
    private Integer age;
    @NotBlank(message = "Please fill this field")
    @NotNull(message = "Please fill this field")
    private String phoneNumber;
    @Email(message = "Wrong email address!")
    @NotBlank(message = "Please fill this field")
    @NotNull(message = "Please fill this field")
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String phoneRegex = "^[0][0-9]{9,10}$";
        int firstNameLength = userDto.getFirstName().length();
        int lastNameLength = userDto.getLastName().length();
        int age = userDto.getAge();
        String phoneNumber = userDto.getPhoneNumber();

        // Name validation
        if (firstNameLength < 5) {
            errors.rejectValue("firstName", null, "First name should me longer than 5 characters");
        } else if (firstNameLength > 45) {
            errors.rejectValue("firstName", null, "First name should me less than 45 characters");
        }
        if (lastNameLength < 5) {
            errors.rejectValue("lastName", null, "Last name should me longer than 5 characters");
        } else if (lastNameLength > 45) {
            errors.rejectValue("lastName", null, "Last name should me less than 45 characters");
        }

        // Age validation
        if (age < 18) {
            errors.rejectValue("age", null, "You must be older than 18 to register");
        } else if (String.valueOf(age) == "") {
            errors.rejectValue("age", null, "Please fill this field");
        }

        // Phone validation
        if (!phoneNumber.matches(phoneRegex)) {
            errors.rejectValue("phoneNumber", null, "Wrong syntax of phone number, phone number" +
                    "start with '0' and must have 10 or 11 numbers");
        }
    }

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, Integer age, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
