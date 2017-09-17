package pizzaordersystem;

import java.util.Scanner;

import pizzaordersystem.controller.*;
import pizzaordersystem.dao.AdminDao;

public class PizzaOrderMain {
	static String username, password;
	static Scanner sc = new Scanner(System.in);
	static String adminId = "Admin", adminPwd = "Admin123",custId = "Cust", custPwd="Cust123";
	static AdminDao adminDao=new AdminDao(); 

	
	public static boolean checkAdmin() {
		System.out.println("Enter Admin Id : ");
		String adminId = sc.next();
		System.out.println("Enter Password : ");
		String adminPwd = sc.next();
		if (PizzaOrderMain.adminId.equals(adminId) && PizzaOrderMain.adminPwd.equals(adminPwd)) {
			return true;
		}
		return false;
	}
	

	public static boolean checkCustomer() {
		System.out.println("Enter Customer Id : ");
		String custId = sc.next();
		System.out.println("Enter Password : ");
		String custPwd = sc.next();
		if (PizzaOrderMain.custId.equals(custId) && PizzaOrderMain.custPwd.equals(custPwd)) {
			return true;
		}
		return false;
	}

	public static int showAdminMenu() {
		System.out.println("\n****************ADMIN MENU*******************\n");
		System.out.println("Press 1 : Insert Pizza");
		System.out.println("Press 2 : Update Pizza");
		System.out.println("Press 3 : Delete Pizza");
		System.out.println("Press 4 : Show All Pizzas");
		System.out.println("Press 5 : Log Out");
		System.out.println("\n*********************************************\n");
		return sc.nextInt();
	}
	
		public static int showCustomerMenu() {
		System.out.println("\n****************CUSTOMER MENU*******************\n");
		System.out.println("Press 1 : Display All Pizzas");
		System.out.println("Press 2 : Order An Pizza");
		/*System.out.println("Press 3 : Display Bill");*/
		System.out.println("Press 3 : Log Out");
		System.out.println("\n***********************************************\n");
		return sc.nextInt();

	}
	
	public static void main(String args[]) {
		while (true) {
			System.out.println("|*!*| WELCOME TO PIZZA ORDERING SYSTEM |*!*|");
			System.out.println("Choose User: \n");
			System.out.println("Press 1 if you are an Administrator");
			System.out.println("Press 2 if you are a Customer");
			System.out.println("----------------------------------");
			System.out.println("Enter Your Choice: \n");
			
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1:
				System.out.println("-----You chose Administrator-----");
				if (checkAdmin()) {
					System.out.println("*******WELCOME ADMIN********");
					AdminController a = new AdminController();
					while (true) {
						int choice = showAdminMenu();
						switch (choice) {
						case 1:
							a.insertPizza();
							break;
						case 2:
							a.updatePizza();
							break;
						case 3:
							a.deletePizza();
							break;
						case 4:
							a.showAllPizza();
							break;
						case 5:
							System.out.println("Logged Out");
							break;
						default:
							System.out.println("Invalid Choice!!!");
						}
						if (choice == 5)
							break;
					}
				} else {
					System.out.println("Sorry !!!!!!!!!!");
				}
				break;
			case 2:
			{
				System.out.println("-----You chose Customer-----");
				if (checkCustomer()) {
				System.out.println("*******WELCOME CUSTOMER********");
					CustomerController c = new CustomerController();
					while (true) {
						int choice = showCustomerMenu();
						switch (choice) {
						case 1:
							c.displayAllPizzas();
							break;
						case 2:
							c.orderAnPizza();
							break;
						/*case 3:
							c.generateBill();
							break;*/
						case 3:
							System.out.println("Logged Out");
							break;
						default:
							System.out.println("Invalid Choice!!!");
						}
						if (choice == 3)
							break;
					}
				}
			}
				break;
			default:
				System.out.println("Invalid Choice!!!");
			}
		}
	}
}