package com.poiski.credcardtransaction.core.domain.entity;

import com.poiski.credcardtransaction.core.domain.BasicDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account implements BasicDomain {
  @Id
  private UUID id;
  private String cardNumber;
  private BigDecimal foodAmount;
  private BigDecimal mealAmount;
  private BigDecimal cashAmount;

  public boolean isToUseCashAmount(BigDecimal amount) {
    return (foodAmount.compareTo(amount) < 0 || mealAmount.compareTo(amount) < 0);
  }

}
