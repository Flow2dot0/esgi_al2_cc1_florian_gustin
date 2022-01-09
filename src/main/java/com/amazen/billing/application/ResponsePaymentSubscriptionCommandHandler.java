package com.amazen.billing.application;

import com.amazen.kernel.CommandHandler;
import com.amazen.kernel.Event;
import com.amazen.kernel.EventDispatcher;
import com.amazen.kernel.MemberID;

public class ResponsePaymentSubscriptionCommandHandler implements CommandHandler<ResponsePaymentSubscription, MemberID> {

    private final EventDispatcher<Event> eventEventDispatcher;

    public ResponsePaymentSubscriptionCommandHandler(EventDispatcher<Event> eventEventDispatcher) {
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public MemberID handle(ResponsePaymentSubscription command) {
        return null;
    }
}
