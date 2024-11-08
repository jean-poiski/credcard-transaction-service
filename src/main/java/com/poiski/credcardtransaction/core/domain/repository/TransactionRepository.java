package com.poiski.credcardtransaction.core.domain.repository;


import com.poiski.credcardtransaction.core.domain.entity.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {

  List<Transaction> getAll();

  Optional<Transaction> getByKey(UUID id);

  Transaction save(Transaction transaction);
}
