package com.mehmetnuri.repository;

import com.mehmetnuri.entity.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryRepositoryImpl implements PanacheRepository<Category>, CategoryRepository {

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return findByIdOptional(id);
    }

    @Override
    public List<Category> findAllCategories() {
        return findAll().list();
    }

    @Override
    @Transactional
    public void save(Category category) {
        persistAndFlush(category);
    }

    @Override
    public Optional<Category> findMemberByName(String name) {
        return find("name = ?1", name).stream().findFirst();
    }

    @Override
    @Transactional
    public boolean deleteMemberById(Long id) {
        return deleteById(id);
    }
}
