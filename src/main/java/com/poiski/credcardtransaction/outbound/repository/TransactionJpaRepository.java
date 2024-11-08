package com.poiski.credcardtransaction.outbound.repository;

import com.poiski.credcardtransaction.core.domain.entity.Transaction;
import com.poiski.credcardtransaction.core.domain.repository.TransactionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionJpaRepository extends TransactionRepository, JpaRepository<Transaction, UUID> {

  @Override
  default List<Transaction> getAll() {
    return findAll();
  }

  @Override
  default Optional<Transaction> getByKey(UUID id) {
    return findById(id);
  }

  @Override
  default Transaction save(Transaction transaction) {
    return save(transaction);
  }
}
