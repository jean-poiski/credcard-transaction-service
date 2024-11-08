package com.poiski.credcardtransaction.core.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

public enum MerchantMCC {

  MCC_FOOD(new String[]{"5411", "5412"}, BalanceType.FOOD),
  MCC_MEAL(new String[]{"5811", "5812"}, BalanceType.MEAL),
  DEFAULT_CASH(new String[]{""}, BalanceType.CASH);

  private final String[] value;

  @Getter
  private final BalanceType balanceType;

  MerchantMCC(String[] value, BalanceType balanceType) {
    this.value = value;
    this.balanceType = balanceType;
  }

  /**
   * Retorna o MCC correspondente ao value com base nos valores numericos.
   * Para validação obter o valor externamente, deve passar pela classe MerchantMCCWrapper
   * @see MerchantMCCWrapper
   * @param value (preferencialmente numérico)
   * @return MCC correspondente ao value como números
   */
  static MerchantMCC fromString(String value) {
    return Stream.of(MerchantMCC.values())
      .filter(mcc -> Arrays.asList(mcc.value).contains(value))
      .findFirst()
      .orElse(DEFAULT_CASH);
  }

}
