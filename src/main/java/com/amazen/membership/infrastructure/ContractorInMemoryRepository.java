package com.amazen.membership.infrastructure;


import com.amazen.kernel.MemberID;
import com.amazen.kernel.annotations.Repository;
import com.amazen.kernel.engines.InMemoryRepositoryEngine;
import com.amazen.membership.domain.cc2.Contractor;

import java.util.Collection;

@Repository
public class ContractorInMemoryRepository extends InMemoryRepositoryEngine<MemberID, Contractor> {

    @Override
    public Contractor save(Contractor contractor) {
        data.put(contractor.getId(), contractor);
        return data.get(contractor.getId());
    }

    @Override
    public MemberID nextId() {
        throw new UnsupportedOperationException();
    }
}
