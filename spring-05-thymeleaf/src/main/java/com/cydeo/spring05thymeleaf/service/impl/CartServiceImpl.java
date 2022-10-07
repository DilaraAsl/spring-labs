package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static java.math.BigDecimal.*;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method
    // String productName=productService.findProductById(productId).getName();
        //todo initialise cart item
        CartItem cartItem=new CartItem();

        Product product= productService.findProductById(productId);
        BigDecimal productPrice=productService.listProduct().stream().filter(p->p.getId().equals(productId)).map(Product::getPrice).findFirst().orElseThrow().multiply(valueOf(quantity));

      cartItem.setProduct(product);
      cartItem.setQuantity(quantity);
      cartItem.setTotalAmount(productPrice);
      //set the cart item list!!!!!!!!


    CART.getCartItemList().add(cartItem);

      CART.setCartTotalAmount(CART.getCartTotalAmount().add(productPrice));
        return CART;
    }

    @Override
    public void deleteFromCart(UUID productId){
        //todo delete product object from cart using stream

        CART.getCartItemList().removeIf(p->p.getProduct().getId().equals(productId));
        BigDecimal price=productService.findProductById(productId).getPrice().multiply( valueOf (productService.findProductById(productId).getQuantity()));

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(price));



    }
}
