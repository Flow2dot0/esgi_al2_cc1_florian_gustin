package com.amazen.membership.domain.cc2;

import com.amazen.kernel.Entity;
import com.amazen.kernel.MemberID;

public class Member implements Entity<MemberID> {

    private MemberID id;
    private Email email;
    private Password password;


    public Member(MemberID memberID, Email email, Password password) {
        this.id = memberID;
        this.email = email;
        this.password = password;
    }

    @Override
    public MemberID getId() {
        return id;
    }

    @Override
    public void setId(MemberID memberID) {
        id = memberID;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

}
