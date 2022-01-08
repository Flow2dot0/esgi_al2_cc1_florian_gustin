package com.amazen.subscription.domain;



import com.amazen.kernel.Entity;
import com.amazen.kernel.MemberID;

import java.time.LocalDate;
import java.util.List;

public class Subscription implements Entity<SubscriptionID> {
    private SubscriptionID id;
    private List<Transaction> history;
    private Amount amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate renewDate;
    private MemberID memberID;

    @Override
    public SubscriptionID getId() {
        return id;
    }

    @Override
    public void setId(SubscriptionID subscriptionId) {
        id = subscriptionId;
    }

    public List<Transaction> getHistory() {
        return history;
    }

    public void setHistory(List<Transaction> history) {
        this.history = history;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(LocalDate renewDate) {
        this.renewDate = renewDate;
    }

    public MemberID getMemberID() {
        return memberID;
    }

    public void setMemberID(MemberID memberID) {
        this.memberID = memberID;
    }
}
