package com.cydeo.repository;

import com.cydeo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, BigInteger> {

    //Write a derived query to get top 5 orders by order by total price desc
    List<Order> getTop5ByOrderByTotalPriceDesc();
    //Write a derived query to get all orders by customer email
    List<Order> getAllByCustomerEmail(String email);
    //Write a derived query to get all orders by specific payment method
    List<Order> findAllByPayment_PaymentMethod(String paymentMethod);
    //Write a derived query to get all orders by specific payment method



    //Write a derived query to get all orders by specific customer email
    List<Order> findAllByCustomer_Email(String email);
    //Write a derived query to check is there any orders by customer email
    Boolean existsByCustomerEmail(String email);
    //Write a native query to get all orders by specific product name
    @Query(value="select * from orders join cart c on cart_id==c.id join cart_item i on i.cart_id==c.id join product on product.id==i.product_id where product.name==?1",nativeQuery = true)
    List<Order> retrieveOrdersByProductName(String productName);
    //Write a native query to get all orders by specific categoryId
    @Query(value="select * from orders join cart c on cart_id==c.id join cart_item i on i.cart_id==c.id join product p on i.product_id = p.id \n" +
            "    join product_category_rel pcr on p.id = pcr.p_id join category on pcr.c_id = category.id where category.id==?1",nativeQuery = true)
    List<Order> retrieveOrdersByCategoryId(Long id);
    //Write a derived query to get all orders by totalPrice and paidPrice are equals

    List<Order>   retrieveAllOrdersBetweenTotalPriceAndPaidPriceIsSame(); //*********
    //Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null

    List<Order> findAllByPaidPriceAndTotalPriceEqualsAndCartDiscountIdIsNull();
    //findAllByPaidPriceAndTotalPriceEqualsAndCartDiscountIdIsNull();
}
