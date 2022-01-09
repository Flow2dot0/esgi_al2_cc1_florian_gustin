package com.amazen.membership.domain;

import com.amazen.membership.application.CreateTradesmanEvent;
import com.amazen.membership.infrastructure.TradesmanInMemoryRepository;

import java.util.*;

public class TradesmanService {

    private final TradesmanInMemoryRepository repository;

    public TradesmanService(TradesmanInMemoryRepository repository) {
        this.repository = repository;
    }

    public void createTradesman(CreateTradesmanEvent event){
        repository.save(Tradesman.create(event.id, event));
    }
}
