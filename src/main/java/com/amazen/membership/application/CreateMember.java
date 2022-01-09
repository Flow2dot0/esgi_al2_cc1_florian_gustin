package com.amazen.membership.application;

import com.amazen.kernel.Command;
import com.amazen.membership.domain.MemberType;
import com.amazen.membership.exposition.MembershipRequest;

import java.util.Arrays;
import java.util.Objects;

public final class CreateMember implements Command {

    public final String email;
    public final String password;
    public CreateContractor createContractor;
    public CreateTradesman createTradesman;

    private CreateMember(MembershipRequest request) {
        this.email = Objects.requireNonNull(request.email);
        this.password = Objects.requireNonNull(request.password);
        getType(request);
    }

    public static CreateMember fromRequest(MembershipRequest request){
        return new CreateMember(request);
    }

    public void getType(MembershipRequest request){
        if(Arrays.stream(MemberType.values()).noneMatch(memberType -> memberType.getValue().equals(request.memberType))){
            throw new IllegalArgumentException();
        }
        switch (MemberType.valueOf(request.memberType.toUpperCase())){
            case CONTRACTOR:
                createContractor = new CreateContractor(request.companyID, request.companyName, request.address, request.city);
                break;
            case TRADESMAN:
                createTradesman = new CreateTradesman(request.address, request.city, request.firstname, request.lastname, request.skills);
                break;
        }
    }
}
