package com.amazen.membership.exposition;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

public class MembershipRequest {
    public Integer memberIdD;

    @NotNull
    @NotBlank
    public String email;

    @NotNull
    @NotBlank
    public String password;

    @NotNull
    @NotBlank
    public String address;

    @NotNull
    @NotBlank
    public String city;

    public String firstname;
    public String lastname;
    public String companyName;
    public String companyID;
    public List<String> skills;

    @NotNull
    @NotBlank
    public String memberType;

//    public MembershipRequest(String email, String password, String address, String city, String memberType) {
//        this.email = email;
//        this.password = password;
//        this.address = address;
//        this.city = city;
//        this.memberType = memberType;
//    }
}
