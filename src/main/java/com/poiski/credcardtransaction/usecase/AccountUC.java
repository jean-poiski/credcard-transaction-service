package com.poiski.credcardtransaction.usecase;

import com.poiski.credcardtransaction.core.domain.MerchantMCC;
import com.poiski.credcardtransaction.core.domain.entity.Account;
import com.poiski.credcardtransaction.core.domain.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Lazy
@Service
@RequiredArgsConstructor
public class AccountUC {

  private final AccountRepository accountRepository;

  public boolean processAmountByMCC(UUID accountId, BigDecimal amount, MerchantMCC merchantMCC) {

    Account account = accountRepository.getByKey(accountId);

    if (account != null) {
      boolean toSave = false;

      if (MerchantMCC.DEFAULT_CASH.equals(merchantMCC) || (account.isToUseCashAmount(amount)) && account.getCashAmount().compareTo(amount) >= 0) {
        account.setCashAmount(account.getCashAmount().subtract(amount));
        toSave = true;
      } else {

        switch (merchantMCC.getBalanceType()) {
          case FOOD:
            if (account.getFoodAmount().compareTo(amount) >= 0) {
              account.setFoodAmount(account.getFoodAmount().add(amount));
              toSave = true;
            }
            break;
          case MEAL:
            if (account.getMealAmount().compareTo(amount) >= 0) {
              account.setMealAmount(account.getMealAmount().add(amount));
              toSave = true;
            }
            break;
          default:
            break;
        }
      }

      if (toSave) {
        accountRepository.saveAccount(account);
        return true;
      }
    }

    return false;
  }
}
