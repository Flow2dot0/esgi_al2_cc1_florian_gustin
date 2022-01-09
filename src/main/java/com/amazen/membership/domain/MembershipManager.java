package com.amazen.membership.domain;

import com.amazen.kernel.annotations.Manager;

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
}
