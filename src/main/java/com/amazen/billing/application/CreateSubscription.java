package com.amazen.billing.application;

import com.amazen.kernel.Command;

public class CreateSubscription implements Command {
    public final int memberID;
    public final String memberType;

    public CreateSubscription(int memberID, String memberType) {
        this.memberID = memberID;
        this.memberType = memberType;
    }
}
