package com.cydeo.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {
    private String name;
    private BigDecimal price;
    private int quantity;
    private int remainingQuantity;
    @ManyToMany
    @JoinTable(name="product_category_rel",     // third table created by spring rel means relationship
            joinColumns = @JoinColumn(name="p_id"),
    inverseJoinColumns = @JoinColumn(name="c_id"))

    private List<Category> categoryList;

}
