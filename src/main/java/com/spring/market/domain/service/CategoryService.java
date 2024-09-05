package com.spring.market.domain.service;

import com.spring.market.domain.Category;
import com.spring.market.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }

    public Optional<List<Category>> getByActive(boolean active){
        return categoryRepository.getByActive(active);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Category update(Category category){
        return categoryRepository.update(category);
    }

    public boolean delete(int categoryId){
        return getCategory(categoryId)
                .map(client -> {
                    categoryRepository.delete(categoryId);
                    return true;
                }).orElse(false);
    }
}
