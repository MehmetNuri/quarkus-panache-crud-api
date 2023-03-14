package com.mehmetnuri.service;

import com.mehmetnuri.entity.Category;
import com.mehmetnuri.repository.CategoryRepositoryImpl;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class CategoryService {

    private final CategoryRepositoryImpl categoryRepository;

    public CategoryService(CategoryRepositoryImpl categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category get(Long id) {
        return categoryRepository.findCategoryById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category create(Category category) {
        categoryRepository.save(category);
        return category;
    }

    public Category update(Long id,Category category) {
        Optional<Category> categoryById = categoryRepository.findCategoryById(id);
        Category savedCategory = null;
        if (categoryById.isPresent()) {
           savedCategory =  categoryById.get();
           savedCategory.setName(category.getName());
        } else {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.save(savedCategory);
        return category;
    }

    public void delete(Long id) {
        categoryRepository.deleteMemberById(id);
    }

    public Category getByName(String name) {
        return categoryRepository.findMemberByName(name).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Iterable<Category> getAll() {
        return categoryRepository.findAllCategories();
    }
}
