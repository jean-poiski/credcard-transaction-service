package com.poiski.credcardtransaction.core.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class MerchantMCCUnitTest {

  @ParameterizedTest
  @ValueSource(strings = {"5411", "5412", "5811", "5812"})
  void testFromStringScene(String value) {
    MerchantMCC merchantMCC = MerchantMCC.fromString(value);
    Assertions.assertNotNull(merchantMCC);
  }

  @ParameterizedTest
  @ValueSource(strings = {"4684", "321854165", "ANOTHER", "", " "})
  void testFromStringAlwaysReturnDefaultScene(String value) {
    MerchantMCC merchantMCC = MerchantMCC.fromString(value);
    Assertions.assertEquals(MerchantMCC.DEFAULT_CASH, merchantMCC);
  }

  @ParameterizedTest
  @MethodSource(value = "testFromStringReturnCorrectBalanceTypeScene")
  void testFromStringReturnCorrectBalanceTypeScene(String value, BalanceType balanceType) {
    MerchantMCC merchantMCC = MerchantMCC.fromString(value);
    Assertions.assertEquals(balanceType, merchantMCC.getBalanceType());
  }

  private static Stream<Arguments> testFromStringReturnCorrectBalanceTypeScene() {
    return Stream.of(
      Arguments.of("5411", BalanceType.FOOD),
      Arguments.of("5412", BalanceType.FOOD),
      Arguments.of("5811", BalanceType.MEAL),
      Arguments.of("5812", BalanceType.MEAL)
    );
  }
}
