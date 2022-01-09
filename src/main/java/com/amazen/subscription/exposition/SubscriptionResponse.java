package com.amazen.subscription.exposition;

public class SubscriptionResponse {
    public String memberID;
    public double amount;
    public String status;

    public SubscriptionResponse(String memberID, double amount, String status) {
        this.memberID = memberID;
        this.amount = amount;
        this.status = status;
    }
}
