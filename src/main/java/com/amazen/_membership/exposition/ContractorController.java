package com.amazen._membership.exposition;

import com.amazen._membership.domain.Contractor;
import com.amazen._membership.domain.ContractorId;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class ContractorController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;



    @GetMapping(path = "/contractors", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ContractorsResponse> getAll(){
        final List<Contractor> contractors = queryBus.send(new RetrieveContractors());
        ContractorsResponse response = new ContractorsResponse();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/contractors", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ContractorResponse> get(){
        final List<Contractor> contractors = queryBus.send(new RetrieveContractors());
        ContractorsResponse response = new ContractorsResponse();
    }

    @PostMapping(path = "/contractor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> add(@RequestBody @Valid ContractorRequest request) {
        CreateContractor createContractor = new CreateContractor(request.lastname, request.firstname, new Address(request.address.city));
        ContractorId contractorId = commandBus.send(createContractor);
        return ResponseEntity.created(URI.create("/contractors/" + contractorId.getId())).build();
    }

}
