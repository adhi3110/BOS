package com.bos.Business;
import java.time.LocalDate;

import com.bos.Exceptions.InvalidRegistrationNoException;

public class Current extends Account{

    private String companyName;
    private String website;
    private String registrationNo;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Override
    public void open() throws InvalidRegistrationNoException {
        if(this.registrationNo == null) {
            throw new InvalidRegistrationNoException("Registration No is invalid");
        }
        this.setActivitedDate(LocalDate.now());
        this.setActive(true);
    }
}
