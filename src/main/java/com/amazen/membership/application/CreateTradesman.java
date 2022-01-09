package com.amazen.membership.application;

import com.amazen.kernel.Command;

import java.util.List;

public class CreateTradesman implements Command {
    public Integer memberID;
    public final String address;
    public final String city;
    public final String firstname;
    public final String lastname;
    public final List<String> skills;

    public CreateTradesman(String address, String city, String firstname, String lastname, List<String> skills) {
        this.address = address;
        this.city = city;
        this.firstname = firstname;
        this.lastname = lastname;
        this.skills = skills;
    }
}
