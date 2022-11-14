package com.cydeo.repository;

import com.cydeo.entity.CartItem;
import com.cydeo.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    //Write a derived query to get count cart items
    Integer countAllBy(); //countCartItemBy-- we don't have to mention cart item because we are already in that repo
    //Write a derived query to get cart items for specific cart state
    List<CartItem> findAllByCart_CartState(CartState state);
    //Write a native query to get cart items for specific cart state and product name

    @Query(value="select * where cart_item join cart on cart_item.cart_id==cart_id where cart_state=?1 " +
            "and join product on cart_item.product.id==product.id where product_name==?2",nativeQuery = true)
    List<CartItem> returnCartItemsCartStateAndProductName(CartState state,String productName);

    //Write a native query to get cart items for specific cart state and without discount

    @Query(value="select * where cart_item join cart on cart_item.cart_id==cart_id where cart_state=?1 and discount_id==null",nativeQuery = true)
    List<CartItem> returnCartItemByCartStateNoDiscount(CartState state);
    //Write a native query to get cart items for specific cart state and with specific Discount type

    @Query(value="SELECT * FROM cart_item ci JOIN cart c ON  ci.cart_id=c.id JOIN discount d ON c.discount_id =d.id " +
            "WHERE c.cart_state=?1 AND d.discount_type = ?2", nativeQuery = true)
    List<CartItem> retrieveCartItemsByCartStateAndDiscountType(@Param("cartState") String cartState, @Param("discountType") String discountType);

}
