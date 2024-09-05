package com.spring.market.persistence;

import com.spring.market.domain.Category;
import com.spring.market.domain.repository.CategoryRepository;
import com.spring.market.persistence.crud.CategoriaCrudRepository;
import com.spring.market.persistence.entity.Categoria;
import com.spring.market.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        return categoryMapper.toCategorys((List<Categoria>) categoriaCrudRepository.findAll());
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriaCrudRepository.findById(categoryId)
                .map(categoria -> categoryMapper.toCategory(categoria));
    }

    @Override
    public Optional<List<Category>> getByActive(boolean active) {
        Optional<List<Categoria>> categorias = categoriaCrudRepository.findByEstado(active);
        return categorias.map(categorys -> categoryMapper.toCategorys(categorys));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = categoryMapper.toCategoria(category);
        return categoryMapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public Category update(Category category) {
        Categoria categoria = categoryMapper.toCategoria(category);
        return categoryMapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);
    }
}
