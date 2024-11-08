package com.poiski.credcardtransaction.core.domain;

import lombok.Getter;

@Getter
public enum TransactionStatus {

  PENDING("99"),
  APPROVED("00"),
  REJECTED("51"),
  FAILED("07");

  private final String code;

  TransactionStatus(String code) {
    this.code = code;
  }

}
