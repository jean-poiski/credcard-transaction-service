package com.poiski.credcardtransaction.core.domain.payload;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionPayload {
  private String account;
  private String merchant;
  private String mcc;
  private BigDecimal totalAmount;
}
