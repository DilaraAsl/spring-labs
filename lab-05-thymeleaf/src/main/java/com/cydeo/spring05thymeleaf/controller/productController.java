package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.repository.impl.ProductRepositoryImpl;
import com.cydeo.spring05thymeleaf.service.ProductService;
import com.cydeo.spring05thymeleaf.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
//@RequestMapping("/product")
public class productController {

private final ProductService productService;

    public productController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create-product")
    public String createProduct(Model model){


  // we are creating a product object
        model.addAttribute("product",new Product());

        return "/product/create-product";
    }
    @PostMapping("/create-product")
    public String addProduct(@ModelAttribute("product") Product product){
        // empty product object is passed to add product from create product
        // all fields are set when the user enters the data
        if(productService.productCreate(product)){
       productService.listProduct().add(product);
       return "redirect:/list";}// if true redirect to the end point
        return "/product/create-product";
    }
    @GetMapping("/list")
    public String listProduct(Model model) {
        model.addAttribute("productList",productService.listProduct());
                return "/product/list";
    }


}
