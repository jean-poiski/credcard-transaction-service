package com.poiski.credcardtransaction.outbound.repository;

import com.poiski.credcardtransaction.core.domain.entity.Account;
import com.poiski.credcardtransaction.core.domain.repository.AccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountJpaRepository extends AccountRepository, JpaRepository<Account, UUID> {

  @Override
  default Account getByKey(UUID id) {
    return findById(id).orElse(null);
  }

  @Override
  default List<Account> getAll() {
    return findAll();
  }

  @Override
  default Account saveAccount(Account account) {
    return save(account);
  }
}
