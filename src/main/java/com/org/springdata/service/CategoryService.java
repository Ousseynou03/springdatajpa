package com.org.springdata.service;

import com.org.springdata.model.Category;
import com.org.springdata.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategories(){

        return categoryRepository.findAll();
    }

    public Optional<Category> getCategorieById(Integer id){

        return categoryRepository.findById(id);
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
    //Suppression d'un Categorie
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
