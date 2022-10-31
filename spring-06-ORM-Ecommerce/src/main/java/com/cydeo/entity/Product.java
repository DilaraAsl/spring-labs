package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private List<Category> category;

}
