package arrayhashtable;

public class Test {

	public static void main(String[] args) {
		ArrayHashTable ht = new ArrayHashTable();
		ht.addItem("Paul", "Locha");
		ht.addItem("Kim", "Iced Mocha");
		ht.addItem("Emma", "Strawberry Smoothy");
		ht.addItem("Annie", "Hot Chocolate");
		ht.addItem("Sarah", "Passion Tea");
		ht.addItem("Pepper", "Caramel Mocha");
		ht.addItem("Mike", "Chai Tea");
		ht.addItem("Steve", "Apple Cider");
		ht.addItem("Bill", "Root Beer");
		ht.addItem("Marie", "Skinny Latte");	
		ht.addItem("Susan", "Water");
		ht.addItem("Joe", "Green Tea");
		ht.printTable();
		ht.printItemsInIndex(2);
		ht.removeItem("Susan");
		ht.printItemsInIndex(2);
		ht.removeItem("Susan");
		// ht.printItemsInIndex(0);
		// ht.findDrink("Mik");
		// int index = ht.hash("Rebecca");
		// System.out.println("index = " + index);
		// ht.removeItem("Kim"); // case 1
		// ht.printTable();
		// ht.removeItem("Kim"); // case 0
		// ht.removeItem("Paul");// case 2
		// ht.printTable();
	}

}
