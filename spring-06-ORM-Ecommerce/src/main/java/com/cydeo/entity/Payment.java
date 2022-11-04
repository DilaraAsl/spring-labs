package com.cydeo.entity;

import com.cydeo.enums.PaymentMethod;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Payment extends BaseEntity {
    private Double paidPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
