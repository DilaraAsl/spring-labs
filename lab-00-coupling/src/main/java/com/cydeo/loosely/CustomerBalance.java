package com.cydeo.loosely;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@ToString


public class CustomerBalance extends Balance{


    public CustomerBalance(UUID userId, BigDecimal amount) {
        super(userId,amount);

    }

    @Override
    public BigDecimal addBalance(BigDecimal amount) {
        setAmount(getAmount().add(amount));
        return getAmount();
    }
}
