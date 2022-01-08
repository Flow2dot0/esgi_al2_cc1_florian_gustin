package com.amazen.membership.domain.cc2;

import com.amazen.kernel.Entity;
import com.amazen.kernel.MemberID;

public class Contractor implements Entity<MemberID> {

    private MemberID id;
    private Company company;

    public Contractor(MemberID id, Company company) {
        this.id = id;
        this.company = company;
    }

    @Override
    public MemberID getId() {
        return id;
    }

    @Override
    public void setId(MemberID memberID) {
        id = memberID;
    }
}
