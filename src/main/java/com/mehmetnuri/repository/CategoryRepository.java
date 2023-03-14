package com.mehmetnuri.repository;

import com.mehmetnuri.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Optional<Category> findCategoryById(Long id);

    Optional<Category> findMemberByName(String username);

    List<Category> findAllCategories();

    boolean deleteMemberById(Long id);

    void save(Category member);
}
