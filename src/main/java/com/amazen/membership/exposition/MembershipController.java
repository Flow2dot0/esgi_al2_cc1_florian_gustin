package com.amazen.membership.exposition;

import com.amazen.kernel.CommandBus;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.QueryBus;
import com.amazen.membership.application.CreateMember;
import com.amazen.membership.application.MembershipManager;
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

    public MembershipController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @GetMapping(path = "/memberships", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MembershipsResponse> getAll() {
        return ResponseEntity.ok(new MembershipsResponse(List.of()));
    }

    @PostMapping(path = "/memberships", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MembershipResponse> add(@RequestBody @Valid MembershipRequest request) {
//        MemberID member = membershipManager.createMember(request);
        CreateMember createMember = CreateMember.fromRequest(request);
        MemberID memberID = commandBus.send(createMember);
        return ResponseEntity.created(URI.create("/memberships/" + memberID.getId())).body(new MembershipResponse(memberID.getId(), request.memberType));
    }

}
