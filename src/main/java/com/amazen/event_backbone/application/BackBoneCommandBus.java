package com.amazen.event_backbone.application;

import com.amazen.kernel.Command;
import com.amazen.kernel.CommandBus;
import com.amazen.kernel.CommandHandler;

import java.util.Map;
import java.util.Objects;

public class BackBoneCommandBus implements CommandBus {
    private final Map<Class<? extends Command>, CommandHandler> data;

    private BackBoneCommandBus(Map<Class<? extends Command>, CommandHandler> data) {
        this.data = Objects.requireNonNull(data);
    }

    public static BackBoneCommandBus create(Map<Class<? extends Command>, CommandHandler> data) {
        return new BackBoneCommandBus(data);
    }

    @Override
    public <C extends Command, R> R send(C command) {
        return dispatch(command);
    }

    private <C extends Command, R> R dispatch(C command) {
        final CommandHandler commandHandler = data.get(command.getClass());
        if (commandHandler == null) {
            throw new RuntimeException("No such command handler for " + command.getClass().getName());
        }

        return (R) commandHandler.handle(command);
    }
}
