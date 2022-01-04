package com.amazen._marketplace.domain.services;

import com.amazen._core.entities.UniqueId;
import com.amazen._core.annotations.Service;
import com.amazen._marketplace.domain.entities.Account;
import com.amazen._marketplace.domain.interfaces.InMemoryRepositoryEngine;
import com.amazen._marketplace.domain.interfaces.RegistrationService;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AccountRegistrationService implements RegistrationService<Account> {
    private static final Logger LOGGER = Logger.getLogger(AccountRegistrationService.class.getName());

    private final InMemoryRepositoryEngine<UniqueId, Account> accountRepository;

    public AccountRegistrationService(InMemoryRepositoryEngine<UniqueId, Account> accountRepository) {
        this.accountRepository = Objects.requireNonNull(accountRepository);
    }

    @Override
    public Account findById(int id){
        try{
            Account account = accountRepository.findById(UniqueId.withId(id));
            LOGGER.log(Level.INFO, "Account ID "+id+" found in database");
            return account;
        }catch (Exception e){
            LOGGER.log(Level.INFO, e.getMessage());
            return null;
        }
    }

    @Override
    public Account save(Account account){
        try{
            Account savedAccount = accountRepository.save(account);
            LOGGER.log(Level.INFO, "Account ID "+account.getId()+" saved in database");
            return savedAccount;
        }catch (Exception e){
            LOGGER.log(Level.INFO, e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Account account) {
        try{
            accountRepository.delete(account);
            LOGGER.log(Level.INFO, "Account ID "+account.getId()+" deleted from database");
        }catch (Exception e){
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }
}
