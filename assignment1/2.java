package adnan;

import java.util.Iterator;
import java.util.LinkedList;

public class Deque<Item> implements Iterable<Item>{
	
	private LinkedList<Item> deque;
	public Deque() {
		deque = new LinkedList<Item>(); 
	}
	
	boolean isEmpty() {
		// This will return true if size of deque is 0 i.e. it is empty
		return (deque.size() == 0);
	}
	
	int size() {
		return deque.size();
	}
	
	void pushLeft(Item item) {
		// We will insert at index 0 making sure we insert at the left most end
		deque.add(0, item);
	}
	
	void pushRight(Item item) {
		// We will insert at last index making sure we insert at the right most end
		deque.add(deque.size()-1, item);
	}
	
	Item popLeft() {
		// Here, we remove the leftmost element i.e. element stored at index 0 and return it
		return deque.remove(0);
	}
	
	Item popRight() {
		// Here, we remove the rightmost element i.e. element stored at index size-1 and return it
		return deque.remove(deque.size()-1);
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
