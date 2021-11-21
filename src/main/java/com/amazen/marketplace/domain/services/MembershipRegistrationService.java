package com.amazen.marketplace.domain.services;

import com.amazen.core.entities.UniqueId;
import com.amazen.marketplace.domain.entities.Membership;
import com.amazen.marketplace.domain.interfaces.InMemoryRepositoryEngine;
import com.amazen.marketplace.domain.interfaces.RegistrationService;

public class MembershipRegistrationService implements RegistrationService<Membership> {

    private InMemoryRepositoryEngine<UniqueId, Membership> membershipRepository;

    public MembershipRegistrationService(InMemoryRepositoryEngine<UniqueId, Membership> membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public Membership findById(int id) {
        return null;
    }

    @Override
    public Membership save(Membership membership) {
        return null;
    }

    @Override
    public void delete(Membership membership) {

    }
}
