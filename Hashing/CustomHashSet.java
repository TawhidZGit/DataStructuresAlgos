package Hashing;

import java.util.Iterator;

public class CustomHashSet<E> {

    
	private static final Object PRESENT = new Object();
	private final CustomHashMap<E, Object> map;

	public CustomHashSet(){

		map = new CustomHashMap<>();

	}

	public boolean add(E element){

		return map.put(element, PRESENT) == null;

	}

	public boolean contains(E element){

		return map.containsKey(element);
	}

	public boolean remove(E element){

		return map.remove(element) != null;
	}

	public int size(){

		return map.size();
	}

	public boolean isEmpty(){
		return map.isEmpty();
	}

	public void clear(){
		map.clear();
	}

	public Iterator<E> iterator(){

		return map.keySet().iterator();
	}

	@Override
	public String toString(){

		StringBuilder sb = new StringBuilder();
		sb.append("[");

		boolean first = true;

		for(E key : map.keySet()){
			if(!first) sb.append(", ");
			sb.append(key);
			first = false;
		}

		sb.append("]");
		return sb.toString();
	}


}
