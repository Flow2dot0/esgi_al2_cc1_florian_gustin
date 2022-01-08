package com.amazen._securepal.exposition;

import com.amazen._securepal.domain.SecureTransactionService;
import com.amazen._securepal.domain.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SecureTransactionController {

    private final SecureTransactionService service;

    public SecureTransactionController(SecureTransactionService service) {
        this.service = service;
    }

    @PostMapping(path = "/payment-request", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> paymentRequest(@RequestBody @Valid Transaction transaction) {
        try {
            var res = service.process(transaction);
            return ResponseEntity.status(HttpStatus.OK).body(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
