package com.poiski.credcardtransaction.core.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MerchantMCCWrapperUnitTest {

  @ParameterizedTest
  @CsvSource({
    "5411, MCC_FOOD",
    "5412, MCC_FOOD",
    "5811, MCC_MEAL",
    "5812, MCC_MEAL",
    "1234, DEFAULT_CASH",
    ", DEFAULT_CASH",
    "ANOTHER, DEFAULT_CASH",
    "UBER TRIP SAO PAULO BR, DEFAULT_CASH",
    "PICPAY*BILHETEUNICO GOIANIA BR, DEFAULT_CASH",
    "UBER EATS SAO PAULO BR, MCC_MEAL",
    "PAG*JoseDaSilva RIO DE JANEI BR, MCC_FOOD",
  })
  void shouldReturnExpectedMCC(String input, MerchantMCC expected) {
    MerchantMCC result = MerchantMCCWrapper.fromString(input);
    Assertions.assertThat(result).isEqualTo(expected);
  }
}
