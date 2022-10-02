package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.service.CartService;
import com.cydeo.lab04springmvc.service.ProductService;
import com.cydeo.lab04springmvc.service.impl.CartServiceImpl;
import com.cydeo.lab04springmvc.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.cydeo.lab04springmvc.service.impl.ProductServiceImpl.PRODUCT_LIST;

@Controller

public class ProductController {

    @RequestMapping("search-product/{productName}")
    String getProductList(@PathVariable("productName") String productName, Model model){
        ProductService ps=new ProductServiceImpl();
        ps.initialiseProductList();;
        CartService cs=new CartServiceImpl();
        cs.initialiseCartList();
        model.addAttribute("productList",ps.searchProduct(productName));
        return "product/product-list";
    }
}
