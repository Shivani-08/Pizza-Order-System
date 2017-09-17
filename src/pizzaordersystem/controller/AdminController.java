package pizzaordersystem.controller;

import java.util.ArrayList;
import java.util.Scanner;

import pizzaordersystem.beans.Pizza;
import pizzaordersystem.service.AdminService;

public class AdminController {
	private String pizzaName, pizzaType;
	private char size;
	private float price;
	private static Scanner sc = new Scanner(System.in);
		
	public void insertPizza() {
		System.out.println("---------------Enter Pizza Details----------------");
		System.out.print("Enter Pizza Name	:");
		pizzaName = sc.next();
		System.out.print("Enter Pizza Size	:");
		System.out.println("S (for small) / M (for medium) /L (for large)");
		size = sc.next().toCharArray()[0];
		System.out.print("Enter Pizza Price	:");
		price = sc.nextFloat();
		System.out.print("Enter Pizza Type	:");
		System.out.println("(Veg/Non-Veg)");
		pizzaType = sc.next();

		Pizza p;
		p = new Pizza();
		p.setPizzaName(pizzaName);
		p.setSize(size);
		p.setPrice(price);
		p.setPizzaType(pizzaType);
		
		AdminService as = new AdminService();
		System.out.println(as.addPizza(p));

	}

	public void updatePizza() {
		System.out.println("Enter Pizza Id which you want to update : ");
		int pid = sc.nextInt();

		AdminService as = new AdminService();
		Pizza p = as.getPizzaDetails(pid);
		if (p != null) {
			System.out.println("*****Enter new details of Pizza*****");
			System.out.println("Pizza id\t:" + p.getPizzaId());
			System.out.println("Enter new name of Pizza\t:");
			p.setPizzaName(sc.next());
			System.out.println("Enter new size of Pizza\t:");
			p.setSize(sc.next().charAt(0));
			System.out.println("Enter new price of Pizza\t:");
			p.setPrice(sc.nextFloat());
			System.out.println("Enter new type of Pizza\t:");
			p.setPizzaType(sc.next());

			if (as.updatePizza(p))
				System.out.println("-----------Updated Successfully--------");

			else
				System.out.println("----------Error in Updation--------");
		}

		else
			System.out.println("----------Cannot perform updation as pizza for entered pizzaId not present----------");
	}

	public void deletePizza() {
		System.out.println("Enter Pizza Id which you want to delete : ");
		int pid = sc.nextInt();

		AdminService as = new AdminService();
		if (as.deletePizza(pid))
			System.out.println("---Deleted Successfully---");

		else
			System.out.println("---Error Occured Can't Perform Delete Operation---");
	}

	public void showAllPizza() {
		System.out.println("Showing All Pizzas");
		System.out.println("----------------------------------");
		AdminService as = new AdminService();
		ArrayList<Pizza> pizzaList = as.showAllPizza();

		if (!pizzaList.isEmpty()) {
			for (Pizza p : pizzaList) {
				if (p != null)
					System.out.println(p.toString());
				else {
					System.out.println("-----NO PIZZAS FOUND------");
					break;
				}
			}

		} else
			System.out.println("-----NO PIZZAS FOUND------");

	}
}