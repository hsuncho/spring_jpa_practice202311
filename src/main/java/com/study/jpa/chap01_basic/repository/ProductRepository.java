package com.study.jpa.chap01_basic.repository;

import com.study.jpa.chap01_basic.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // extends JpaRepository<fist, second>: will use JPA
    // first generic value = entity type
    // type of primary key of the entity given as the first generic value

    // nothing written here but able to use methods in JpaRepository


}
