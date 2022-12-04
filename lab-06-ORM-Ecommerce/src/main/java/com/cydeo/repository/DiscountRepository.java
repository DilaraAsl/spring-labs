package com.cydeo.repository;

import com.cydeo.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, BigInteger> {

    //Write a derived query to get discount by name
    Discount getFirstByName(String discountName);
    //Write a derived query to get all discounts greater than discount amount
    List<Discount> getAllByDiscountGreaterThan(int discountAmount);
    //Write a derived query to get all discounts by specific discount type
    List<Discount> getAllByDiscountType(String discountType);

    //Write a JPQL query to get all discounts amount between range of discount amount

    @Query("select d from Discount d where d.discount between ?1 and ?2")
    List<Discount> retrieveDiscountsInRange(int discountAmount1,int discountAmount2);

}
