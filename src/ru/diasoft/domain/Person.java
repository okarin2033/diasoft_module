package ru.diasoft.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Person {
    private final String firstName;
    private final String secondName;
    @Setter
    private int age;
    private String phone;

    public Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public Person(String firstName, String secondName, int age, String phone) throws InvalidPhoneNumberException {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        setPhone(phone);
    }

    public void setPhone(String phone) throws InvalidPhoneNumberException {
        if (phone == null || phone.isEmpty()) {
            this.phone = null;
            return;
        }
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        if (!digitsOnly.matches("[0-9]+")) {
            throw new InvalidPhoneNumberException("Phone contains invalid characters");
        }
        if (digitsOnly.length() < 10 || digitsOnly.length() > 15) {
            throw new InvalidPhoneNumberException("Phone has invalid length: " + digitsOnly.length());
        }
        this.phone = phone;
    }
}


