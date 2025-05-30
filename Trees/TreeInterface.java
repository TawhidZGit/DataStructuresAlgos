package Trees;

public interface TreeInterface<T extends Comparable<T>> {

    public boolean isEmpty();

    public boolean search(T data);

    public T getMax();

    public T getMin();

    public void traverse();

    public void insert(T data);

    public void delete(T data);

   

    

    



}