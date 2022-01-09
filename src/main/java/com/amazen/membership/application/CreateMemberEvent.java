package com.amazen.membership.application;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.MemberID;
import com.amazen.membership.domain.Email;
import com.amazen.membership.domain.Password;

public class CreateMemberEvent implements DomainEvent {
    private final MemberID memberID;
    private final Email email;
    private final Password password;

    public CreateMemberEvent(MemberID memberID, Email email, Password password) {
        this.memberID = memberID;
        this.email = email;
        this.password = password;
    }

    public MemberID getMemberID() {
        return memberID;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "CreateMemberEvent{" +
                "memberID=" + memberID +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
