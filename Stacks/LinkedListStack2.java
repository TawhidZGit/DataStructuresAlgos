package Stacks;

public class LinkedListStack2<T> {


	private static class Node<T>{

		T data;
		Node<T> next;
		Node(T data){this.data = data;} 

	}

	// This constructor is not necessary as it pretty much does nothing different
	// I believe having it may be good practice, so keeping it
	public LinkedListStack2(){

		head = null;
		size = 0;


	}

	private Node<T> head;
	private int size;


	public void push(T data){

		Node<T> newNode = new Node<>(data);
		newNode.next = head;
		head = newNode;
		size++;

	}

	public T pop(){

		if(head == null)return null; 

		T toReturn = head.data;
		head = head.next;
		size--;
		return toReturn;

	}


	public T peek(){

		if(head == null)return null;

		return head.data;

	}

	public boolean isEmpty(){

		return head == null;
	}

	public int size(){

		return size;

	}

	public void display(){

		System.out.println("Stack (from top to bottom):");

		Node<T> curr = head;
		while(curr != null){

			System.out.println(curr.data);

		}

		if(isEmpty()){
			
			System.out.println("[empty]");

		}
		

	}

}