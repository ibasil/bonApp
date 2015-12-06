package app.services;

import app.dao.ResultDS;
import app.entities.Dish;

import java.util.List;

public interface DishService {

    void create(Dish dish);
    void update(Dish dish);
    Dish findById(Long id);

    List<Dish> findAll();
    List<Dish> findAllActive();
    List<Dish> findAllActive(Long categoryID);
    List<ResultDS> getDishStatusList(Long orderId);

}
