package com.amazen._old._core.approvers;

import com.amazen._old._core.interfaces.Approver;
import com.amazen._old._marketplace.domain.entities.Membership;
import com.amazen._old._marketplace.domain.interfaces.RegistrationService;
import com.amazen._old._marketplace.domain.builders.services.MembershipRegistrationService;
import com.amazen._old._marketplace.infrastructure.repositories.MembershipInMemoryRepository;
import com.amazen._old._multipay.domain.enums.TransactionStatus;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MembershipRegistryApprover extends Approver {
    private static final Logger LOGGER = Logger.getLogger(MembershipRegistryApprover.class.getName());


    @Override
    public void approve(MembershipProcessPOJO membershipProcessPOJO) {
        if(Objects.nonNull(membershipProcessPOJO) && Objects.nonNull(membershipProcessPOJO.getAccount()) && Objects.nonNull(membershipProcessPOJO.getTransactionCallback())){
            if (membershipProcessPOJO.getTransactionCallback().getStatus().equals(TransactionStatus.FAILED)) {
                LOGGER.log(Level.INFO, "Transaction status : " + TransactionStatus.FAILED);
                LOGGER.log(Level.INFO, "Not enough provision on the bank account.");
            }

            if (membershipProcessPOJO.getTransactionCallback().getStatus().equals(TransactionStatus.ERROR)) {
                LOGGER.log(Level.INFO, "Transaction status : " + TransactionStatus.ERROR);
                LOGGER.log(Level.INFO, "Due to technical issue we aren't able to proceed your demand.");
            }

            if (membershipProcessPOJO.getTransactionCallback().getStatus().equals(TransactionStatus.SUCCESS)) {
                LOGGER.log(Level.INFO, "Transaction status : " + TransactionStatus.SUCCESS);
                RegistrationService<Membership> membershipRegistrationService = new MembershipRegistrationService(MembershipInMemoryRepository.INSTANCE);
                var membership = new Membership(membershipProcessPOJO.getAccount().getId(), membershipProcessPOJO.getTransactionCallback().getId());
                membershipRegistrationService.save(membership);
                LOGGER.log(Level.INFO, "Your membership is now active : " + membership.getId());
            }
        }
    }
}
