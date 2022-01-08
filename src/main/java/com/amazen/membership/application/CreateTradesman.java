package com.amazen.membership.application;

import com.amazen.kernel.Command;

import java.util.List;

public class CreateTradesman implements Command {
    private Integer memberID;
    private final String address;
    private final String city;
    private final String firstname;
    private final String lastname;
    private final List<String> skills;

    public CreateTradesman(String address, String city, String firstname, String lastname, List<String> skills) {
        this.address = address;
        this.city = city;
        this.firstname = firstname;
        this.lastname = lastname;
        this.skills = skills;
    }
}
