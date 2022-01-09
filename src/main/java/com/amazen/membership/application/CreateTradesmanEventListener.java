package com.amazen.membership.application;

import com.amazen.kernel.EventListener;
import com.amazen.membership.domain.MembershipManager;

import java.util.Objects;

@com.amazen.kernel.annotations.EventListener
public class CreateTradesmanEventListener implements EventListener<CreateTradesmanEvent> {
    private final MembershipManager manager;

    public CreateTradesmanEventListener(MembershipManager manager) {
        this.manager = manager;
    }

    @Override
    public void listen(CreateTradesmanEvent event) {
        if(Objects.nonNull(event.id)){
            manager.getTradesmanService().createTradesman(event);
        }
    }
}
