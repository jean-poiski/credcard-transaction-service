package com.poiski.credcardtransaction.core.domain.entity;

import com.poiski.credcardtransaction.core.domain.BasicDomain;
import com.poiski.credcardtransaction.core.domain.TransactionStatus;
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
  private String mcc;

  @Builder.Default
  @Enumerated(EnumType.STRING)
  private TransactionStatus status = TransactionStatus.PENDING;

}
