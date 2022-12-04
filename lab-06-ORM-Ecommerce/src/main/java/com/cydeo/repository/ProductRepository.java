package com.cydeo.repository;

import com.cydeo.entity.Category;
import com.cydeo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, BigInteger> {
    //Write a derived query to get top 3 product order by price desc
    List<Product> getTop3ByOrderPriceDesc();
    //Write a derived query to get product by specific name
    Product findFirstByName(String productName);
    //Write a derived query to get product by specific category
    List<Product> findAllByIdCategoryListContaining(Category category);

    //Write a derived query to get count by price greater than specific amount
    Integer countByPriceGreaterThan(BigDecimal price);
    //Write a derived query to get all product by quantity greater than or equal specific count
    List<Product> getAllByQuantityGreaterThanEqual(int count);
    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
   @Query(value="select * from product where price>=?1 and remaining_quantity<?2",nativeQuery = true)
    List<Product> retrievePriceGreaterAndQuantityLower(BigDecimal price,int remainingQuantity);
    //Write a native query to get all product by specific categoryId

    @Query(value="select * from product p join product_category_rel pl on pl.p_id = p.id where pl.c_id = ?1",nativeQuery = true)
    List<Product> retrieveBySpecificCategoryId(Long categoryId);
    //Write a native query to get all product by specific categoryId and price greater than specific amount


    @Query(value = "select * from product p join product_category_rel pl on pl.p_id = p.id where pl.c_id in(?1) " +
            " p.price > ?2", nativeQuery = true)
    List<Product> retrieveProductListByCategory(List<Long> categoryId, BigDecimal price);
}
