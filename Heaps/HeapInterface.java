package Heaps;


public interface HeapInterface<T extends Comparable<T>>{

    public void insert(T data);

    public T poll();
    
    public T peek();

    public int size();

    public boolean isEmpty();







}