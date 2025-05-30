package Deques;

public class LinkedListDeque<T> {


	private static class Node<T>{

		T data;
		Node<T> next;
		Node<T> prev;

		Node(T data){

			this.data = data;

		}


	}

	private Node<T> head, tail;
	private int size;

	public void addFirst(T data){


		Node<T> newNode = new Node<>(data);
		if(isEmpty()){

			head = tail = newNode;
			

		} else{

			newNode.next = head;
			head.prev = newNode;
			head = newNode;

		}

		size++;

	}

	public void addLast(T data){

		Node<T> newNode = new Node<>(data);
		if(isEmpty()){

			head = tail = newNode;
		} else{

			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T removeFirst(){

		if(isEmpty())return null;

		T toReturn = head.data;
		head = head.next;
		if(head != null)head.prev = null;
		else tail = null;
		size--;
		return toReturn;
	}

	public T removeLast(){

		T toReturn = tail.data;
		tail = tail.prev;
		if(tail != null)tail.next = null;
		else head = null;
		size--;

        return toReturn;

	}

	public T peekFirst(){

		if(isEmpty())return null;
		return head.data;
	}

	public T peekLast(){

		if(isEmpty())return null;
		return tail.data;
	}

	public boolean isEmpty(){

		return size == 0;

	}

	public void display(){

		System.out.println("LinkedListDeque (Front to Rear): ");
		if(isEmpty()){
			System.out.println("[empty]");
			return;
		}

		Node<T> curr = head;
		while(curr != null){

			System.out.print(curr.data +  " ");
			curr = curr.next;
		}

		System.out.println();
	}

    
}
