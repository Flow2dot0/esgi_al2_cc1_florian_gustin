package com.amazen;

import com.amazen._core.approvers.AccountRegistryApprover;
import com.amazen._core.approvers.MembershipProcessPOJO;
import com.amazen._core.approvers.MembershipRegistryApprover;
import com.amazen._core.approvers.MultiPayRegistryApprover;
import com.amazen._core.interfaces.Approver;
import com.amazen._marketplace.domain.builders.AccountBuilder;
import com.amazen._marketplace.domain.entities.Account;
import com.amazen._marketplace.domain.entities.AccountType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
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
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);




        MembershipProcessPOJO membershipProcessPOJO1 = new MembershipProcessPOJO();
        membershipProcessPOJO1.setAccount(buildTradesman());
        Approver approver = createChain();
        approver.approve(membershipProcessPOJO1);


        MembershipProcessPOJO membershipProcessPOJO2 = new MembershipProcessPOJO();
        membershipProcessPOJO2.setAccount(buildContractor());
        approver = createChain();
        approver.approve(membershipProcessPOJO2);
    }
}
