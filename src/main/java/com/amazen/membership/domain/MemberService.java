package com.amazen.membership.domain;

import com.amazen.kernel.MemberID;
import com.amazen.membership.application.CreateMemberEvent;
import com.amazen.membership.infrastructure.MemberInMemoryRepository;

import java.util.*;

public class MemberService {

    private final MemberInMemoryRepository repository;

    public MemberService(MemberInMemoryRepository repository) {
        this.repository = repository;
    }

    public void createMember(CreateMemberEvent event){
        repository.save(Member.of(event.getMemberID(), List.of(event)));
    }

    public MemberID getNextId() {
        return repository.nextID();
    }
}
