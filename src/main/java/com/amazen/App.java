package com.amazen;

import com.amazen.core.approvers.AccountRegistryApprover;
import com.amazen.core.approvers.MembershipProcessPOJO;
import com.amazen.core.approvers.MembershipRegistryApprover;
import com.amazen.core.approvers.MultiPayRegistryApprover;
import com.amazen.core.interfaces.Approver;
import com.amazen.marketplace.domain.builders.AccountBuilder;
import com.amazen.marketplace.domain.entities.Account;
import com.amazen.marketplace.domain.entities.AccountType;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());


    public static Account buildTradesman(){
        try {
            var account = new AccountBuilder()
                    .withEmail("billgates@gmail.com")
                    .withPassword("1234567")
                    .withFirstname("Bill")
                    .withLastname("Gates")
                    .withAddress("1 rue de la fenêtre")
                    .withZipcode(75001)
                    .withCity("Paris")
                    .withCountry("France")
                    .withCompany("MICROSOFT")
                    .withSiret("E1234")
                    .withAccountType(AccountType.TRADESMAN)
                    .build();
            return account;
        } catch (Exception e) {
            LOGGER.log(Level.INFO, e.getMessage());
            return null;
        }
    }

    public static Account buildContractor(){
        try {
            var account = new AccountBuilder()
                    .withEmail("steevejobs@gmail.com")
                    .withPassword("1234567")
                    .withFirstname("Steve")
                    .withLastname("Jobs")
                    .withAddress("1 rue de la fenêtre")
                    .withZipcode(75001)
                    .withCity("Paris")
                    .withCountry("France")
                    .withCompany("APPLE")
                    .withSiret("E1235")
                    .withAccountType(AccountType.CONTRACTOR)
                    .build();
            return account;
        } catch (Exception e) {
            LOGGER.log(Level.INFO, e.getMessage());
            return null;
        }
    }

    private static Approver createChain(){
        AccountRegistryApprover accountRegistryApprover = new AccountRegistryApprover();
        MultiPayRegistryApprover multiPayRegistryApprover = new MultiPayRegistryApprover();
        MembershipRegistryApprover membershipRegistryApprover = new MembershipRegistryApprover();
        accountRegistryApprover.setNextApprover(multiPayRegistryApprover);
        multiPayRegistryApprover.setNextApprover(membershipRegistryApprover);
        return accountRegistryApprover;
    }

    public static void main(String[] args) {
        MembershipProcessPOJO membershipProcessPOJO = new MembershipProcessPOJO();
        membershipProcessPOJO.setAccount(buildTradesman());
        Approver approver = createChain();
        approver.approve(membershipProcessPOJO);
    }
}
