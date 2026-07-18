package com.phegon.phegonbank.transaction.controller;
import com.phegon.phegonbank.res.Response;
import com.phegon.phegonbank.transaction.dtos.TransactionRequest;
import com.phegon.phegonbank.transaction.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Response<?>> createTransaction(@RequestBody @Valid TransactionRequest transactionRequest) {
        return ResponseEntity.ok(transactionService.createTransaction(transactionRequest));
    }

    @PostMapping("/{accountNumber}")
    public ResponseEntity<Response<?>> getTransactionForMyAccount(
            @PathVariable String accountNumber,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ){
       return ResponseEntity.ok(transactionService.getTransactionForAnAccount(accountNumber, page, size));
    }
}
