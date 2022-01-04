package com.amazen._marketplace.infrastructure.repositories;

import com.amazen._core.entities.UniqueId;
import com.amazen._marketplace.domain.entities.Account;
import com.amazen._core.exceptions.ValueObjectException;
import com.amazen._marketplace.domain.interfaces.InMemoryRepositoryEngine;

public class AccountInMemoryRepository extends InMemoryRepositoryEngine<UniqueId, Account> {
    public static final InMemoryRepositoryEngine<UniqueId, Account> INSTANCE = new AccountInMemoryRepository();


    @Override
    protected UniqueId nextId() throws ValueObjectException {
        return UniqueId.withId(count.incrementAndGet());
    }

    @Override
    public Account findById(UniqueId uniqueId) {
        return data.get(uniqueId);
    }

    @Override
    public Account save(Account account) throws ValueObjectException {
        account.setId(account.getId() != null ? account.getId() : nextId());
        data.put(account.getId(), account);
        return data.get(account.getId());
    }

    @Override
    public void delete(Account account){
        data.remove(account.getId());
    }
}
