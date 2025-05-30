package Deques;

public class ArrayDeque<T> {


	private T[] deque;
	private int front, size;

	public ArrayDeque(int capacity){

		this.deque = (T[]) new Object[capacity];
		this.front = capacity - 1;
	}

	public void addFirst(T data){

		if(isFull())resize();
		front = (front - 1 + deque.length) % deque.length;
		deque[front] = data;
		
		size++;

	}

	public void addLast(T data){

		if(isFull())resize();

		int rear = (front + size) % deque.length;
		deque[rear] = data;

		size++;	

	}

	public T removeFirst(){

		if(isEmpty())return null;

		T toReturn = deque[front];
		deque[front] = null;
		front = (front + 1) % deque.length;
		size--;	
		return toReturn;
	}

    public T removeLast(){
		if(isEmpty())return null;

    	int rear = ((front + size - 1) + deque.length) % deque.length;
    	T toReturn = deque[rear];
    	deque[rear] = null;
    	size--;
    	return toReturn;

    }

    public T peekFirst(){

    	if(isEmpty())return null;

    	return deque[front];
    }

    public T peekLast(){

    	if(isEmpty())return null;

    	return deque[(front + size - 1) % deque.length];
    }

    public boolean isEmpty(){

    	return size == 0;
    }

    public boolean isFull(){

    	return size == deque.length;
    }

    private void resize(){

    	T[] newDeque = (T[]) new Object[deque.length * 2];

    	for(int i = 0; i < size; i++){

    		newDeque[i] = deque[(front + i) % deque.length];

    	}

    	front = 0;
    	deque = newDeque;   	

    }

    public int size(){

    	return size;
    }

    public void display(){


    	System.out.println("Deque (Front to Rear):");
    	if(isEmpty()){

    		System.out.println("[empty]");
    		return;
    	}

    	for(int i = 0; i < size; i++){

    		System.out.print(deque[(front + i) % deque.length] + " ");

    	}

    	System.out.println();

    }



}
