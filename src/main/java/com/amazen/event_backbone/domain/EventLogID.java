package com.amazen.event_backbone.domain;

import com.amazen.kernel.ValueObjectId;

import java.time.LocalDate;
import java.util.Objects;

public class EventLogID implements ValueObjectId<LocalDate> {
    private final LocalDate id;

    public EventLogID() {
        this.id = LocalDate.now();
    }

    @Override
    public LocalDate getId() {
        return id;
    }
}
