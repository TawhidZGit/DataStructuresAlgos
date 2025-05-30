package LinkedLists;

public class CircularlyLinkedList<T> {
    
    public static void main(String[] args){

    }


    // Can update the code with checks

	private static class Node<T>{

		T data;
		Node<T> next;

		Node(T data){

			this.data = data;	

		}

	}


	private Node<T> head;
	int size;

	public void prepend(T data){

		
		if(head == null){

			Node<T> newNode = new Node<>(data);
			head = newNode;
			head.next = head;

		} else{

			Node<T> newNode = new Node<>(head.data);
			newNode.next = head.next;
			head.data = data;
			head.next = newNode;
		}

		size++;

	}

	public void append(T data){

		prepend(data);
		head = head.next;

	}

	public void addBeforeData(T data, T targetData){

		if(head == null)return;
		if(head.data.equals(targetData)){
			prepend(data);
			return;
		}

		Node<T> curr = head;
		for(int i = 0; i < size; i++){

			if(curr.next.data.equals(targetData)){

				Node<T> newNode = new Node<>(data);
				newNode.next = curr.next;
				curr.next = newNode;

				size++;
			}

			curr = curr.next;
		}

	}


	public void addAfterData(T data, T targetData){

		if(head == null)return;

		Node<T> curr = head;
		for(int i = 0; i < size - 1; i++){

			if(curr.data.equals(targetData)){

				Node<T> newNode = new Node<>(data);
				newNode.next = curr.next;
				curr.next = newNode;
				size++;
				return;

			}

			curr = curr.next;
		}

		

	}

	public void remove(T data){

		if(head == null)return;

		Node<T> curr = head;
		if(head.data.equals(data)){


			for(int i = 0; i < size - 1; i++){				
				curr = curr.next;
			}

			head = head.next;
			curr.next = curr.next.next;

			size--;
			return;
		}


		for(int i = 0; i < size - 1; i++){


			if(curr.next.data.equals(data)){

				curr.next = curr.next.next;
				size--;
				return;

			}

			curr = curr.next;
		}



	}

	public void removeByIndex(int index){

		if(index < 0 || index >= size)return;

		Node<T> curr = head;
		if(index == 0){

			for(int i = 0; i < size - 1; i++){				
				curr = curr.next;
			}

			head = head.next;
			curr.next = curr.next.next;

			size--;
			return;
		}

		for(int i = 0; i < index - 1; i++){

			curr = curr.next;

		}

		curr.next = curr.next.next;

		size--;

	}

	


	

	public void display(){

		if(head == null)return;

		System.out.print("Head -> ");

		Node<T> curr = head;
		for(int i = 0; i < size - 1; i++){

			System.out.print(curr.data + " -> ");
			curr = curr.next;

		}

		System.out.println("(back to head)");

	}

	// public  void reverse(){

	// 	if(head == null)return;

	// 	Node<T> prev = curr.next;
	// 	Node<T> curr = head;
	// 	Node<T> next = curr.next;
	// 	for(int i = 0; i < size - 1; i++){




	// 		//curr = curr.next;
	// 		//in complete
	// 	}




}
	
