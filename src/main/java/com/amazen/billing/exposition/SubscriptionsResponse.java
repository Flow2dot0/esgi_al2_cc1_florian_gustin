package com.amazen.billing.exposition;

import java.util.*;

public class SubscriptionsResponse {
    public final List<SubscriptionsResponse> subscriptions;

    public SubscriptionsResponse(List<SubscriptionsResponse> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
