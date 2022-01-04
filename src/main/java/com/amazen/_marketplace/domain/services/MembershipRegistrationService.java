package com.amazen._marketplace.domain.services;

import com.amazen._core.entities.UniqueId;
import com.amazen._marketplace.domain.entities.Membership;
import com.amazen._marketplace.domain.interfaces.InMemoryRepositoryEngine;
import com.amazen._marketplace.domain.interfaces.RegistrationService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MembershipRegistrationService implements RegistrationService<Membership> {
    private static final Logger LOGGER = Logger.getLogger(MembershipRegistrationService.class.getName());

    private InMemoryRepositoryEngine<UniqueId, Membership> membershipRepository;

    public MembershipRegistrationService(InMemoryRepositoryEngine<UniqueId, Membership> membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public Membership findById(int id) {
        try{
            Membership membership = membershipRepository.findById(UniqueId.withId(id));
            LOGGER.log(Level.INFO, "Membership ID "+id+" found in database");
            return membership;
        }catch (Exception e){
            LOGGER.log(Level.INFO, e.getMessage());
            return null;
        }
    }

    @Override
    public Membership save(Membership membership) {
        try{
            membership = membershipRepository.save(membership);
            LOGGER.log(Level.INFO, "Membership ID "+membership.getId()+" saved in database");
            return membership;
        }catch (Exception e){
            LOGGER.log(Level.INFO, e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Membership membership) {
        try{
            membershipRepository.delete(membership);
            LOGGER.log(Level.INFO, "Account ID "+membership.getId()+" deleted from database");
        }catch (Exception e){
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }
}
