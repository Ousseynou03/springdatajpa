package com.org.springdata.repository;

import com.org.springdata.model.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
