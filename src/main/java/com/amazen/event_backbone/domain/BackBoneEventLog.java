package com.amazen.event_backbone.domain;


import com.amazen.kernel.DomainEvent;

public class BackBoneEventLog implements DomainEvent {
    private final String payload;

    public BackBoneEventLog(String payload) {
        this.payload = payload;
    }
}
