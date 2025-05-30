package Queues;

public class LinkedListQueue<T> {

	private static class Node<T>{

		T data;
		Node<T> next;

		Node(T data){this.data = data;}
	}

	private Node<T> front;
	private Node<T> rear;
	private int size;

	public void enqueue(T data){

		Node<T> newNode = new Node<>(data);
		if(isEmpty()){

			front = rear = newNode;
			
		} else{
			
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}


	public T dequeue(){

		if(isEmpty())return null;

		T toReturn = front.data;
		front = front.next;
		size--;
		if(front == null)rear = null;
		return toReturn;

	}

	public T peek(){

		if(isEmpty())return null;

		return front.data;
	}

	public boolean isEmpty(){

		return front == null;

	}

	public void display(){

		System.out.print("LinkedListQueue (Front to Rear):");
		if(isEmpty()){

			System.out.println("[empty]");
			return;
		}

	
		Node<T> curr = front;
		while(curr != null){

			System.out.print(curr.data + " ");
			curr = curr.next;
		}

		System.out.println();

	}
    
}
