package com.amazen.core.approvers;

import com.amazen.core.interfaces.Approver;
import com.amazen.marketplace.domain.entities.Account;
import com.amazen.marketplace.domain.interfaces.RegistrationService;
import com.amazen.marketplace.domain.services.AccountRegistrationService;
import com.amazen.marketplace.infrastructure.repositories.AccountInMemoryRepository;

import java.util.Objects;

public class AccountRegistryApprover extends Approver {

    public AccountRegistryApprover() {
    }

    @Override
    public void approve(MembershipProcessPOJO membershipProcessPOJO) {
        if(Objects.nonNull(membershipProcessPOJO) && Objects.nonNull(membershipProcessPOJO.getAccount())){
            RegistrationService<Account> accountRegistrationService = new AccountRegistrationService(AccountInMemoryRepository.INSTANCE);
            membershipProcessPOJO.setAccount(accountRegistrationService.save(membershipProcessPOJO.getAccount()));
            if(Objects.nonNull(membershipProcessPOJO.getAccount()))
                this.nextApprover.approve(membershipProcessPOJO);
        }
    }
}
