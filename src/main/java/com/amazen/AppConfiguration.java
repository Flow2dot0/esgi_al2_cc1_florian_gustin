package com.amazen;

import com.amazen.billing.application.*;
import com.amazen.billing.domain.PaymentService;
import com.amazen.billing.domain.SubscriptionService;
import com.amazen.billing.infrastructure.SubscriptionInMemoryRepository;
import com.amazen.event_backbone.application.BackBoneCommandBus;
import com.amazen.event_backbone.application.BackBoneEventHubManager;
import com.amazen.event_backbone.application.BackBoneEventListener;
import com.amazen.event_backbone.application.BackBoneQueryBus;
import com.amazen.event_backbone.domain.BackBoneEventLogService;
import com.amazen.event_backbone.infrastructure.DefaultEventDispatcher;
import com.amazen.event_backbone.infrastructure.EventLogInMemoryRepository;
import com.amazen.kernel.*;
import com.amazen.membership.application.*;
import com.amazen.membership.domain.ContractorService;
import com.amazen.membership.domain.MemberService;
import com.amazen.membership.domain.TradesmanService;
import com.amazen.membership.infrastructure.ContractorInMemoryRepository;
import com.amazen.membership.infrastructure.MemberInMemoryRepository;
import com.amazen.membership.infrastructure.TradesmanInMemoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Configuration
public class AppConfiguration {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberInMemoryRepository());
    }

    @Bean
    public TradesmanService tradesmanService(){
        return new TradesmanService(tradesmanInMemoryRepository());
    }

    @Bean
    public ContractorService contractorService(){
        return new ContractorService(contractorInMemoryRepository());
    }

    @Bean
    public MembershipManager membershipManager(){
        return new MembershipManager(memberService(), tradesmanService(), contractorService());
    }

    @Bean
    public ContractorInMemoryRepository contractorInMemoryRepository(){
        return new ContractorInMemoryRepository();
    }

    @Bean
    public TradesmanInMemoryRepository tradesmanInMemoryRepository(){
        return new TradesmanInMemoryRepository();
    }

    @Bean
    public MemberInMemoryRepository memberInMemoryRepository() {
        return new MemberInMemoryRepository();
    }

    @Bean
    public CreateMembershipCommandHandler createMembershipCommandHandler() {
        return new CreateMembershipCommandHandler(membershipManager(), eventEventDispatcher());
    }

    @Bean
    public RenewSubscriptionsCommandHandler renewSubscriptionsCommandHandler() {
        return new RenewSubscriptionsCommandHandler(eventEventDispatcher());
    }

    @Bean
    public BackBoneEventHubManager backBoneEventHubManager(){
        return new BackBoneEventHubManager(eventLogService());
    }

    @Bean
    public CreateSubscriptionCommandHandler createSubscriptionCommandHandler(){
        return new CreateSubscriptionCommandHandler(eventEventDispatcher());
    }

    @Bean
    public Logger logger(){
        return Logger.getLogger(AppConfiguration.class.getName());
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher(){
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateMemberEvent.class, List.of(new CreateMemberEventListener(membershipManager(), logger(), backBoneEventHubManager())));
        listenerMap.put(CreateTradesmanEvent.class, List.of(new CreateTradesmanEventListener(membershipManager(), logger(), backBoneEventHubManager())));
        listenerMap.put(CreateContractorEvent.class, List.of(new CreateContractorEventListener(membershipManager(), logger(), backBoneEventHubManager())));
        listenerMap.put(CreateSubscriptionEvent.class, List.of(new CreateSubscriptionEventListener(billingManager(), logger(), backBoneEventHubManager())));
        listenerMap.put(RenewSubscriptionsEvent.class, List.of(new RenewSubscriptionsEventListener(billingManager(), logger(), backBoneEventHubManager())));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public SubscriptionService subscriptionService(){
        return new SubscriptionService(subscriptionInMemoryRepository());
    }

    @Bean
    public SubscriptionInMemoryRepository subscriptionInMemoryRepository(){
        return new SubscriptionInMemoryRepository();
    }

    @Bean
    public BillingManager billingManager(){
        return new BillingManager(subscriptionService(), paymentService(), logger());
    }

    @Bean
    public PaymentService paymentService(){
        return new PaymentService(logger());
    }

    @Bean
    public BackBoneEventListener backBoneEventListener(){
        return new BackBoneEventListener(logger(), backBoneEventHubManager());
    }

    @Bean
    public CommandBus commandBus(){
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateMember.class, createMembershipCommandHandler());
        commandHandlerMap.put(CreateSubscription.class, createSubscriptionCommandHandler());
        commandHandlerMap.put(RenewSubscriptions.class, renewSubscriptionsCommandHandler());
        return BackBoneCommandBus.create(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveMemberships.class, new RetrieveMembershipsQueryHandler());
        return BackBoneQueryBus.of(queryHandlerMap);
    }

    @Bean
    public EventLogInMemoryRepository eventLogInMemoryRepository() {
        return new EventLogInMemoryRepository();
    }

    @Bean
    public BackBoneEventLogService eventLogService() {
        return new BackBoneEventLogService(eventLogInMemoryRepository(), logger());
    }

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }


}
