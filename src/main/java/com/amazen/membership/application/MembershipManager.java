package com.amazen.membership.application;

import com.amazen.kernel.MemberID;
import com.amazen.kernel.QueryBus;
import com.amazen.kernel.annotations.Manager;
import com.amazen.membership.domain.ContractorService;
import com.amazen.membership.domain.MemberService;
import com.amazen.membership.domain.TradesmanService;
import com.amazen.membership.exposition.MembershipRequest;

@Manager
public class MembershipManager {

    private final MemberService memberService;
    private final TradesmanService tradesmanService;
    private final ContractorService contractorService;

    public MembershipManager(MemberService memberService, TradesmanService tradesmanService, ContractorService contractorService) {
        this.memberService = memberService;
        this.tradesmanService = tradesmanService;
        this.contractorService = contractorService;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public TradesmanService getTradesmanService() {
        return tradesmanService;
    }

    public ContractorService getContractorService() {
        return contractorService;
    }

    public MemberID createMember(MembershipRequest request){
        CreateMember createMember = CreateMember.fromRequest(request);
//        MemberID memberID = commandBus.send(createMember);
        return new MemberID(1);
    }

}
