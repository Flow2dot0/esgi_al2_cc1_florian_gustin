package com.amazen.billing.application;

import com.amazen.kernel.CommandHandler;
import com.amazen.kernel.Event;
import com.amazen.kernel.EventDispatcher;
import com.amazen.kernel.MemberID;
import com.amazen.membership.domain.MemberType;

public class CreateSubscriptionCommandHandler implements CommandHandler<CreateSubscription, MemberID> {

    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateSubscriptionCommandHandler(EventDispatcher<Event> eventEventDispatcher) {
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public MemberID handle(CreateSubscription command) {
        final MemberID memberID = new MemberID(command.memberID);
        eventEventDispatcher.dispatch(new CreateSubscriptionEvent(memberID, MemberType.valueOf(command.memberType.toUpperCase())));
        return memberID;
    }

}
