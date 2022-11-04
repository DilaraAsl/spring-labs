package com.cydeo.repository;

import com.cydeo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CategoryRepository extends JpaRepository<Category, BigInteger> {
}
