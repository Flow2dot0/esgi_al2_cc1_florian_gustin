package com.amazen;

import com.amazen._membership.infrastructure.ContractorInMemoryRepository;
import com.amazen._membership.infrastructure.TradesmanInMemoryRepository;
import com.amazen._securepal.domain.SecureTransactionService;
import com.amazen._securepal.infrastructure.MockSecureTransactionRepository;
import com.amazen.event_backbone.application.BackBoneCommandBus;
import com.amazen.event_backbone.application.BackBoneQueryBus;
import com.amazen.event_backbone.domain.EventLogService;
import com.amazen.event_backbone.infrastructure.EventLogInMemoryRepository;
import com.amazen.kernel.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Configuration
public class AppConfiguration {

    @Bean
    public ContractorInMemoryRepository contractorInMemoryRepository(){
        return new ContractorInMemoryRepository();
    }

    @Bean
    public TradesmanInMemoryRepository tradesmanInMemoryRepository(){
        return new TradesmanInMemoryRepository();
    }

    @Bean
    public MockSecureTransactionRepository mockSecureTransactionRepository(){
        return new MockSecureTransactionRepository();
    }

    @Bean
    public SecureTransactionService secureTransactionService() {
        return new SecureTransactionService(mockSecureTransactionRepository());
    }

    @Bean
    public Logger logger(){
        return Logger.getLogger(AppConfiguration.class.getName());
    }

    @Bean
    public CommandBus commandBus(){
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put();
        return BackBoneCommandBus.create(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveUsers.class, new RetrieveUsersHandler(userRepository()));
        return BackBoneQueryBus.of(queryHandlerMap);
    }

    @Bean
    public EventLogInMemoryRepository eventLogInMemoryRepository() {
        return new EventLogInMemoryRepository();
    }

    @Bean
    public EventLogService eventLogService() {
        return EventLogService.of(eventLogInMemoryRepository(), logger());
    }


}
