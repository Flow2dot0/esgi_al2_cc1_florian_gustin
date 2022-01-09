package com.amazen.billing.application;

import com.amazen.kernel.CommandHandler;
import com.amazen.kernel.Event;
import com.amazen.kernel.EventDispatcher;

public class RenewSubscriptionsCommandHandler implements CommandHandler<RenewSubscriptions, Void> {

    private final EventDispatcher<Event> eventEventDispatcher;

    public RenewSubscriptionsCommandHandler(EventDispatcher<Event> eventEventDispatcher) {
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(RenewSubscriptions command) {
        eventEventDispatcher.dispatch(new RenewSubscriptionsEvent());
        return null;
    }
}
