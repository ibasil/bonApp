package app.beans;

import app.entities.Category;
import app.entities.Dish;
import app.services.CategoryService;
import app.services.DishService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Named
@Scope("session")
public class AdminBean implements Serializable{

	private static final long serialVersionUID = 5560419733973127669L;
	private Category category = new Category();
	private Dish dish = new Dish();
	private String categoryString;

	private List<Dish> dishes = new ArrayList<Dish>();
	private List<Category> categories = new ArrayList<Category>();


	@PostConstruct
	public void init() {
		refreshDishes();
		refreshCategories();
	}

	@Inject
	DishService dishService;

	@Inject
	CategoryService categoryService;

	public AdminBean(){
	}
	
	public String save() {

		//Convert LocalDateTime > TimeStamp
		LocalDateTime ldt = LocalDateTime.now();
		Timestamp ts = Timestamp.valueOf(ldt);
		dish.setDateAdded(ts);
		dishService.create(dish);

		return "adminList";
	}

	public String update(Dish dish) {
		dishService.update(dish);
		return "adminAdd";
	}

	public String remove(Dish dish) {
		dishService.update(dish);
		return "adminList";
	}

	public String disable(Dish dish) {
		dishService.disable(dish);
		return "adminList";
	}


	public void refreshDishes() {
		dishes = dishService.getAll();
	}

	public void refreshCategories() {
		categories = categoryService.getAll();
	}

	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public DishService getDishService() {
		return dishService;
	}

	public void setDishService(DishService dishService) {
		this.dishService = dishService;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> kitchen) {
		this.categories = categories;
	}

	public List<Dish> dishes() {
		return dishes;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String getCategoryString() {
		return categoryString;
	}

	public void setCategoryString(String categoryString) {
		this.categoryString = categoryString;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public void setList(List<Dish> dishes) {
		this.dishes = dishes;
	}

}
