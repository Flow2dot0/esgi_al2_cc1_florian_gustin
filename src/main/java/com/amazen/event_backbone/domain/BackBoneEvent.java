package com.amazen.event_backbone.domain;

import com.amazen.kernel.Entity;
import com.amazen.kernel.Event;

@com.amazen.kernel.annotations.Entity
public class BackBoneEvent implements Entity<BackBoneEventLogID> {

    private final BackBoneEventLogID id;
    private final Event event;

    public BackBoneEvent(BackBoneEventLogID id, Event event) {
        this.id = id;
        this.event = event;
    }

    @Override
    public BackBoneEventLogID getId() {
        return id;
    }

    @Override
    public void setId(BackBoneEventLogID eventLogID) {
        throw new UnsupportedOperationException();
    }

    public Event getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "BackBoneEvent{" +
                "id=" + id +
                ", event=" + event +
                '}';
    }
}
