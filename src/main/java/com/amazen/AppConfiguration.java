package com.amazen;

import com.amazen.event_backbone.application.BackBoneCommandBus;
import com.amazen.event_backbone.application.BackBoneQueryBus;
import com.amazen.event_backbone.domain.EventLogService;
import com.amazen.event_backbone.infrastructure.DefaultEventDispatcher;
import com.amazen.event_backbone.infrastructure.EventLogInMemoryRepository;
import com.amazen.kernel.*;
import com.amazen.kernel.EventListener;
import com.amazen.membership.application.*;
import com.amazen.membership.domain.ContractorService;
import com.amazen.membership.domain.MemberService;
import com.amazen.membership.domain.MembershipManager;
import com.amazen.membership.domain.TradesmanService;
import com.amazen.membership.infrastructure.ContractorInMemoryRepository;
import com.amazen.membership.infrastructure.MemberInMemoryRepository;
import com.amazen.membership.infrastructure.TradesmanInMemoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
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
    public CreateMembershipCommandHandler createMemberCommandHandler() {
        return new CreateMembershipCommandHandler(membershipManager(), eventEventDispatcher());
    }

//    @Bean
//    public MockSecureTransactionRepository mockSecureTransactionRepository(){
//        return new MockSecureTransactionRepository();
//    }

//    @Bean
//    public SecureTransactionService secureTransactionService() {
//        return new SecureTransactionService(mockSecureTransactionRepository());
//    }

    @Bean
    public Logger logger(){
        return Logger.getLogger(AppConfiguration.class.getName());
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher(){
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateMemberEvent.class, List.of(new CreateMemberEventListener(membershipManager(), logger(), eventLogService())));
        listenerMap.put(CreateTradesmanEvent.class, List.of(new CreateTradesmanEventListener(membershipManager(), logger(), eventLogService())));
        listenerMap.put(CreateContractorEvent.class, List.of(new CreateContractorEventListener(membershipManager(), logger(), eventLogService())));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CommandBus commandBus(){
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateMember.class, createMemberCommandHandler());
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
    public EventLogService eventLogService() {
        return new EventLogService(eventLogInMemoryRepository(), logger(), mapper());
    }

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }


}
