package com.amazen.event_backbone.domain;


import com.amazen.kernel.DomainEvent;

public class EventLog implements DomainEvent {
    private final String payload;

    public EventLog(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "EventLog{" +
                "payload='" + payload + '\'' +
                '}';
    }
}
