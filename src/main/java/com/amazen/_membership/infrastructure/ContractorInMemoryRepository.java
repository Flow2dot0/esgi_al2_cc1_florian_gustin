package com.amazen._membership.infrastructure;

import com.amazen._kernel.annotations.Repository;
import com.amazen._kernel.engines.InMemoryRepositoryEngine;
import com.amazen._membership.domain.Contractor;
import com.amazen._membership.domain.ContractorId;

import java.util.Collection;
import java.util.Objects;

@Repository
public class ContractorInMemoryRepository extends InMemoryRepositoryEngine<ContractorId, Contractor> {

    @Override
    public Collection<Contractor> findAll() {
        return data.values();
    }

    @Override
    public Contractor save(Contractor contractor) {
        contractor.setId(Objects.nonNull(contractor.getId()) ? contractor.getId() : nextId());
        data.put(contractor.getId(), contractor);
        return data.get(contractor.getId());
    }

    @Override
    public void delete(ContractorId contractorId) {
        data.remove(contractorId);
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
