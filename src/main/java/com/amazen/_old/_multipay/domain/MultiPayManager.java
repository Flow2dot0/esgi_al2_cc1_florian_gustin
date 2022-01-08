package com.amazen._old._multipay.domain;

import com.amazen._old._core.LocalDate;
import com.amazen._old._marketplace.domain.interfaces.RegistrationService;
import com.amazen._old._multipay.domain.entities.BankInformation;
import com.amazen._old._multipay.domain.entities.Transaction;
import com.amazen._old._multipay.domain.enums.TransactionStatus;
import com.amazen._old._multipay.domain.factories.BankInformationFactory;
import com.amazen._old._multipay.domain.interfaces.Observer;
import com.amazen._old._multipay.domain.interfaces.Subject;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiPayManager implements Subject {
    private static final Logger LOGGER = Logger.getLogger(MultiPayManager.class.getName());

    private Transaction transaction;
    private final RegistrationService<Transaction> transactionRegistrationService;
    private com.amazen._old._multipay.domain.interfaces.Observer observer;

    public MultiPayManager(RegistrationService<Transaction> transactionRegistrationService) {
        this.transactionRegistrationService = Objects.requireNonNull(transactionRegistrationService);
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
        notifyListener();
    }


    public void openTransaction(BankInformation bankInformation) throws InterruptedException {
        if(bankInformation != null){
            Transaction transaction = new Transaction(observer.getClass().getName(), TransactionStatus.PENDING, new LocalDate().now());
            Thread.sleep(500);
            transaction = transaction.copyWith(transaction.getId(), transaction.getSource(), TransactionStatus.SUCCESS, transaction.getCreatedOn(), String.valueOf(new Random().nextInt(11111)), new LocalDate().now());
            setTransaction(transaction);
            transactionRegistrationService.save(transaction);
        }
    }

    public void validateCardDetails() {
        try{
            openTransaction(BankInformationFactory.stubValidBankInformation());
        }catch(Exception e){
            LOGGER.log(Level.INFO, "The card details are non compliant : " +e.getMessage());
        }
    }

    @Override
    public void addObserver(com.amazen._old._multipay.domain.interfaces.Observer o) {
        observer = o;
        // user interact and fill card details
        validateCardDetails();
    }

    @Override
    public void removeObserver(Observer o) {
        observer = null;
    }

    @Override
    public void notifyListener() {
        observer.update(transaction);
    }
}
