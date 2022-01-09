package com.amazen.billing.exposition;

import com.amazen.billing.application.BillingManager;
import com.amazen.billing.application.CreateSubscription;
import com.amazen.kernel.CommandBus;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.QueryBus;
import com.amazen.billing.application.RenewSubscriptions;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
public class SubscriptionController {

    private final CommandBus commandBus;


    public SubscriptionController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping(path = "/subscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriptionResponse> add(@RequestBody @Valid SubscriptionRequest request){
        CreateSubscription createSubscription = new CreateSubscription(request.memberID, request.memberType);
        MemberID memberID = commandBus.send(createSubscription);
        return ResponseEntity.ok(new SubscriptionResponse(memberID.getId()));
    }

    @GetMapping(path = "/subscriptions/renew", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SubscriptionsResponse> getExpiringSubscriptions() {
        RenewSubscriptions renewSubscriptions = new RenewSubscriptions();
        SubscriptionsResponse response = commandBus.send(renewSubscriptions);
        return ResponseEntity.ok(response);
    }

}
