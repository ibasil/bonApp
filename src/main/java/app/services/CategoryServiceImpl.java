package app.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import app.dao.ICategoryDao;
import app.entities.Category;
import org.springframework.transaction.annotation.Transactional;


@Named
public class CategoryServiceImpl implements CategoryService, Serializable {

    @Inject
    private ICategoryDao categoryDao;

    public List<Category> getAllActive() {
        return categoryDao.findAllActive();
    }

    public Category findByName(String name) {
        return categoryDao.findByName(name);
    }

    @Transactional
    public Category create(Category category) {
        categoryDao.create(category);
        return category;
    }

    @Transactional
    public Category update(Category category) {
        categoryDao.update(category);
        return category;
    }

    public Category findById(Long id) {
        return categoryDao.findById(id);
    }

    public List<Category> getAll() {
        return categoryDao.findAll();
    }
}