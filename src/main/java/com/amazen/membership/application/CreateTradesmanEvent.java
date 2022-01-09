package com.amazen.membership.application;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.MemberID;
import com.amazen.membership.domain.Address;
import com.amazen.membership.domain.FullName;
import com.amazen.membership.domain.Skill;

import java.util.List;

public class CreateTradesmanEvent implements DomainEvent {
    public final MemberID id;
    public final Address address;
    public final FullName fullname;
    public final List<Skill> skills;

    public CreateTradesmanEvent(MemberID id, Address address, FullName fullname, List<Skill> skills) {
        this.id = id;
        this.address = address;
        this.fullname = fullname;
        this.skills = skills;
    }
}
