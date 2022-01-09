package com.amazen;

import com.amazen.billing.application.BillingManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//@EnableScheduling
//@Configuration
public class DynamicSchedulingConfig {

    private final ConfigurableApplicationContext applicationContext;

    public DynamicSchedulingConfig(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleTaskUsingCronExpression() {
        final BillingManager billingManager = applicationContext.getBean(BillingManager.class);
        billingManager.subscriptionRenewal();
    }
}
