package com.amazen;

import com.amazen.billing.application.BillingManager;
import com.amazen.billing.application.CreateSubscriptionCommandHandler;
import com.amazen.billing.exposition.SubscriptionController;
import com.amazen.billing.exposition.SubscriptionRequest;
import com.amazen.billing.exposition.SubscriptionResponse;
import com.amazen.event_backbone.application.BackBoneCommandBus;
import com.amazen.event_backbone.infrastructure.DefaultEventDispatcher;
import com.amazen.kernel.CommandBus;
import com.amazen.kernel.MemberID;
import com.amazen.membership.application.CreateMember;
import com.amazen.membership.application.CreateMembershipCommandHandler;
import com.amazen.membership.application.MembershipManager;
import com.amazen.membership.exposition.MembershipController;
import com.amazen.membership.exposition.MembershipRequest;
import com.amazen.membership.exposition.MembershipResponse;
import com.amazen.membership.exposition.MembershipsResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@SpringBootApplication
public class App {
//    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
//
//
//    public static Account buildTradesman(){
//        try {
//            var account = new AccountBuilder()
//                    .withEmail("billgates@gmail.com")
//                    .withPassword("1234567")
//                    .withFirstname("Bill")
//                    .withLastname("Gates")
//                    .withAddress("1 rue de la fenêtre")
//                    .withZipcode(75001)
//                    .withCity("Paris")
//                    .withCountry("France")
//                    .withCompany("MICROSOFT")
//                    .withSiret("E1234")
//                    .withAccountType(AccountType.TRADESMAN)
//                    .build();
//            return account;
//        } catch (Exception e) {
//            LOGGER.log(Level.INFO, e.getMessage());
//            return null;
//        }
//    }
//
//    public static Account buildContractor(){
//        try {
//            var account = new AccountBuilder()
//                    .withEmail("steevejobs@gmail.com")
//                    .withPassword("1234567")
//                    .withFirstname("Steve")
//                    .withLastname("Jobs")
//                    .withAddress("1 rue de la fenêtre")
//                    .withZipcode(75001)
//                    .withCity("Paris")
//                    .withCountry("France")
//                    .withCompany("APPLE")
//                    .withSiret("E1235")
//                    .withAccountType(AccountType.CONTRACTOR)
//                    .build();
//            return account;
//        } catch (Exception e) {
//            LOGGER.log(Level.INFO, e.getMessage());
//            return null;
//        }
//    }
//
//    private static Approver createChain(){
//        AccountRegistryApprover accountRegistryApprover = new AccountRegistryApprover();
//        MultiPayRegistryApprover multiPayRegistryApprover = new MultiPayRegistryApprover();
//        MembershipRegistryApprover membershipRegistryApprover = new MembershipRegistryApprover();
//        accountRegistryApprover.setNextApprover(multiPayRegistryApprover);
//        multiPayRegistryApprover.setNextApprover(membershipRegistryApprover);
//        return accountRegistryApprover;
//    }


    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
//        final DynamicSchedulingConfig schedulingConfig = new DynamicSchedulingConfig(applicationContext);
//        schedulingConfig.scheduleTaskUsingCronExpression();

        // Create Member
        // Create Contractor
        // Create Subscription
//        CreateMembershipCommandHandler membershipCommandHandler = applicationContext.getBean(CreateMembershipCommandHandler.class);
//        MembershipManager membershipManager = applicationContext.getBean(MembershipManager.class);
//        MembershipRequest membershipRequest = new MembershipRequest();
//        membershipRequest.email = "tradesman@trade.me";
//        membershipRequest.password = "12345678";
//        membershipRequest.memberType = "tradesman";
//        membershipRequest.address = "1 rue du tradesman";
//        membershipRequest.city = " Paris";
//        membershipRequest.firstname = "Jean";
//        membershipRequest.lastname = "Trade";
//        membershipRequest.skills = List.of("mason");
//        MemberID memberID = membershipManager.createMember(membershipRequest);

        // Create Member
        // Create Tradesman
        // Create Subscription
        CreateMembershipCommandHandler membershipCommandHandler = applicationContext.getBean(CreateMembershipCommandHandler.class);
        MembershipManager membershipManager = applicationContext.getBean(MembershipManager.class);
        MembershipRequest membershipRequest = new MembershipRequest();
        membershipRequest.email = "tradesman@trade.me";
        membershipRequest.password = "12345678";
        membershipRequest.memberType = "tradesman";
        membershipRequest.address = "1 rue du tradesman";
        membershipRequest.city = "Paris";
        membershipRequest.firstname = "Jean";
        membershipRequest.lastname = "Trade";
        membershipRequest.skills = List.of("mason");
        MembershipController membershipController = applicationContext.getBean(MembershipController.class);
        ResponseEntity<MembershipResponse> tradesmanResponse = membershipController.add(membershipRequest);
        MembershipResponse tradesmanResponseBody = tradesmanResponse.getBody();
        CreateSubscriptionCommandHandler createSubscriptionCommandHandler = applicationContext.getBean(CreateSubscriptionCommandHandler.class);
        BillingManager billingManager = applicationContext.getBean(BillingManager.class);

        SubscriptionController subscriptionController = applicationContext.getBean(SubscriptionController.class);
        assert tradesmanResponseBody != null;
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest(tradesmanResponseBody.id, tradesmanResponseBody.memberType);
        ResponseEntity<SubscriptionResponse> subscriptionResponse = subscriptionController.add(subscriptionRequest);
        SubscriptionResponse subscriptionResponseBody = subscriptionResponse.getBody();
//        MemberID memberID = membershipManager.createMember(membershipRequest);





        // Renew Subscriptions



//        MembershipProcessPOJO membershipProcessPOJO1 = new MembershipProcessPOJO();
//        membershipProcessPOJO1.setAccount(buildTradesman());
//        Approver approver = createChain();
//        approver.approve(membershipProcessPOJO1);
//
//
//        MembershipProcessPOJO membershipProcessPOJO2 = new MembershipProcessPOJO();
//        membershipProcessPOJO2.setAccount(buildContractor());
//        approver = createChain();
//        approver.approve(membershipProcessPOJO2);
    }
}
