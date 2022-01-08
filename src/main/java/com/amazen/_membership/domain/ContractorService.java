package com.amazen._membership.domain;

import com.amazen._kernel.abstracts.Service;
import com.amazen._membership.infrastructure.ContractorInMemoryRepository;

import java.util.Objects;
import java.util.logging.Logger;

final class ContractorService implements Service {

    private final ContractorInMemoryRepository repository;
    private final Logger logger;

    private ContractorService(ContractorInMemoryRepository repository, Logger logger) {
        this.repository = Objects.requireNonNull(repository);
        this.logger = Objects.requireNonNull(logger);
    }

    static ContractorService with(ContractorInMemoryRepository repository, Logger logger){
        return new ContractorService(repository, logger);
    }

    public Contractor findById(int id) {
        return repository.findById(ContractorId.of(id));
    }

    public Contractor save(Contractor contractor) {
        repository.save(contractor);
        return repository.save(contractor);
    }

    public void delete(ContractorId contractorId) {
        repository.delete(contractorId);
    }
}
