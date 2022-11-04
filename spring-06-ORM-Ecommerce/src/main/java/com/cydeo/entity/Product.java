package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Product extends BaseEntity {
    private String name;
    private Double price;
    private int quantity;
    private int remainingQuantity;

  @ManyToMany
  @JoinTable(name="product_category_rel", joinColumns = @JoinColumn( name="p_id"),inverseJoinColumns = @JoinColumn(name="c_id"))
    private List<Category> category;

}
