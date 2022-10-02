package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Cart;
import com.cydeo.lab04springmvc.model.Product;
import com.cydeo.lab04springmvc.service.CartService;
import com.cydeo.lab04springmvc.service.ProductService;
import com.cydeo.lab04springmvc.service.impl.CartServiceImpl;
import com.cydeo.lab04springmvc.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller


public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("cart-list")
    String getCartList( Model model) {
    // Added CartService as a field in this class and CartController constructor  receives cartService obj
        model.addAttribute("cartList",cartService.retrieveCartList());
        //    model.addAttribute("cart",cart);
        return "cart/cart-list";
    }
    @RequestMapping("cart-list/{id}")
    String getDetailView(@PathVariable("id") String id, Model model){


        model.addAttribute("cartItemList",cartService.retrieveCartDetail(UUID.fromString(id)));


        return "cart/cart-detail";
    }


}
