package com.amazen.event_backbone.infrastructure;

import com.amazen.event_backbone.domain.EventLog;
import com.amazen.event_backbone.domain.EventLogID;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventLogInMemoryRepository{

    private final Map<EventLogID, EventLog> data;

    public EventLogInMemoryRepository() {
        data = new ConcurrentHashMap<>();
    }

    public void add(EventLog event){
        data.put(new EventLogID(), event);
    }
}
