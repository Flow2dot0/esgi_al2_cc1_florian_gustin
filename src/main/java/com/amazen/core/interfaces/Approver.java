package com.amazen.core.interfaces;

import com.amazen.core.approvers.MembershipProcessPOJO;

public abstract class Approver {

    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover){
        this.nextApprover = nextApprover;
    }

    public abstract void approve(MembershipProcessPOJO membershipProcessPOJO);

}
