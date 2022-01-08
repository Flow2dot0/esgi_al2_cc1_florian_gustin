package com.amazen.membership.application;

import com.amazen.kernel.Command;
import com.amazen.membership.domain.cc2.Address;
import com.amazen.membership.domain.cc2.City;

public class CreateContractor implements Command {
    public Integer memberID;
    private final String companyID;
    private final String name;
    private final String address;
    private final String city;

    public CreateContractor(String companyID, String name, String address, String city) {
        this.companyID = companyID;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}
