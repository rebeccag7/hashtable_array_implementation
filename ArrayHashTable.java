package arrayhashtable;

public class ArrayHashTable {

	int tableSize;
	//Define the hash table which consists of buckets that contains a pointer to an item
	Item hashtable[]; 

	public ArrayHashTable () {
		//define a table size
		tableSize = 4;
		hashtable = new Item[tableSize];
	}

	public int hash(String key) {
		int hashVal = 0;
		int index = key.length();
		char letters[] = key.toCharArray();
		for (int i = 0; i < letters.length; i++) {
			hashVal = hashVal + (int) letters[i];
		}
		//Location where we want to store stuff
		index = hashVal % tableSize;
		return index;
	}

	public void addItem(String name, String drink) {
		int index = hash(name);
		if (hashtable[index] == null) {
			hashtable[index] = new Item (name, drink);
		} else {
			Item ptr = hashtable[index];
			Item newItem = new Item(name, drink);
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = newItem;
		}
	}

	public int noOfItemsInIndex(int index) {
		int count = 0;
		if(hashtable[index] == null) {
			return count;
		} else {
			count++;
			Item ptr = hashtable[index];
			while(ptr.next != null) {
				count++;
				ptr = ptr.next;
			}
		}
		return count;
	}

	public void printTable() {
		int number = 0;
		for(int i = 0; i < tableSize; i++) {
			if(hashtable[i] != null) {
				number = noOfItemsInIndex(i); 
				System.out.println("Index = " + i);
				System.out.println("Name: " + hashtable[i].name + " Drink: " + hashtable[i].drink);
				System.out.println("# of items = " + number);
			}
		}
	}

	public void printItemsInIndex(int index) {
		Item ptr = hashtable[index];
		if (ptr != null) {
			System.out.println(index + " contains the followng items:\n");
			while (ptr != null) {
				System.out.println("Name: " + ptr.name + " Drink: " + ptr.drink);
				ptr = ptr.next;
			}
		}
	}

	public void findDrink(String name) {
		int index = hash(name);
		boolean foundName = false;
		String drink = null;
		Item ptr = hashtable[index];
		while (ptr != null) {
			if (ptr.name == name) {
				foundName = true;
				drink = ptr.drink;
			}
			ptr = ptr.next;
		}
		if(foundName) {
			System.out.println("Favorite Drink: " + drink);
		}
		else {
			System.out.println(name + "'s info was not found in the hashtable.");
		}
	}

	public void removeItem(String name) {
		int index = hash(name);
		// case 0: bucket is empty
		if(hashtable[index] == null) {
			System.out.println(name + " was not found in the hashtable.");
		}
		// case 1: only 1 item in bucket and item has matching name
		else if ((hashtable[index].name.equals(name)) && (hashtable[index].next == null)) {
			System.out.println("In here");
			hashtable[index] = null;
		}
		// case 2: match is located in first item but there are more items in the bucket
		else if  (hashtable[index].name.equals(name)) {
			hashtable[index] = hashtable[index].next;
		}
		// case 3: bucket contains items but first bucket is not a match
		else {
			Item p1 = hashtable[index].next;
			Item p2 = hashtable[index];
			while (p1 != null && p1.name != name) {
				p2 = p1;
				p1 = p1.next;
			}			
			// case 3.1: no match
			if (p1 == null) {
				System.out.println(name + " was not found in the hashtable.");
			}			
			// case 3.2: match is found
			else {
				p1 = p1.next;
				p2.next = p1;
				System.out.println(name + " was removed from the hashtable.");
			}		
		}
	}
}
