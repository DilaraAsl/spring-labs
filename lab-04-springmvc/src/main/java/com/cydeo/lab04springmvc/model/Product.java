package com.cydeo.lab04springmvc.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter

public class Product {
    private UUID id;
    private Integer remainingQuantity;
    private Integer quantity;
    private BigDecimal price;
    private String name;
}
