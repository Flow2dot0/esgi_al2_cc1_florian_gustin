package com.amazen.event_backbone.domain;

import com.amazen.kernel.ValueObjectId;

import java.time.LocalDate;

public class BackBoneEventLogID implements ValueObjectId<LocalDate> {
    private final LocalDate id;

    public BackBoneEventLogID(LocalDate id) {
        this.id = id;
    }

    @Override
    public LocalDate getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EventLogID{" +
                "id=" + id +
                '}';
    }
}
