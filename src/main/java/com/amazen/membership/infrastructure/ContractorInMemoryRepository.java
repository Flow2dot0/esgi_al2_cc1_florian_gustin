package com.amazen.membership.infrastructure;

import com.amazen.kernel.annotations.Repository;
import com.amazen.kernel.inmemory.InMemoryRepositoryEngine;
import com.amazen.membership.domain.Contractor;
import com.amazen.membership.domain.ContractorId;

import java.util.Objects;

@Repository
public class ContractorInMemoryRepository extends InMemoryRepositoryEngine<ContractorId, Contractor> {
    private static final InMemoryRepositoryEngine<ContractorId, Contractor> INSTANCE = new ContractorInMemoryRepository();

    @Override
    public Contractor save(Contractor contractor) {
        contractor.setId(Objects.nonNull(contractor.getId()) ? contractor.getId() : nextId());
        data.put(contractor.getId(), contractor);
        return data.get(contractor.getId());
    }

    @Override
    public void delete(Contractor contractor) {
        data.remove(contractor.getId());
    }

    @Override
    public InMemoryRepositoryEngine<ContractorId, Contractor> getInstance() {
        return INSTANCE;
    }

    @Override
    protected ContractorId nextId() {
        return ContractorId.of(count.incrementAndGet());
    }

    @Override
    public Contractor findById(ContractorId contractorId) {
        return data.get(contractorId);
    }
}
