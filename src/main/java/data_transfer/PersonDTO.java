package data_transfer;

import constraints.DatePattern;
import constraints.ElementSize;

import javax.validation.constraints.*;
import java.util.List;

public class PersonDTO {

    @AssertTrue
    private Boolean isActive;
    @NotNull
    @Min(0)
    private String balance;
    @Positive
    private Integer age;
    private String eyeColor;

    @Size(min = 1, max = 30)
    private String name;

    private String gender;

    private String company;
    @Email
    private String email;
    private String phone;
    private String address;

    @DatePattern
    private String date;

    @ElementSize(min = 1, max = 5)
    private List<String> oldAddress;

    public PersonDTO() {
    }

    public PersonDTO(String name, Integer age) {
        this.name = name;
        this.age = age;

    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
