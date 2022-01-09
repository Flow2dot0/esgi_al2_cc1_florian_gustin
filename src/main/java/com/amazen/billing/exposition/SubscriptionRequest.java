package com.amazen.billing.exposition;

public class SubscriptionRequest {
    public final int memberID;
    public final String memberType;

    public SubscriptionRequest(int memberID, String memberType) {
        this.memberID = memberID;
        this.memberType = memberType;
    }
}
