package com.cydeo.loosely;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@ToString
public class GiftCardBalance extends Balance{

    public GiftCardBalance(UUID userId, BigDecimal amount) {
        super(userId,amount);

    }

    @Override
    public BigDecimal addBalance(BigDecimal amount) {
        return null;
    }
}
