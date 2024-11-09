package com.poiski.credcardtransaction.core.domain.entity;

import com.poiski.credcardtransaction.core.domain.BasicDomain;
import com.poiski.credcardtransaction.core.domain.MerchantMCC;
import com.poiski.credcardtransaction.core.domain.MerchantMCCWrapper;
import com.poiski.credcardtransaction.core.domain.TransactionStatus;
import com.poiski.credcardtransaction.core.domain.payload.TransactionPayload;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction implements BasicDomain {

  @Id
  private UUID id;
  private BigDecimal amount;
  private String merchant;
  private UUID accountId;

  @Enumerated(EnumType.STRING)
  private MerchantMCC mcc;

  @Builder.Default
  @Enumerated(EnumType.STRING)
  private TransactionStatus status = TransactionStatus.PENDING;

  public static Transaction fromPayload(TransactionPayload payload) {
    return Transaction.builder()
        .id(UUID.randomUUID())
        .amount(payload.getTotalAmount())
        .merchant(payload.getMerchant())
        .accountId(UUID.fromString(payload.getAccount()))
        .mcc(MerchantMCCWrapper.fromString(payload.getMcc()))
        .build();
  }

}
