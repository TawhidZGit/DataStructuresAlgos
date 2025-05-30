package Stacks;

public class ArrayStack2<T> {
    

	private T[] stack;
	private int capacity;
	private int top;

	@SuppressWarnings("unchecked")
	public ArrayStack2(int capacity){

		this.capacity = capacity;
		this.stack = (T[]) new Object[capacity];
		this.top = -1;


	}


	public void push(T data){

		if(top + 1 == capacity){

			resize();

		}

		stack[++top] = data;

	}

	public T pop(){


		if(isEmpty())return null;

		T toReturn = stack[top];
		stack[top--] = null;
		return toReturn;

	}

	public T peek(){

		if(isEmpty())return null;

		return stack[top];
	}

	public int size(){

		return top + 1;
	}

	public boolean isEmpty(){

		return top == -1;
	}

	@SuppressWarnings("unchecked")
	private void resize(){

		capacity *= 2;
		T[] newStack = (T[]) new Object[capacity];
		for(int i = 0; i < top + 1; i++){

			newStack[i] = stack[i];

		}

		stack = newStack;

	}

	public void printStack(){


		System.out.println("Stack (top to bottom):");
		for(int i = top; i >= 0; i--){

			System.out.println(stack[i]);

		}
		if(isEmpty()){

			System.out.println("[empty]");
		}

	}

}
