package com.amazen.membership.application;

import com.amazen.kernel.EventListener;
import com.amazen.membership.infrastructure.ContractorInMemoryRepository;
import com.amazen.membership.infrastructure.TradesmanInMemoryRepository;

import java.util.Objects;

public class CreateMemberEventListener implements EventListener<CreateMemberEvent> {

    @Override
    public void listen(CreateMemberEvent event) {
        if(Objects.nonNull(event.getMemberID())){

        }
    }
}
