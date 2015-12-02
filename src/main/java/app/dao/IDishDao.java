package app.dao;

import app.entities.Dish;
import java.util.List;

public interface IDishDao extends IDao<Dish, Long> {

    List<Dish> findAllActive(Long categoryID);
    List<ResultDS> getDishStatusList(Long orderId);
    List<Dish> findAllActive();

}
