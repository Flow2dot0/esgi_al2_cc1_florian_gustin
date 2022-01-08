package com.amazen.membership.exposition;

import com.amazen.kernel.CommandBus;
import com.amazen.kernel.MemberID;
import com.amazen.kernel.QueryBus;
import com.amazen.membership.application.CreateMember;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.Objects;

@RestController
public class MemberController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public MemberController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = Objects.requireNonNull(commandBus);
        this.queryBus = Objects.requireNonNull(queryBus);
    }

//    @GetMapping(path = "/members", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<MembersResponse> getAll() {
//
//    }

    @PostMapping(path = "/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> add(@RequestBody @Valid MemberRequest request) {
        CreateMember createMember = new CreateMember(request.email, request.password);
        createMember.apply(request);
        MemberID memberID = commandBus.send(createMember);
        return ResponseEntity.created(URI.create("/members/" + memberID.getId())).build();
    }

}
