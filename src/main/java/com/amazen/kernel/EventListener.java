package com.amazen.kernel;

public interface EventListener<E extends Event> {
    void listen(E event);
}
