package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.Product;

import com.cydeo.spring05thymeleaf.service.CartService;

import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.UUID;

@Controller

public class cartController {
    private final CartService cartService;


    public cartController(CartService cartService) {
        this.cartService = cartService;

    }


    @GetMapping("/addToCart/{id}/{quantity}")
    public String addCart(@PathVariable ("id") UUID id,@PathVariable("quantity") Integer quantity,Model model){

      model.addAttribute("cart",cartService.addToCart(id,quantity));


       return "/cart/show-cart";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute("cart") Cart cart, Model model){

      model.addAttribute("cartList",cart.getCartItemList());

      model.addAttribute("total",cart.getCartTotalAmount());

        return "/cart/show-cart";
    }
    @GetMapping("/delete/{id}")
    public String deleteCartItem(@PathVariable("id") UUID id,@ModelAttribute("cart") Cart cart){
        cartService.deleteFromCart(id);
        return "/cart/show-cart";
    }

}