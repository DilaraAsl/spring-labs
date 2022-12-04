package com.cydeo.repository;

import com.cydeo.entity.Cart;
import com.cydeo.entity.Customer;
import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, BigInteger> {
    //Write a derived query to get all cart by specific discount type
    List<Cart> getCartByDiscount_DiscountType(DiscountType discountType);


    //Write a JPQL query to get all cart by customer

    @Query ("select c from Cart c where c.customer.id= ?1")
    List<Cart> retrieveCartByCustomer(Long id);


    //Write a derived query to get all cart by customer and cart state

    List<Cart> getAllByCustomerIdAndCartState(Long id, CartState state);
    //Write a derived query to get all cart by customer and cart state and discount is null condition

    List<Cart> getAllByCustomerAndCartStateAndDiscountIsNull(Customer customer, CartState state);




    //Write a native query to get all cart by customer and cart state and discount is not null condition

    @Query("select c from Cart c where c.customer.id=?1 and c.cartState=?2 and c.discount.discount is not null")
    List<Cart> retrieveAllByCustomerCartStateDiscountNotNull(Long id, CartState state);

    @Query(value= "SELECT * FROM cart c JOIN customer cu ON c.customer_id = cu.id WHERE c.cart_state = ?1 " +
            "AND cu.id = ?2 AND discount.id <> null", nativeQuery = true)
    List<Cart> findAllByCustomerIdAndCartStateAndDiscountIsNotNull(String cartState, Long id);
}
