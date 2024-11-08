package com.poiski.credcardtransaction.core.domain;

import org.apache.commons.lang3.StringUtils;

import static com.poiski.credcardtransaction.core.domain.MerchantNameMappingConsts.*;

public final class MerchantMCCWrapper {

  private MerchantMCCWrapper() {
  }

  /**
   * Wrapper para obter o valor adequado do {@link MerchantMCC} conforme o parâmetro que pode ser o nome de um
   * comerciante. Como alguns nomes podem possuir MCC incorretos, é feita essa validação.
   * <p>
   * Os nomes que precisam dessa validação para atribuição adequada do MCC devem ser passados em {@link MerchantNameMappingConsts}
   * </p>
   * @param value valor a ser validado podendo ser o nome de comerciantes ou o MCC numérico
   * @return {@link MerchantMCC}
   */
  public static MerchantMCC fromString(String value) {

    if (StringUtils.isBlank(value) || StringUtils.containsAnyIgnoreCase(value, UBER_TRIP, PICPAY_BILHETEUNICO)) {
      return MerchantMCC.DEFAULT_CASH;
    }

    if (StringUtils.containsIgnoreCase(value, UBER_EATS)) {
      return MerchantMCC.MCC_MEAL;
    }

    if (StringUtils.containsIgnoreCase(value, PAG_JOSESILVA)) {
      return MerchantMCC.MCC_FOOD;
    }


    return MerchantMCC.fromString(value);
  }

}
