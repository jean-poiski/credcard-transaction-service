package com.poiski.credcardtransaction.core.domain.repository;


import com.poiski.credcardtransaction.core.domain.entity.Account;

import java.util.List;
import java.util.UUID;

public interface AccountRepository {

  Account getByKey(UUID id);

  List<Account> getAll();

  Account saveAccount(Account account);


}