package arrayhashtable;

public class Item {
    String name;
    String drink;
    Item next;
    
    public Item(String name, String drink) {
    	this.name = name;
    	this.drink = drink;
    	this.next = null;
    }
}
