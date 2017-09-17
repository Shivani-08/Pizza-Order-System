package pizzaordersystem.beans;

public class Pizza {

	private int pizzaId;
	private String pizzaName;
	private char size;
	private float price;
	private String pizzaType;

	public Pizza() {
		super();
	}

	public Pizza(int pizzaId, String pizzaName, char size, float price, String pizzaType) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.size = size;
		this.price = price;
		this.pizzaType = pizzaType;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public String toString() {
		return ("Pizza Id : " + pizzaId + "\t|Pizza Name : " + pizzaName + "\t" + "|Size : " + size + "\t|Price : Rs."
				+ price + "\t|Type : " + pizzaType);
	}

}
