package Queues;

public class ArrayQueue2<T> {
    

	private T[] queue;
	private int front, size;


	public ArrayQueue2(int capacity){

		this.queue = (T[]) new Object[capacity];

	}

	public void enqueue(T data){

		if(isFull())resize();
		
		int rear = (front + size) % queue.length;
		queue[rear] = data;
		size++;
		return;

	}

	public T dequeue(){

		if(isEmpty())return null;

		T toReturn = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		size--;
		return toReturn;

	}

	public T peek(){

		if(isEmpty())return null;

		return queue[front];
	}

	public boolean isEmpty(){

		return size == 0;
	}

	public boolean isFull(){

		return size == queue.length;

	}

	public void displayQueue(){

		System.out.print("Queue (Front to Rear):");
		if(isEmpty()){
			System.out.println("[empty]");
			return;
		}

		for(int i = 0; i < size; i++){
			System.out.print(queue[(front + i) % queue.length] + " ");
		}

		System.out.println();

	}

	private void resize(){

		T[] newQueue = (T[]) new Object[queue.length * 2];

		for(int i = 0; i < size; i++){

			newQueue[i] = queue[(front + i) % queue.length];

		}

		queue = newQueue;
		front = 0;

	}

    
}
