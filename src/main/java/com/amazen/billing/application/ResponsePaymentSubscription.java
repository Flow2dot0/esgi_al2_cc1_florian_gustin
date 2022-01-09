package com.amazen.billing.application;

import com.amazen.kernel.*;
import com.amazen.billing.domain.Amount;
import com.amazen.billing.domain.Bank;
import com.amazen.billing.domain.Status;
import com.amazen.billing.domain.TransactionID;

import java.time.LocalDate;

public class ResponsePaymentSubscription implements Command{
    private TransactionID transactionID;
    private Amount amount;
    private LocalDate date;
    private Status status;
    private Bank bank;

    public ResponsePaymentSubscription(TransactionID transactionID, Amount amount, LocalDate date, Status status, Bank bank) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.bank = bank;
    }
}