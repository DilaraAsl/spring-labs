package com.cydeo.repository;

import com.cydeo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CustomerRepository extends JpaRepository<Customer, BigInteger> {
    //Write a derived query to get all customer by id
    //Write a JPQL query to get customer by email
}
