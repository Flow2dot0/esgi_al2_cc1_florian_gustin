package com.amazen.membership.domain;

import com.amazen.membership.application.CreateContractorEvent;
import com.amazen.membership.infrastructure.ContractorInMemoryRepository;

import java.util.*;

public class ContractorService {

    private final ContractorInMemoryRepository repository;

    public ContractorService(ContractorInMemoryRepository repository) {
        this.repository = repository;
    }

    public void createContractor(CreateContractorEvent event){
        repository.save(Contractor.create(event.getId(), event));
    }
}
