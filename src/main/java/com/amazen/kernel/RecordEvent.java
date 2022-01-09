package com.amazen.kernel;

import java.util.List;

public interface RecordEvent {
    List<DomainEvent> recordedEvents();
}
