package com.amazen._core.approvers;

import com.amazen._marketplace.domain.entities.Account;
import com.amazen._multipay.domain.entities.Transaction;

public class MembershipProcessPOJO {
    private Account account;
    private Transaction transactionCallback;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public Transaction getTransactionCallback() {
        return transactionCallback;
    }

    public void setTransactionCallback(Transaction transactionCallback) {
        this.transactionCallback = transactionCallback;
    }
}
