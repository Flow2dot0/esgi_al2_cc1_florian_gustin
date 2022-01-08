package com.amazen._subscription;

import com.amazen._kernel.abstracts.Entity;
import com.amazen._kernel.value_objects.Amount;
import com.amazen._kernel.abstracts.MemberId;
import com.amazen._membership.domain.Transaction;

import java.time.LocalDate;
import java.util.*;

public class Subscription implements Entity<SubscriptionId> {
    private SubscriptionId id;
    private List<Transaction> history;
    private Amount amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate renewDate;
    private MemberId memberId;

    @Override
    public SubscriptionId getId() {
        return id;
    }

    @Override
    public void setId(SubscriptionId subscriptionId) {
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

    public MemberId getMemberId() {
        return memberId;
    }

    public void setMemberId(MemberId memberId) {
        this.memberId = memberId;
    }
}
