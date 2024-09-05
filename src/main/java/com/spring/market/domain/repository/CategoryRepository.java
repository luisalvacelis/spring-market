package com.spring.market.domain.repository;

import com.spring.market.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Category> getAll();
    Optional<Category> getCategory(int categoryId);
    Optional<List<Category>> getByActive(boolean active);
    Category save(Category category);
    Category update(Category category);
    void delete(int categoryId);
}
