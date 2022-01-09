package com.amazen.subscription.exposition;

import com.amazen.kernel.CommandBus;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.QueryBus;
import com.amazen.membership.application.CreateMember;
import com.amazen.membership.exposition.MembershipRequest;
import com.amazen.membership.exposition.MembershipsResponse;
import com.amazen.subscription.application.RenewSubscriptions;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class SubscriptionController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public SubscriptionController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = Objects.requireNonNull(commandBus);
        this.queryBus = Objects.requireNonNull(queryBus);
    }

    @GetMapping(path = "/subscriptions/renew", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SubscriptionsResponse> getExpiringSubscriptions() {
        RenewSubscriptions renewSubscriptions = new RenewSubscriptions();
        SubscriptionsResponse response = commandBus.send(renewSubscriptions);
        return ResponseEntity.ok(new SubscriptionsResponse(List.of(response)));
    }

}
