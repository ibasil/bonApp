package app.services;

import app.entities.Category;
import java.util.List;

public interface CategoryService {

    Category create(Category category);
    Category update(Category category);
    Category findByName(String name);
    Category findById(Long id);

    List<Category> getAllActive();
    List<Category> getAll();
}