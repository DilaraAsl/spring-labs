package com.cydeo.repository;

import com.cydeo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, BigInteger> {


    //Write a derived query to get category by name
    Category findByName(String name);

    //Write a derived query to get top 3 categories order by name desc
    List<Category> findTop3ByOrderByNameDesc();
}
