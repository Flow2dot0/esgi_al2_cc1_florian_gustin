package com.amazen.event_backbone.infrastructure;

import com.amazen.kernel.Event;
import com.amazen.kernel.annotations.Repository;
import com.amazen.kernel.engines.InMemoryRepositoryEngine;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public class EventLogInMemoryRepository extends InMemoryRepositoryEngine<LocalDate, Event> {

    @Override
    public Event findById(LocalDate localDate) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Event> findAll() {
        return null;
    }

    @Override
    public Event save(Event event) {
        return data.put(nextId(), event);
    }

    @Override
    public void delete(LocalDate localDate) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected LocalDate nextId() {
        return LocalDate.now();
    }
}
