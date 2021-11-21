package com.amazen.core.approvers;

import com.amazen.core.TransactionObserver;
import com.amazen.core.interfaces.Approver;
import com.amazen.multipay.domain.MultiPayManager;
import com.amazen.multipay.domain.entities.Transaction;
import com.amazen.multipay.domain.services.TransactionRegistrationService;
import com.amazen.multipay.infrastructure.repository.TransactionInMemoryRepository;

import java.util.Objects;

public class MultiPayRegistryApprover extends Approver {
    @Override
    public void approve(MembershipProcessPOJO membershipProcessPOJO) {
        if(Objects.nonNull(membershipProcessPOJO) && Objects.nonNull(membershipProcessPOJO.getAccount())){
            var multiPayTransactionRegistrationService = new TransactionRegistrationService(new TransactionInMemoryRepository());
            var multiPay = new MultiPayManager(multiPayTransactionRegistrationService);
            var transactionObserver = new TransactionObserver(multiPay);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Transaction callback = transactionObserver.getTransactionCallback();
            if(Objects.nonNull(callback)){
                membershipProcessPOJO.setTransactionCallback(callback);
                this.nextApprover.approve(membershipProcessPOJO);
            }
        }
    }
}
