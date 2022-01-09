package com.amazen;

import com.amazen.billing.application.BillingManager;
import com.amazen.billing.domain.Subscription;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collection;

@EnableScheduling
@Configuration
public class DynamicSchedulingConfig {

    private final ConfigurableApplicationContext applicationContext;

    public DynamicSchedulingConfig(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Scheduled(fixedDelay = 8000, initialDelay = 8000) // stub at 8s but every month is fine
    public void scheduleTaskUsingCronExpression() {
        final BillingManager billingManager = applicationContext.getBean(BillingManager.class);
        Collection<Subscription> subscriptions = billingManager.subscriptionRenewal();
    }
}
