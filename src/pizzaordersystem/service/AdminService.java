package pizzaordersystem.service;

import java.util.ArrayList;

import pizzaordersystem.beans.Pizza;
import pizzaordersystem.dao.AdminDao;

public class AdminService {

	public String addPizza(Pizza p) {
		return (new AdminDao().addPizza(p));
	}

	public ArrayList<Pizza> showAllPizza() {
		return (new AdminDao().showAll());
	}

	public boolean deletePizza(int pid) {
		return (new AdminDao().delete(pid));
	}

	public Pizza getPizzaDetails(int pid) {
		return (new AdminDao().getPizzaDetails(pid));
	}

	public boolean updatePizza(Pizza p) {
		return (new AdminDao().update(p));
	}

}
