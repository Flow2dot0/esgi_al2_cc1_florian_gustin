package com.amazen.membership.application;

import com.amazen.kernel.EventListener;
import com.amazen.membership.domain.MembershipManager;

import java.util.Objects;

@com.amazen.kernel.annotations.EventListener
public class CreateContractorEventListener implements EventListener<CreateContractorEvent> {
    private final MembershipManager manager;

    public CreateContractorEventListener(MembershipManager manager) {
        this.manager = manager;
    }

    @Override
    public void listen(CreateContractorEvent event) {
        if(Objects.nonNull(event.getId())){
            manager.getContractorService().createContractor(event);
        }
    }
}
