package com.amazen.membership.application;

import com.amazen.kernel.CommandHandler;
import com.amazen.kernel.Event;
import com.amazen.kernel.EventDispatcher;
import com.amazen.kernel.MemberID;
import com.amazen.membership.domain.cc2.Email;
import com.amazen.membership.domain.cc2.Member;
import com.amazen.membership.domain.cc2.Password;
import com.amazen.membership.infrastructure.MemberInMemoryRepository;

import java.util.Objects;

public class CreateMemberCommandHandler implements CommandHandler<CreateMember, MemberID> {

    private final MemberInMemoryRepository memberRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateMemberCommandHandler(MemberInMemoryRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.memberRepository = memberRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public MemberID handle(CreateMember command) {
        final MemberID id = memberRepository.nextId();
        Member member = new Member(id, Email.of(command.email), Password.of(command.password));
        memberRepository.save(member);
        eventEventDispatcher.dispatch(new CreateMemberEvent(id, ));
        if(Objects.nonNull(command.createContractor)){
            eventEventDispatcher.dispatch(new CreateContractorEvent());
        }else{
            eventEventDispatcher.dispatch(new CreateTradesmanEvent());

        }
        return null;
    }
}
