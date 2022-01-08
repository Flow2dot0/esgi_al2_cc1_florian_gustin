package com.amazen.membership.application;

import com.amazen.kernel.Command;
import com.amazen.membership.domain.cc2.MemberType;
import com.amazen.membership.exposition.MemberRequest;

import java.util.Arrays;

public final class CreateMember implements Command {

    public final String email;
    public final String password;
    public CreateContractor createContractor;
    public CreateTradesman createTradesman;

    public CreateMember(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void apply(MemberRequest request){
        if(Arrays.stream(MemberType.values()).noneMatch(memberType -> memberType.getValue().equals(request.memberType))){
            throw new IllegalArgumentException();
        }
        switch (MemberType.valueOf(request.memberType)){
            case CONTRACTOR:
                createContractor = new CreateContractor(request.companyID, request.companyName, request.address, request.city);
            case TRADESMAN:
                createTradesman = new CreateTradesman(request.address, request.city, request.firstname, request.lastname, request.skills);
        }
    }
}
