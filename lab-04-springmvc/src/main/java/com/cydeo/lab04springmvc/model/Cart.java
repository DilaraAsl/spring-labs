package com.cydeo.lab04springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter


public class Cart {
   private UUID id;
   private BigDecimal cartTotalAmount;
   private List<CartItem> cartItemList;
}
