package com.amazen.membership.domain.cc2;

import com.amazen.kernel.Entity;
import com.amazen.kernel.MemberID;

import java.util.*;

public class Tradesman implements Entity<MemberID> {

    private Address address;
    private FullName fullname;
    private List<Skill> skills;

    public Tradesman(Address address, FullName fullname, List<Skill> skills) {
        this.address = address;
        this.fullname = fullname;
        this.skills = skills;
    }

    @Override
    public MemberID getId() {
        return null;
    }

    @Override
    public void setId(MemberID memberID) {

    }
}
