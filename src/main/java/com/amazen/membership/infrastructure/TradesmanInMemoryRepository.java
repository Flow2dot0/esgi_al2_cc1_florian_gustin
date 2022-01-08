package com.amazen.membership.infrastructure;

import com.amazen.kernel.MemberID;
import com.amazen.kernel.annotations.Repository;
import com.amazen.kernel.engines.InMemoryRepositoryEngine;
import com.amazen.membership.domain.cc2.Tradesman;


@Repository
public class TradesmanInMemoryRepository extends InMemoryRepositoryEngine<MemberID, Tradesman> {

    @Override
    public Tradesman save(Tradesman tradesman) {
        data.put(tradesman.getId(), tradesman);
        return data.get(tradesman.getId());
    }

    @Override
    public MemberID nextId() {
        throw new UnsupportedOperationException();
    }
}
