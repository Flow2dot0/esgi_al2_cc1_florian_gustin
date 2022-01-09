package com.amazen.subscription.domain;

import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.MemberID;
import com.amazen.membership.domain.MemberType;

import java.time.LocalDate;

public class PaymentSubscriptionEvent implements DomainEvent {
    private final MemberID memberID;
    private final MemberType type;
    private TransactionID transactionID;
    private Amount amount;
    private LocalDate date;
    private Status status;
    private Bank bank;

    public PaymentSubscriptionEvent(MemberID memberID, MemberType type, TransactionID transactionID, Amount amount, LocalDate date, Status status, Bank bank) {
        this.memberID = memberID;
        this.type = type;
        this.transactionID = transactionID;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.bank = bank;
    }

    public MemberID getMemberID() {
        return memberID;
    }

    public MemberType getType() {
        return type;
    }

    public TransactionID getTransactionID() {
        return transactionID;
    }

    public Amount getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    public Bank getBank() {
        return bank;
    }
}
