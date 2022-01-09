package com.amazen.subscription.exposition;

import java.util.*;

public class SubscriptionsResponse {
    public final List<SubscriptionsResponse> subscriptions;

    public SubscriptionsResponse(List<SubscriptionsResponse> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
