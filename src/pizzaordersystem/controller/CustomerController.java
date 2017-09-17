package pizzaordersystem.controller;

import java.util.ArrayList;
import java.util.Scanner;

import pizzaordersystem.beans.Pizza;
import pizzaordersystem.service.AdminService;

public class CustomerController {
	Scanner sc = new Scanner(System.in);
	public void displayAllPizzas() {
		{
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

	public void orderAnPizza() {
		System.out.println("Here is the list of all the pizzas available in the store:");
		System.out.println("\n");
		displayAllPizzas();
		System.out.println("________________________________________________________________________________");
		System.out.println("Please refer to above list and enter the PizzaID of pizza which you want to order: ");
		int orderId=sc.nextInt();
	
		
		AdminService as = new AdminService();
		Pizza p = as.getPizzaDetails(orderId);
		System.out.println("You Ordered following pizza: \n");
		System.out.println(p.toString());
		System.out.println("Enter the quantity of this pizza");
		int orderNo = sc.nextInt();
		System.out.println("Your Pizza is Successfully Ordered:)");
		int amt;
		float price;
		price = p.getPrice();
		amt = (int) (price*orderNo);
		System.out.println("Your Bill:");
		System.out.println(p.toString()+"\t|Pizza Quantity : " + orderNo );
		System.out.println("___________________________________");
		System.out.println("Your bill amount: Rs."+ amt+ "/-");
		System.out.println("___________________________________");
	}

	public void generateBill() {
		
	}
}
