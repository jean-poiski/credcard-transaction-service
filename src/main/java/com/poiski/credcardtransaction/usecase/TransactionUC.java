package com.poiski.credcardtransaction.usecase;

import com.poiski.credcardtransaction.core.domain.TransactionStatus;
import com.poiski.credcardtransaction.core.domain.entity.Transaction;
import com.poiski.credcardtransaction.core.domain.payload.TransactionPayload;
import com.poiski.credcardtransaction.core.domain.payload.TransactionResponse;
import com.poiski.credcardtransaction.core.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@RequiredArgsConstructor
public class TransactionUC {

  private final TransactionRepository transactionRepository;
  private final AccountUC accountUC;

  public Transaction createTransaction(TransactionPayload payload) {

    Transaction transaction = Transaction.fromPayload(payload);

    transaction.setStatus(
      accountUC.processAmountByMCC(transaction.getAccountId(), transaction.getAmount(), transaction.getMcc()) ?
        TransactionStatus.APPROVED :
        TransactionStatus.REJECTED
    );

    return transactionRepository.save(transaction);
  }

}
