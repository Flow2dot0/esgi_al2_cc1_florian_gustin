package com.amazen.membership.application;

import com.amazen.kernel.CommandHandler;
import com.amazen.kernel.Event;
import com.amazen.kernel.EventDispatcher;
import com.amazen.kernel.MemberID;
import com.amazen.membership.domain.*;

import java.util.Objects;
import java.util.stream.Collectors;

public class CreateMembershipCommandHandler implements CommandHandler<CreateMember, MemberID> {

    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateMembershipCommandHandler(MembershipManager membershipManager, EventDispatcher<Event> eventEventDispatcher) {

        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public MemberID handle(CreateMember command) {
        final MemberID id = new MemberID(1);
        eventEventDispatcher.dispatch(new CreateMemberEvent(id, Email.of(command.email), Password.of(command.password)));
        if (Objects.nonNull(command.createContractor)) {
            eventEventDispatcher.dispatch(new CreateContractorEvent(id, new Company(CompanyID.of(command.createContractor.getCompanyID()), command.createContractor.getName(), Address.of(command.createContractor.getAddress(), City.valueOf(command.createContractor.getCity().toUpperCase())))));
        } else {
            eventEventDispatcher.dispatch(new CreateTradesmanEvent(id, Address.of(command.createTradesman.address, City.valueOf(command.createTradesman.city.toUpperCase())), FullName.of(command.createTradesman.firstname, command.createTradesman.lastname), command.createTradesman.skills.stream().map(s -> Skill.valueOf(s.toUpperCase())).collect(Collectors.toList())));
        }
        return id;
    }
}
