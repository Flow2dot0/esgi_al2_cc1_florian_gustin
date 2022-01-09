package com.amazen.billing.exposition;

public class SubscriptionResponse {
    public int memberID;
    public double amount;
    public String status;

    public SubscriptionResponse(int memberID, double amount, String status) {
        this.memberID = memberID;
        this.amount = amount;
        this.status = status;
    }

    public SubscriptionResponse(int memberID) {
        this.memberID = memberID;
    }
}
