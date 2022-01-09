package com.amazen;

import com.amazen.billing.application.BillingManager;
import com.amazen.billing.application.CreateSubscriptionCommandHandler;
import com.amazen.billing.exposition.SubscriptionController;
import com.amazen.billing.exposition.SubscriptionRequest;
import com.amazen.billing.exposition.SubscriptionResponse;
import com.amazen.membership.application.CreateMembershipCommandHandler;
import com.amazen.membership.application.MembershipManager;
import com.amazen.membership.exposition.MembershipController;
import com.amazen.membership.exposition.MembershipRequest;
import com.amazen.membership.exposition.MembershipResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class App {



    public static void main(String[] args) throws InterruptedException {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
        final Logger logger = applicationContext.getBean(Logger.class);
//        final DynamicSchedulingConfig schedulingConfig = new DynamicSchedulingConfig(applicationContext);
//        schedulingConfig.scheduleTaskUsingCronExpression();


        // Create Member
        // Create Tradesman
        // Create Subscription
        logger.info("CREATION OF A TRADESMAN");
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

        logger.info("CREATION OF A TRADESMAN SUBSCRIPTION");
        SubscriptionController subscriptionController = applicationContext.getBean(SubscriptionController.class);
        assert tradesmanResponseBody != null;
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest(tradesmanResponseBody.id, tradesmanResponseBody.memberType);
        ResponseEntity<SubscriptionResponse> subscriptionResponse = subscriptionController.add(subscriptionRequest);

        Thread.sleep(2000);

        // Create Member
        // Create Contractor
        // Create Subscription
        logger.info("CREATION OF A CONTRACTOR");
        MembershipRequest membershipRequest2 = new MembershipRequest();
        membershipRequest2.email = "contractor@trade.me";
        membershipRequest2.password = "12345678";
        membershipRequest2.memberType = "contractor";
        membershipRequest2.address = "1 rue du contractor";
        membershipRequest2.city = "Paris";
        membershipRequest2.firstname = "Jean";
        membershipRequest2.lastname = "Trade";
        membershipRequest2.companyID = "0AE1222U";
        membershipRequest2.companyName = "D&CO";

        tradesmanResponse = membershipController.add(membershipRequest2);
        tradesmanResponseBody = tradesmanResponse.getBody();

        logger.info("CREATION OF A CONTRACTOR SUBSCRIPTION");
        subscriptionController = applicationContext.getBean(SubscriptionController.class);
        assert tradesmanResponseBody != null;
        subscriptionRequest = new SubscriptionRequest(tradesmanResponseBody.id, tradesmanResponseBody.memberType);
        subscriptionResponse = subscriptionController.add(subscriptionRequest);

        // Renew Subscriptions
        logger.info("RENEW OF POTENTIAL SUBSCRIPTIONS ON DATE");
        subscriptionController.getExpiringSubscriptions();

    }
}
