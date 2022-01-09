package com.amazen.event_backbone.infrastructure;

import com.amazen.event_backbone.domain.BackBoneEvent;
import com.amazen.event_backbone.domain.BackBoneEventLogID;
import com.amazen.kernel.Event;
import com.amazen.kernel.annotations.Repository;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EventLogInMemoryRepository{

    private final Map<BackBoneEventLogID, Event> data;

    public EventLogInMemoryRepository() {
        data = new ConcurrentHashMap<>();
    }

    public BackBoneEventLogID nextID(){
        return new BackBoneEventLogID(LocalDate.now());
    }

    public void add(BackBoneEvent backBoneEvent){
        data.put(backBoneEvent.getId(), backBoneEvent.getEvent());
    }
}
