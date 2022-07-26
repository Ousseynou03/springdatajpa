package com.org.springdata.service;

import com.org.springdata.model.Product;
import com.org.springdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {

        return productRepository.findAll();
    }
//Récupération de produits de façon unitaire avec la méthode findById()
    public Optional<Product> getProductById(Integer id){
       return productRepository.findById(id);
    }

}
