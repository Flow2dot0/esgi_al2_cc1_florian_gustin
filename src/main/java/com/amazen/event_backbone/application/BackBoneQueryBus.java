package com.amazen.event_backbone.application;

import com.amazen.event_backbone.domain.EventLogService;
import com.amazen.kernel.Query;
import com.amazen.kernel.QueryBus;
import com.amazen.kernel.QueryHandler;

import java.util.Map;
import java.util.Objects;

public class BackBoneQueryBus implements QueryBus {

    private final Map<Class<? extends Query>, QueryHandler> data;

    private BackBoneQueryBus(Map<Class<? extends Query>, QueryHandler> data) {
        this.data = Objects.requireNonNull(data);
    }

    public static BackBoneQueryBus of(Map<Class<? extends Query>, QueryHandler> data) {
        return new BackBoneQueryBus(data);
    }

    @Override
    public <Q extends Query, R> R send(Q query) {
        return dispatch(query);
    }

    private <Q extends Query, R> R dispatch(Q query) {
        final QueryHandler queryHandler = data.get(query.getClass());
        if (queryHandler == null) {
            throw new RuntimeException("No such query handler for " + query.getClass().getName());
        }

        return (R) queryHandler.handle(query);
    }
}
