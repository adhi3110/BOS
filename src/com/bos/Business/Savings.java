package com.bos.Business;
import java.time.LocalDate;

import com.bos.Exceptions.*;
import java.time.Period;

import com.bos.Exceptions.InvalidAgeException;

public class Savings extends Account{

    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNo;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public void open() throws InvalidAgeException {
        int age = Period.between(this.dateOfBirth,LocalDate.now()).getYears();
        if(age<18) {
            throw new InvalidAgeException("Age has to be 18 years");
        }
        this.setActivitedDate(LocalDate.now());
        this.setActive(true);
    }
}
