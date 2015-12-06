package app.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

import app.dao.IDishDao;
import app.dao.ResultDS;
import app.entities.Dish;

@Named
public class DishServiceImpl implements DishService, Serializable {

    @Inject
    private IDishDao dishDao;

    @Transactional
    public void create(Dish dish) {
        dishDao.create(dish);
    }

    @Transactional
    public void update(Dish dish) {
        dishDao.update(dish);
    }

    public Dish findById(Long id) {
        return dishDao.findById(id);
    }

    public List<Dish> getAll() {
        return dishDao.findAll();
    }

    public List<Dish> getAllActive(Long categoryID) {
        return dishDao.findAllActive(categoryID);
    }

    public List<ResultDS> getDishStatusList(Long orderId) {
        return dishDao.getDishStatusList(orderId);
    }

    @Override
    public void disable(Dish dish) {
        dish.setActive(false);
    }

    public List<Dish> getAllActive() {
        return dishDao.findAllActive();
    }
}