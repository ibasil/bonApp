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
public class DishServiceImpl implements IDishService, Serializable {

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

    public List<Dish> findAll() {
        return dishDao.findAll();
    }

    public List<Dish> findAllActive(Long categoryID) {
        return dishDao.findAllActive(categoryID);
    }

    public List<ResultDS> getDishStatusList(Long orderId) {
        return dishDao.getDishStatusList(orderId);
    }

    public List<Dish> findAllActive() {
        return dishDao.findAllActive();
    }
}