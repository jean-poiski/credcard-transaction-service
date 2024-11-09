package com.poiski.credcardtransaction.inbound.rest;

import com.poiski.credcardtransaction.core.domain.TransactionStatus;
import com.poiski.credcardtransaction.core.domain.entity.Transaction;
import com.poiski.credcardtransaction.core.domain.payload.TransactionPayload;
import com.poiski.credcardtransaction.core.domain.payload.TransactionResponse;
import com.poiski.credcardtransaction.usecase.TransactionUC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/transaction")
@RequiredArgsConstructor
public class TransactionController {

  private final TransactionUC transactionUC;

  @PostMapping
  @ResponseStatus(value = HttpStatus.OK)
  public TransactionResponse createTransaction(TransactionPayload payload) {
    try {
      Transaction transaction = transactionUC.createTransaction(payload);
      return TransactionResponse.builder().code(transaction.getStatus().getCode()).build();
    } catch (Exception e) {
      log.error("Error creating transaction", e);
      return TransactionResponse.builder().code(TransactionStatus.FAILED.getCode()).build();

    }
  }
}
