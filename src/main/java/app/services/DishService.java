package app.services;

import app.dao.ResultDS;
import app.entities.Dish;

import java.util.List;

public interface DishService {

    void create(Dish dish);
    void update(Dish dish);
    Dish findById(Long id);

    List<Dish> getAll();
    List<Dish> getAllActive();
    List<Dish> getAllActive(Long categoryID);
    List<ResultDS> getDishStatusList(Long orderId);

    void disable(Dish dish);
}
