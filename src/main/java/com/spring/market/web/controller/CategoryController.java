package com.spring.market.web.controller;

import com.spring.market.domain.Category;
import com.spring.market.domain.Client;
import com.spring.market.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all-categorys")
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/category={id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") int categoryId){
        return categoryService.getCategory(categoryId)
                .map(category -> new ResponseEntity<>(category,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/active={active}")
    public ResponseEntity<List<Category>> getByActive(@PathVariable("active") boolean active){
        return categoryService.getByActive(active)
                .map(categories -> new ResponseEntity<>(categories,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category),HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.update(category),HttpStatus.OK);
    }

    @DeleteMapping("/delete={id}")
    public ResponseEntity delete(@PathVariable("id") int categoryId){
        if(categoryService.delete(categoryId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
