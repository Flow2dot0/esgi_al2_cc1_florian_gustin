package com.amazen.membership.exposition;

import com.amazen.kernel.CommandBus;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.QueryBus;
import com.amazen.membership.application.CreateMember;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.net.URI;
import java.util.Objects;

@RestController
public class MembershipController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public MembershipController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = Objects.requireNonNull(commandBus);
        this.queryBus = Objects.requireNonNull(queryBus);
    }

    @GetMapping(path = "/memberships", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MembershipsResponse> getAll() {
        return ResponseEntity.ok(new MembershipsResponse(List.of()));
    }

    @PostMapping(path = "/memberships", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> add(@RequestBody @Valid MembershipRequest request) {
        CreateMember createMember = CreateMember.fromRequest(request);
        MemberID memberID = commandBus.send(createMember);
        return ResponseEntity.created(URI.create("/members/" + memberID.getId())).build();
    }

}
