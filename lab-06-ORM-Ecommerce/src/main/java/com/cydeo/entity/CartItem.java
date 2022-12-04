package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class CartItem extends BaseEntity {
    private int quantity;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;
}
