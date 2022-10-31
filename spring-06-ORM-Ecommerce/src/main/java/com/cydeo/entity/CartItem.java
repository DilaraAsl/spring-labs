package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Data
@Entity
public class CartItem extends BaseEntity {
    private int quantity;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;
}
