package com.cydeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository {
    //Write a derived query to get all cart by specific discount type
    //Write a JPQL query to get all cart by customer
    //Write a derived query to get all cart by customer and cart state
    //Write a derived query to get all cart by customer and cart state and discount is null condition
    //Write a native query to get all cart by customer and cart state and discount is not null condition
}
