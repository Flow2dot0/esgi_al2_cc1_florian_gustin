package com.amazen.subscription.domain;



import com.amazen.kernel.DomainEvent;
import com.amazen.kernel.Entity;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.RecordEvent;
import com.amazen.membership.application.CreateMemberEvent;
import com.amazen.subscription.application.CreateSubscriptionEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Subscription implements Entity<MemberID>, RecordEvent {
    private final MemberID id;
    private final List<DomainEvent> recordedEvents;

    private TransactionID transactionID;
    private Amount amount;
    private LocalDate date;
    private Status status;

    private Bank bank;

    private Subscription(MemberID id, List<DomainEvent> recordedEvents) {
        this.id = id;
        this.recordedEvents = recordedEvents;
    }

    public static Subscription of(MemberID id, List<DomainEvent> recordedEvents){
        final Subscription subscription = new Subscription(id, new ArrayList<>());
        subscription.hydrate(recordedEvents);
        return subscription;
    }

//    public static Subscription create(MemberID id, DomainEvent initialEvent){
//        final Subscription subscription = new Subscription(id, new ArrayList<>());
//        subscription.recordedEvents().add(initialEvent);
//        subscription.hydrate(List.of(initialEvent));
//        return subscription;
//    }

    public static Subscription create(MemberID id){
        return new Subscription(id, new ArrayList<>());
    }

    public Subscription update(DomainEvent event){
        recordedEvents.add(event);
        hydrate(recordedEvents);
        return this;
    }

    private void hydrate(List<DomainEvent> events){
        events.forEach(event -> {
            if(event instanceof CreateSubscriptionEvent){
                final CreateSubscriptionEvent ev = (CreateSubscriptionEvent) event;
                applyEvent(ev);
            }else if(event instanceof PaymentSubscriptionEvent){
                final PaymentSubscriptionEvent ev = (PaymentSubscriptionEvent) event;
                applyEvent(ev);
            }
        });
    }

    public TransactionID getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(TransactionID transactionID) {
        this.transactionID = transactionID;
    }

    private void applyEvent(CreateSubscriptionEvent createSubscriptionEvent){
//        this.transactionID = createSubscriptionEvent.getTransactionID() != null ? createSubscriptionEvent.getTransactionID() : null;
        this.amount = createSubscriptionEvent.getAmount();
        this.date = createSubscriptionEvent.getDate();
        this.status = createSubscriptionEvent.getStatus();
        this.bank = createSubscriptionEvent.getBank();
    }

    private void applyEvent(PaymentSubscriptionEvent paymentSubscriptionEvent){
        this.transactionID = paymentSubscriptionEvent.getTransactionID();
        this.amount = paymentSubscriptionEvent.getAmount();
        this.date = paymentSubscriptionEvent.getDate();
        this.status = paymentSubscriptionEvent.getStatus();
        this.bank = paymentSubscriptionEvent.getBank();
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public MemberID getId() {
        return id;
    }

    @Override
    public void setId(MemberID memberID) {
        throw new UnsupportedOperationException();
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

    @Override
    public List<DomainEvent> recordedEvents() {
        return recordedEvents;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
