package com.amazen._old._multipay.domain.services;

import com.amazen._old._core.entities.UniqueId;
import com.amazen._old._core.annotations.Service;
import com.amazen._old._marketplace.domain.interfaces.InMemoryRepositoryEngine;
import com.amazen._old._marketplace.domain.interfaces.RegistrationService;
import com.amazen._old._multipay.domain.entities.Transaction;

import javax.naming.NoPermissionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TransactionRegistrationService implements RegistrationService<Transaction> {
    private static final Logger LOGGER = Logger.getLogger(TransactionRegistrationService.class.getName());

    private final InMemoryRepositoryEngine<UniqueId, Transaction> transactionRepository;

    public TransactionRegistrationService(InMemoryRepositoryEngine<UniqueId, Transaction> transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction findById(int id){
        try{
            Transaction transaction = transactionRepository.findById(UniqueId.withId(id));
            LOGGER.log(Level.INFO, "Transaction ID "+id+" found in database");
            return transaction;
        }catch (Exception e){
            LOGGER.log(Level.INFO, e.getMessage());
            return null;
        }
    }

    @Override
    public Transaction save(Transaction transaction){
        try{
            Transaction savedTransaction = transactionRepository.save(transaction);
            LOGGER.log(Level.INFO, "Transaction ID "+savedTransaction.getId()+" saved in database");
            return savedTransaction;
        }catch (Exception e){
            LOGGER.log(Level.INFO, e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Transaction transaction) throws NoPermissionException {
        throw new NoPermissionException();
    }
}
