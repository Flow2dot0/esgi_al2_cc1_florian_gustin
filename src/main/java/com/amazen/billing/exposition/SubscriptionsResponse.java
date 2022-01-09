package com.amazen.billing.exposition;

import java.util.*;

public class SubscriptionsResponse {
    public final List<SubscriptionResponse> subscriptions;

    public SubscriptionsResponse(List<SubscriptionResponse> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
