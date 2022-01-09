package com.amazen.billing.application;

import com.amazen.kernel.ApplicationEvent;
import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.MemberID;
import com.amazen.membership.domain.MemberType;
import com.amazen.billing.domain.Amount;
import com.amazen.billing.domain.Bank;
import com.amazen.billing.domain.Status;
import com.amazen.billing.domain.TransactionID;

import java.time.LocalDate;

public class CreateSubscriptionEvent implements DomainEvent {
    private final MemberID memberID;
    private final MemberType type;
    private TransactionID transactionID;
    private Amount amount;
    private LocalDate date;
    private Status status;
    private Bank bank;


    public CreateSubscriptionEvent(MemberID memberID, MemberType type, TransactionID transactionID, Amount amount, LocalDate date, Status status, Bank bank) {
        this.memberID = memberID;
        this.type = type;
        this.transactionID = transactionID;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.bank = bank;
    }

    public CreateSubscriptionEvent(MemberID memberID, MemberType type, Amount amount) {
        this.memberID = memberID;
        this.type = type;
        this.amount = amount;
    }

    public CreateSubscriptionEvent(MemberID memberID, MemberType type) {
        this.memberID = memberID;
        this.type = type;
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

    public MemberID getMemberID() {
        return memberID;
    }

    public MemberType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "CreateSubscriptionEvent{" +
                "memberID=" + memberID +
                ", type=" + type +
                '}';
    }
}
