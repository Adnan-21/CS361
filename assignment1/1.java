package adnan;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomBag<Item> implements Iterable<Item> {

	private Item []bag;
	private int bagSize = 0;
	
	//Constructor - this creates an array of size of and initialized bagsize to 0
	public RandomBag() {
		bag = (Item[])new Object[5];
		bagSize = 0;
	}
	
	public int size() {
	    return bagSize; 
	}
	
	public boolean isEmpty() {
		return (bagSize == 0);
	}
	
	public void add(Item item) {
		// We check if bag is full. If it is full, we allocate a new bag of 2xbagSize size and copy the existing items into new bag.
		if(bagSize == bag.length-1) {
			// New bag allocated
			Item []newBag = (Item[])new Object[bagSize*2];
			// Copied to new bag.
			System.arraycopy(bag, 0, newBag, 0, bagSize);
			bag = newBag;
		}
		// Add the new item here.
		bag[bagSize] = item;
		bagSize++;
	}
	@Override 
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		// Return iterator for a new class which iterates randomly
		return new RandomIterator(); 
	}

	private class RandomIterator implements Iterator<Item> {
		private int current;

		// Initializes current to 0.
		public RandomIterator() {
			current = 0;
		}
		@Override
		// Will return if whether we have more elements or not.
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != bagSize;
		}

		@Override
		// Here, next would be random element in the array
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new NoSuchElementException();
			Random rand = new Random();
			// Here, we get a random index
			current = rand.nextInt(bagSize);
			// Next, we fetch the element using this random index and return it.
			Item item = bag[current]; 
	        return item;
		}
		
	}
}
